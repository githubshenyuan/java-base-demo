package com.example.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommonDemo {

    public static void main(String[] args) {
        System.out.println("");

        HashMap hashMap = new HashMap();
        hashMap.put("1", "aaa");
        hashMap.put("2", "aaa");
        hashMap.put("3", "aaa");
        hashMap.put("4", "aaa");
        hashMap.put("5", "aaa");
        hashMap.put("6", "aaa");
        hashMap.put("7", "aaa");
        hashMap.put("8", "aaa");
        hashMap.put("9", "aaa");
        hashMap.put("10", "aaa");
        hashMap.put("11", "aaa");
        hashMap.put("12", "aaa");
        hashMap.put("13", "aaa");
        hashMap.put("14", "aaa");
        hashMap.put("15", "aaa");
        hashMap.put("16", "aaa");
        hashMap.put("17", "aaa");

        System.out.println(hashMap);

        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("", "");

        System.out.println("");

    }
}
