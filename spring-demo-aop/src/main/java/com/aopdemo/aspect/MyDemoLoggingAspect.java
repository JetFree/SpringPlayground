package com.aopdemo.aspect;

import com.aopdemo.Account;
import com.aopdemo.runners.MainDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(0)
public class MyDemoLoggingAspect {

    private static int adviceCounter = 0;
    private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Before("com.aopdemo.AopExpressions.forDaoPackagesAndNoGettersOrSetters()")
    public void beforeEveryMethodAdvice(JoinPoint theJointPoint) {
//      Access to method signature
        MethodSignature methodSignature = (MethodSignature) theJointPoint.getSignature();
        myLogger.info("Method: " + methodSignature);
//      Displaying arguments
        Object[] args = theJointPoint.getArgs();
        for (Object arg : args) {
            myLogger.info(arg.toString());
        }
        adviceCounter++;
        myLogger.info(getClass().toString() +
                String.format("=======> Executing @Before advice for every method except getters and setters:" +
                        " Advice run %s times", adviceCounter));
    }

    @Around("execution(* com.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJointPoint) throws Throwable {
        String method = theProceedingJointPoint.getSignature().toShortString();
        myLogger.info("\n=========>>>> Executing @Around on method: " + method);
        long begin = System.currentTimeMillis();
        Object result = theProceedingJointPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        myLogger.info("\n=========>>>> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }

    @AfterReturning(pointcut = "com.aopdemo.AopExpressions.forFindAccountsMethod()", returning = "result")
    public void logTheResult(JoinPoint theJointPoint, List<Account> result) {
        MethodSignature signature = (MethodSignature) theJointPoint.getSignature();
        myLogger.info(String.format("===============EXECUTION @AfterReturning ADVICE for method: %s===============", signature));
        myLogger.info("Result of execution findAccounts method: " + result);
    }

    @AfterThrowing(pointcut = "com.aopdemo.AopExpressions.forFindAccountsMethod()", throwing = "exc")
    public void logException(Exception exc) {
        myLogger.info(String.format("===============EXECUTION @AfterThrowing advice. Exception : %s===============", exc));
    }

    @After("com.aopdemo.AopExpressions.forFindAccountsMethod()")
    public void logThatMethodIsFinished(JoinPoint theJointPoint) {
        MethodSignature methodSignature = (MethodSignature) theJointPoint.getSignature();
        myLogger.info(String.format("===============EXECUTION @After FINALLY ADVICE for method: %s===============", methodSignature));
    }
}
