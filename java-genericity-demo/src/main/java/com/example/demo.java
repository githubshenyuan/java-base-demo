package com.example;

import com.example.genericity.GenericityDemo;
import com.example.genericity.GenericityMethodDemo;

import java.math.BigDecimal;

public class demo {
    public static void main(String[] args) {

        GenericityDemo<?> genericityDemo = new GenericityDemo<Object>();
        GenericityMethodDemo genericityMethodDemo = new GenericityMethodDemo<String>();
        Object o = genericityMethodDemo.get(2121,1.2,new BigDecimal("2134.3243"));
        System.out.println(o.getClass());

    }
}
