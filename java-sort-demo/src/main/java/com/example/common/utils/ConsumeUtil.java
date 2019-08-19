package com.example.common.utils;

import java.util.HashMap;
import java.util.Map;

public class ConsumeUtil {
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void inti() {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            threadLocal.set(new HashMap<String, Object>());
        }
    }

    public static void initConsume() {
        inti();
        Map<String, Object> map = threadLocal.get();
        Object o = map.get("consume");
        if (o == null) {
            map.put("consume", (Integer) 0);
        }
    }

    public static void increase() {
        Map<String, Object> map = threadLocal.get();
        int i = (Integer) map.get("consume");
        map.put("consume", (Integer) i + 1);
    }

    public static int getValue() {
        return getValue("consume");
    }


    public static int getValue(String key) {
        Map<String, Object> map = threadLocal.get();
        Object o = map.get(key);
        return (Integer) o;
    }

    public static void main(String[] args) {
        ConsumeUtil.initConsume();
        ConsumeUtil.increase();
        ConsumeUtil.increase();
        ConsumeUtil.increase();
        System.out.println(ConsumeUtil.getValue("consume"));

    }
}
