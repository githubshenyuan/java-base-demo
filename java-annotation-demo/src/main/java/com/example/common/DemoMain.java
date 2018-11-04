package com.example.common;

import com.example.entity.Form;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoMain {
    public static void main(String[] args) {
        Form form = new Form();
        List<Field> fields = new ArrayList<Field>();
        Class a = form.getClass();
        Collections.addAll(fields, a.getDeclaredFields());

    }
}
