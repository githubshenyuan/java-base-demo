package com.example.common;

import com.example.common.annotation.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
public class CustomerValidatorFactory implements Validator {
    @Autowired
    private CustomerValidatorConfig customerValidatorConfig;

    /**
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    public boolean supports(Class<?> clazz) {
        return true;
    }

    /**
     * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
     */
    public void validate(Object target, Errors errors) {
        Assert.notNull(target);
        Assert.notNull(errors);
        // 获取对象 字段
        List<Field> fileds = getFields(target.getClass());
        // 字段循环
        for (Field field : fileds) {
            // 获取字段上所有的注解
            Annotation[] annotations = field.getAnnotations();
            // 循环注解
            for (Annotation annotation : annotations) {
                // 判断是否是 CustomerValidator 注解
                if (annotation.annotationType().getAnnotation(CustomerValidator.class) != null) {
                    try {
                        // 查找到处理该注解的 规则
                        CustomerValidatorRule customerValidatorRule = customerValidatorConfig
                                .findRule(annotation);
                        if (customerValidatorRule != null) {
                            customerValidatorRule.valid(annotation, target, field, errors);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    /**
     * 获取class的fields。
     *
     * @param clazz bean所在的class
     * @return
     */
    private List<Field> getFields(Class<? extends Object> clazz) {
        // 声明Field数组
        List<Field> fields = new ArrayList<Field>();

        // 如果class类型不为空
        while (clazz != null) {
            // 添加属性到属性数组
            Collections.addAll(fields, clazz.getDeclaredFields());
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
}
