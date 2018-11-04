package com.example.common.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@CustomerValidator
public @interface DateString {
    String pattern() default "yyyy-MM-dd HH:mm:ss";

    String errorCode() default "must date";

    String message() default "must be date pattern";
}