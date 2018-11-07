package com.example.rpc;

import com.example.rpc.registry.ServiceRegistry;
import com.example.rpc.registry.impl.ServiceRegistryImpl;
import com.example.service.impl.CalculatorServiceImpl;

import java.security.spec.PSSParameterSpec;

/**
 * 服务注册和监听
 * @author sh 2018/11/7 14:20
 * @version ideaIU-2018.2.5.win
 */
public class RpcServer {
    public static void main(String[] args) throws Exception {

        ServiceRegistry serviceRegistry = new ServiceRegistryImpl();
        serviceRegistry.registry(CalculatorServiceImpl.class);
        serviceRegistry.run(8888);
    }
}
