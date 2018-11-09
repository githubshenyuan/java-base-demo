package com.example;

import com.example.proxy.DynamicProxy;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import java.lang.reflect.Proxy;

public class demo {
    public static void main(String[] args) {
        Class<UserServiceImpl> clazz = UserServiceImpl.class;
        Class<?>[] in = clazz.getInterfaces();
        for (Class<?> aClass : in) {
            System.out.println(aClass.toString());
        }
        DynamicProxy dynamicProxy = new DynamicProxy();
        UserService userService1 = (UserService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), dynamicProxy);

        userService1.getUser("xiaoming");

    }
}
