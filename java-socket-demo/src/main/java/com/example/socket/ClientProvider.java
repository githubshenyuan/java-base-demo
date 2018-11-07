package com.example.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author sh 2018/11/6 22:32
 * @version ideaIU-2018.2.5.win
 */
public class ClientProvider {

    public static void main(String[] args) throws IOException {
        // 新建socket 连接
        Socket socket = new Socket("127.0.0.1", 8888);
        try {
            // 输出流 发送数据
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeInt(1);
            objectOutputStream.writeInt(2);
            objectOutputStream.flush();
            // 输入流 接受返回
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            int a = in.readInt();
            System.out.println(a);
            // 关闭流
            objectOutputStream.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
