package com.example.socket;

import com.example.service.CalculatorService;
import com.example.service.impl.CalculatorServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sh 2018/11/6 22:30
 * @version ideaIU-2018.2.5.win
 */
public class ServerConsumer {

    public static void main(String[] args) throws IOException {
        // 新建监听
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = null;
        while (true) {
            // 接受一个连接，没有则等待，会阻塞
            socket = serverSocket.accept();
            System.out.println(socket.getPort()+""+socket.getInetAddress());
            // 输入流
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            // 输入流读取客户端传入的数据
            int a = objectInputStream.readInt();
            int b = objectInputStream.readInt();
            // 输出流
            CalculatorService calculatorService = new CalculatorServiceImpl();
            int num = calculatorService.plus(a, b);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeInt(num);
            out.flush();
            System.out.println("结束");
        }


    }
}
