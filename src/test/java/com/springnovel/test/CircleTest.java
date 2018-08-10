package com.springnovel.test;

import com.springnovel.test.bean.circle.CircleA;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by hongzeyang
 * Time 2018/7/31 下午7:30
 * Desc
 */
public class CircleTest {

    @Test
    public void testPaymentActionUpdateOrderWithSpringXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("circle-dependency.xml");
        CircleA circleA = (CircleA) context.getBean("circleA");
        System.out.println(circleA);
    }
}
