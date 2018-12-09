package com.example.test;

import java.util.ServiceLoader;

/**
 * @author sh on 2018/12/1 16:08
 * @version ideaIU-2018.2.3.win_home
 */
public class TestMyServiceLoader {
    public static void main(String[] argus){
        ServiceLoader<IMyServiceLoader> serviceLoader = ServiceLoader.load(IMyServiceLoader.class);
        for (IMyServiceLoader myServiceLoader : serviceLoader){
            System.out.println(myServiceLoader.getName() + myServiceLoader.sayHello());
        }
    }
}

