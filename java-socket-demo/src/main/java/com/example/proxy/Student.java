package com.example.proxy;

/**
 * @author sh 2018/11/7 10:25
 * @version ideaIU-2018.2.5.win
 */

public class Student implements Person{


    public void sayHello(String content, int age) {
        // TODO Auto-generated method stub
        System.out.println("student say hello" + content + " "+ age);
    }


    public void sayGoodBye(boolean seeAgin, double time) {
        // TODO Auto-generated method stub
        System.out.println("student sayGoodBye " + time + " "+ seeAgin);
    }

}
