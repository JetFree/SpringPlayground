package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudAspect {

    /** Examples:
     @Before("execution(public void add*())")
     @Before("execution(public void com.aopdemo.dao.AccountDAO.add*())")
     @Before("execution(public * com.aopdemo.dao.AccountDAO.add*())")
     @Before("execution(public * com.aopdemo.dao.AccountDAO.add*(com.aopdemo.Account))") */
    @Before("com.aopdemo.AopExpressions.forAopDemoPackages()")
    public void beforeEveryMethodInPackage() {
        System.out.println(getClass().toString() + "=======> Executing @Before method advice for every method in package");
    }
}
