package com.example.common;

import com.example.entity.Form;
import com.example.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class CustomerValidatorConfigTest {
    @Autowired
    private CustomerValidatorFactory customerValidatorFactory;

    @Test
    public void setApplicationContext() {
        Form form = new Form();
        User user = new User();
        user.setUaerName("xoaming");
        user.setPassword("pass");

        form.setCurrent("1992-2-3 11:11:11");
        form.setUser(user);

        BindException errors;
        errors = new BindException(form, "target");
        customerValidatorFactory.validate(form, errors);
        System.out.println(errors.getFieldErrors());
    }
}