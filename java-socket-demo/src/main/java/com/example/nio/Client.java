package com.example.nio;

import javax.net.SocketFactory;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    Socket socket;
    OutputStream out;
    InputStream in;

    public Client() throws IOException {
        socket = SocketFactory.getDefault().createSocket();
        socket.setTcpNoDelay(true);
        socket.setKeepAlive(true);
        InetSocketAddress server = new InetSocketAddress("localhost", 8081);
        socket.connect(server, 10000);
        out = socket.getOutputStream();
        in = socket.getInputStream();
    }


    public void send(String message) throws IOException {
        byte[] data = message.getBytes();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(data.length);
        dos.write(data);
        out.flush();
    }


    public static void main(String[] args) throws IOException {
        int n = 200;
        Client client = new Client();
        try {
            client.send("_xiaomiemie");

            DataInputStream inputStream = new DataInputStream(client.in);
            int dataLength = inputStream.readInt();
            byte[] data = new byte[dataLength];
            inputStream.readFully(data);
            client.socket.close();
            System.out.println("receive from server: dataLength=" + data.length);
        } catch (Exception e) {
            e.printStackTrace();

        }



    }
}
