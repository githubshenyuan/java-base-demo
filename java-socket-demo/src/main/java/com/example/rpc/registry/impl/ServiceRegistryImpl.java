package com.example.rpc.registry.impl;

import com.example.rpc.registry.ServiceRegistry;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sh 2018/11/7 11:30
 * @version ideaIU-2018.2.5.win
 */
public class ServiceRegistryImpl implements ServiceRegistry {
    private static final Map<String, Class> serverRegistry = new HashMap<String, Class>();

    /**
     * 注册
     * @param clazz
     */
    public void registry(Class clazz) {
        // 注册类
        serverRegistry.put(clazz.getName(), clazz);
    }


    /**
     * 启动服务监听
     */
    public void run(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        while (true) {
            try {
                socket = serverSocket.accept();
                in = new ObjectInputStream(socket.getInputStream());

                String serverName = in.readUTF();
                String methonName = in.readUTF();
                Class<?>[] paramterTypes = (Class<?>[]) in.readObject();
                Object[] args = (Object[]) in.readObject();

                Class serverClass = serverRegistry.get(serverName);

                Method method = serverClass.getMethod(methonName, paramterTypes);
                int i = (Integer) method.invoke(args);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeInt(i);
                objectOutputStream.flush();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

}
