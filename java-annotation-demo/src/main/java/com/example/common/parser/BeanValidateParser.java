package com.example.common.parser;


import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanValidateParser {

    public void valid(Annotation annotation, Object target, final Field field, Errors errors) throws Exception{

        PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(target.getClass(), field.getName());
        Method reader = propertyDescriptor.getReadMethod();
        Object property = reader.invoke(target);
    }

    private void preHandle(Annotation annotation, Object target, Field field, Errors errors) {
        Assert.notNull(target);
        Assert.notNull(annotation);
        Assert.notNull(errors);
        Assert.notNull(field);
    }
}
