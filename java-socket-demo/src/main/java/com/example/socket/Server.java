package com.example.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8787);

        while (true) {
            System.out.println("开始监听");
            Socket accept = serverSocket.accept();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader( accept.getInputStream()));
                 OutputStream outputStream = accept.getOutputStream()){
                String line = null;
                while (!(line = bufferedReader.readLine()).equals("")) {
                    System.out.println(line);
                }

                outputStream.write("中国".getBytes());
                outputStream.flush();
            }

            System.out.println("结束");

        }


    }
}
