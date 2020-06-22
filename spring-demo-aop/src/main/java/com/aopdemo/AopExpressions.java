package com.aopdemo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(public * com.aopdemo.dao.*.*(..))")
    public void forAopDemoPackages() {};


    @Pointcut("execution(public * *Api())")
    public void forAllApiMethods() {};

    @Pointcut("execution( public * get*())")
    public void getters() {};

    @Pointcut("execution( public * set*())")
    public void setters() {};

    @Pointcut("forAopDemoPackages() && !(getters() || setters())")
    public void forDaoPackagesAndNoGettersOrSetters() {};

    @Pointcut("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void forFindAccountsMethod() {};
}
