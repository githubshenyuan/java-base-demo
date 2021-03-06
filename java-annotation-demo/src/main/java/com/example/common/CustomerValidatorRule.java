package com.example.common;

import org.springframework.validation.Errors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface CustomerValidatorRule {

    /**
     * 判断是否支持该注解
     *
     * @param annotation
     * @param property
     * @return
     */
    public boolean support(Annotation annotation);

    /**
     *  校验处理
     *
     *
     * @param annotation
     * @param field
     * @param errors
     */
    public void valid(Annotation annotation, Object object, Field field, Errors errors)
            throws Exception;
}
