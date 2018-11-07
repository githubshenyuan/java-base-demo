package com.example.rpc.registry;

import java.io.IOException;

/**
 * @author sh 2018/11/7 11:29
 * @version ideaIU-2018.2.5.win
 */
public interface ServiceRegistry {

    public void registry(Class clazz);
    public void run(int port) throws Exception;
}
