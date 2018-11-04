package com.example.common.parser;

import com.example.common.annotation.Injection;
import com.example.entity.User;

import java.lang.reflect.Method;

public class InjectionParser {
    public static User Create() {
        User user = new User();
        Method[] methods = User.class.getMethods();
        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Injection.class)) {
                    Injection injection = method.getAnnotation(Injection.class);
                    method.invoke(user, injection.value());

                }
            }

        } catch (Exception e) {
            System.out.println("");
        }
        return user;
    }

}
