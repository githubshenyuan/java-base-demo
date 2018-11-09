package com.example.genericity;

public class GenericityMethodDemo<E> {

    public <T> T get(T... name) {
        for (T t : name) {
            System.out.println(t);
            return t;
        }
        return null;
    }

    public E set(E age) {
        return age;
    }
}
