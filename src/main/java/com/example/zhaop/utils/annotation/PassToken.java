package com.example.zhaop.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE}) //注解的作用目标
@Retention(RetentionPolicy.RUNTIME) //注解的保留位置
public @interface PassToken {

    boolean required() default true;
}