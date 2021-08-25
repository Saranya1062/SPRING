package com.sf.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    //@Before("execution(* add*())")     //  * --> wildcard ,1st * is for return type that means any rt that can access 2nd * is for method start with add can access

    @Before("execution(* com.sf.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

    }
}
