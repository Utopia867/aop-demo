package com.example.demo.common;

import com.example.demo.entity.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Utopia on 2017/8/23.
 * 定义切面
 */
@Aspect
@Component
public class AopAspect {

    @After(value = "@annotation(aopAspectAnnotation)" )
    public void logPointcut(JoinPoint joinPoint, AopAspectAnnotation aopAspectAnnotation) throws Throwable{
        System.out.println("####################################### 进入切面 #####################################");
        Object[] args = joinPoint.getArgs();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("当前方法："+methodName+"/n"+"参数："+Arrays.toString(args));

    }
}
