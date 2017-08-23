package com.example.demo.common;

import java.lang.annotation.*;

/**
 * Created by Utopia on 2017/8/23.
 * 自定义切点注解，被注解方法将调用切面
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AopAspectAnnotation {
    String description()  default "注解方式实现Aop";
}
