package com.example.service.impl;

import com.example.service.ServiceLoadTestService;

/**
 * @author sh on 2018/12/1 15:55
 * @version ideaIU-2018.2.3.win_home
 */
public class GenericServiceLoadTestServiceImpl implements ServiceLoadTestService {
    @Override
    public String sayHello() {
        System.out.println("通用 hello");
        return "generic hello";
    }

    @Override
    public String sayWorld() {
        System.out.println("通用 word");
        return "generic world";
    }
}
