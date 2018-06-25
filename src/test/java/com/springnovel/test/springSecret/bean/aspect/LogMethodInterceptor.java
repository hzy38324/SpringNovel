package com.springnovel.test.springSecret.bean.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * <p>
 *
 * @author: hzy created on 2018/04/06
 */
public class LogMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            System.out.println("log something before method");
            return invocation.proceed();
        } finally {
            System.out.println("log something after method");
        }
    }
}
