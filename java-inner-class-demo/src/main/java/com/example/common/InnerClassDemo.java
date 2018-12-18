package com.example.common;

/**
 * @author sh on 2018/12/15 22:55
 * @version ideaIU-2018.2.3.win_home
 */
public class InnerClassDemo {
    private String uuid = "hello";

    public InnerClassDemo(String uuid) {
        this.uuid = uuid;
    }
    // 内部类
    class Inner {
        private String uuid = "inner hello";
        void pri() {
            System.out.println(uuid);
        }

    }
}
