package com.example.rpc;

import com.example.proxy.DynamicProxy;
import com.example.rpc.registry.ServiceRegistry;
import com.example.service.CalculatorService;
import com.example.service.impl.CalculatorServiceImpl;
import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 客户端代理
 * @author sh 2018/11/7 14:21
 * @version ideaIU-2018.2.5.win
 */
public class RpcClient {
    public static CalculatorService  getProxy(final Class<?> clazz ) {
        InvocationHandler invocationHandler = new DynamicProxy(CalculatorServiceImpl.class,"127.0.0.1",8888);
        return (CalculatorService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), invocationHandler);
    }
    public static void main(String[] args) {
        CalculatorService calculatorService = RpcClient.getProxy(CalculatorServiceImpl.class);
        calculatorService.plus(1, 2);
    }
}
