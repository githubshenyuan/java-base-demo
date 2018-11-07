package com.example.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author sh 2018/11/7 9:54
 * @version ideaIU-2018.2.5.win
 */
public class DynamicProxy implements InvocationHandler
{
    //　这个就是我们要代理的真实对象
    private Class clazz;
    private String host;
    private int port;
    public DynamicProxy(Class clazz,String host, int port) {
        this.clazz = clazz;
        this.host = host;
        this.port = port;
    }
    public Object invoke(Object object, Method method, Object[] args)
            throws Throwable
    {
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            socket = new Socket(host, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeUTF(clazz.getName());
            out.writeUTF(method.getName());
            out.writeObject(method.getParameterTypes());
            out.writeObject(args);
            out.flush();

            in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

}
