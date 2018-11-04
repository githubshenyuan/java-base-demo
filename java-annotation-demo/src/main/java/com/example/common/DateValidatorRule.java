package com.example.common;

import com.example.common.annotation.CustomerRule;
import com.example.common.annotation.DateString;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@CustomerRule
public class DateValidatorRule extends AbastractCustomerValidatorRule {
    public boolean  support(Annotation annotation) {
        return annotation instanceof DateString;
    }

    /**
     * 验证参数是否正确
     * @param annotation
     * @param property
     * @param postHandler
     */
    @Override
    public void validProperty(Annotation annotation, Object property, PostHandler postHandler) {
        DateString ds = (DateString) annotation;
        if (parse(ds.pattern(), (String) property) == null) {
            postHandler.postHanle(ds.errorCode(), ds.message());
        }
    }

    /**
     *
     * @param pattern
     * @param property
     * @return
     */
    private Date parse(String pattern, String property) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(property);
        } catch (ParseException e) {
            //do noting
        }
        return null;
    }
}
