package com.example.genericity;

public class GenericityDemo<T> {
    public T get(T name) {
        System.out.println(name);
        return name;
    }
}
