package com.example.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author sh 2018/11/7 10:26
 * @version ideaIU-2018.2.5.win
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;
    private String host;
    private int port;

    public MyInvocationHandler(Object object,String host,int port){
        this.object = object;
        this.host = host;
        this.port = port;

    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            socket = new Socket(host, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeUTF(object.getClass().getName());
            out.writeUTF(method.getName());
            out.writeObject(method.getParameterTypes());
            out.writeObject(args);
            out.flush();

            in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception e) {

            e.printStackTrace();
        }
        //通过反射调用 被代理类的方法
        method.invoke(object, args);
        System.out.println("MyInvocationHandler invoke end");
        return null;
    }



}
