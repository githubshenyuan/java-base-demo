package com.example.proxy;

import com.example.service.CalculatorService;
import com.example.service.impl.CalculatorServiceImpl;

import javax.security.auth.Subject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author sh 2018/11/7 9:52
 * @version ideaIU-2018.2.5.win
 */
public class ProxyDemo {
    public static void main(String[] args) {
        // 代理的真是对象
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        // 获取当前线程的 c
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Class<?>[] interfaces = calculatorService.getClass().getInterfaces();
        MyInvocationHandler dynamicProxy = new MyInvocationHandler(calculatorService,"127.0.0.1",8888);

        CalculatorService ca = (CalculatorService)Proxy.newProxyInstance(classLoader, interfaces, dynamicProxy);

        int c = ca.plus(1, 2);
        System.out.println("获取到的信息："+c);

    }
}
