package com.example.service.impl;

import com.example.service.ServiceLoadTestService;

/**
 * @author sh on 2018/12/1 15:58
 * @version ideaIU-2018.2.3.win_home
 */
public class SpecificServiceLoadServiceImpl implements ServiceLoadTestService {
    @Override
    public String sayHello() {
        System.out.println("特殊 hello");
        return "specific hello";
    }

    @Override
    public String sayWorld() {
        System.out.println("特殊 world");
        return "specific world";
    }
}
