package com.example.common;

import com.example.common.annotation.CustomerRule;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerValidatorConfig implements ApplicationContextAware {
    private Map<Annotation, CustomerValidatorRule> rules = new ConcurrentHashMap<Annotation, CustomerValidatorRule>();

    Map<String, Object>customerValidationRules = null;

    /**
     * 获取所有 带有注解 CustomerRule 的类
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        customerValidationRules = applicationContext
                .getBeansWithAnnotation(CustomerRule.class);
        System.out.println(customerValidationRules);
    }

    /**
     * 查看校验规则中是否支持该注解
     * @param annotation
     * @return
     */
    private CustomerValidatorRule findFormMap(Annotation annotation) {
        for (Map.Entry<String, Object> entry : customerValidationRules.entrySet()) {
            if (entry.getValue() != null
                    && ((CustomerValidatorRule) entry.getValue()).support(annotation)) {
                return (CustomerValidatorRule) entry.getValue();
            }
        }
        return null;
    }

    /**
     * 查找注解的 规则
     * @param annotation
     * @return
     */
    public CustomerValidatorRule findRule(Annotation annotation) {
        System.out.println(annotation);
        CustomerValidatorRule customerValidatorRule = null;
        if (!rules.containsKey(annotation)) {
            CustomerValidatorRule cvr = findFormMap(annotation);
            if (cvr != null) {
                rules.put(annotation, cvr);
            }
            customerValidatorRule = cvr;
        }
        customerValidatorRule = rules.get(annotation);
        return customerValidatorRule;
    }
}
