package com.example.controller;

import com.example.service.ServiceLoadTestService;

import java.util.ServiceLoader;

/**
 * @author sh on 2018/12/1 16:00
 * @version ideaIU-2018.2.3.win_home
 */
public class ValiServiceLoadController {
    public static void main(String[] args) {

        ServiceLoader<ServiceLoadTestService> serviceLoadTestServices = ServiceLoader.load(ServiceLoadTestService.class);
        System.out.println(serviceLoadTestServices);
        for (ServiceLoadTestService serviceLoadTestService : serviceLoadTestServices) {
            serviceLoadTestService.sayHello();
            serviceLoadTestService.sayWorld();
        }
    }
}
