package com.example;

import com.example.entity.UserEntity;
import com.sun.org.apache.xpath.internal.operations.String;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {


        Class clazz = UserEntity.class;
        Field[] fields = clazz.getDeclaredFields();
        UserEntity userEntity = new UserEntity();
        for (Field field : fields) {
            System.out.println(field);
        }
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
    }
}
