package com.example.common;

import com.example.common.parser.InjectionParser;
import com.example.entity.User;

import java.beans.PropertyDescriptor;

public class AnnotationDemo {
    public static void main(String[] args) {

        User user = InjectionParser.Create();
        System.out.println();

    }
}
