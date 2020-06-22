package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiLoggingAspect {

    @Before("com.aopdemo.AopExpressions.forAllApiMethods()")
    public void beforeApiMethodAdvice() {
        System.out.println(getClass().toString() + "=====> Executing @Before method advice before API method");
    }
}
