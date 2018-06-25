package com.springnovel.test.springSecret.bean.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *
 * @author: hzy created on 2018/04/07
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public void *.execute())")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object log(ProceedingJoinPoint joinpoint) throws Throwable {
        try {
            System.out.println("LogAspect log something before method");
            return joinpoint.proceed();
        } finally {
            System.out.println("LogAspect log something after method");
        }
    }
}
