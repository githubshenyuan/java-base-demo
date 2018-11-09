package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理方法被调用");
        return null;
    }
}
