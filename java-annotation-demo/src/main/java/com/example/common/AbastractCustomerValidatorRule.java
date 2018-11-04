package com.example.common;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class AbastractCustomerValidatorRule implements CustomerValidatorRule {

    public abstract boolean support(Annotation annotation);

    public void valid(Annotation annotation, Object target, final Field field, final Errors errors)
            throws Exception {
        preHandle(annotation, target, field, errors);
        PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(target.getClass(),
                field.getName());
        Method reader = propertyDescriptor.getReadMethod();
        Object property = reader.invoke(target);
        validProperty(annotation, property, new PostHandler() {

            public void postHanle(String errorCode, String message) {
                errors.rejectValue(field.getName(), errorCode, message);
            }
        });
    }

    public static interface PostHandler {
        public void postHanle(String errorCode, String message);
    }
    /**
     *
     */
    private void preHandle(Annotation annotation, Object target, Field field, Errors errors) {
        Assert.notNull(target);
        Assert.notNull(annotation);
        Assert.notNull(errors);
        Assert.notNull(field);
    }


    public abstract void validProperty(Annotation annotation, Object property,
                                       PostHandler postHandler);
}
