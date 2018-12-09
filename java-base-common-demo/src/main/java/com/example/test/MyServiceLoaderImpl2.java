package com.example.test;

/**
 * @author sh on 2018/12/1 16:07
 * @version ideaIU-2018.2.3.win_home
 */
public class MyServiceLoaderImpl2 implements IMyServiceLoader {
    @Override
    public String sayHello() {
        return "hello2";
    }

    @Override
    public String getName() {
        return "name2";
    }
}

