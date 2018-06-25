package com.springnovel.test;

import com.springnovel.payment.springxml.PaymentAction;
import com.springnovel.payment.springxml.PaymentAction_SetInjection;
import com.springnovel.payment.withoutspring.PaymentActionV1;
import com.springnovel.payment.withoutspring.PaymentActionV2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class PaymentTest {
	
	@Test
	public void testPaymentActionV1() {
		PaymentActionV1 paymentActionV1 = new PaymentActionV1();
		paymentActionV1.pay(new BigDecimal(1));
	}
	
	@Test
	public void testPaymentActionV2() {
		PaymentActionV2 paymentActionV2 = new PaymentActionV2();
		paymentActionV2.pay(new BigDecimal(1));
	}
	
	@Test
	public void testPaymentActionPayWithSpringXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("payment.xml");
        // ApplicationContext默认会在容器启动后实例化对象（看构造函数中的refresh方法），所以下面这个getBean方法可以直接拿到对象，除非设置lazy-init="true"
		PaymentAction paymentAction = (PaymentAction) context.getBean("paymentAction");
		paymentAction.pay(new BigDecimal(2));
	}

	@Test
	public void testPaymentActionUpdateOrderWithSpringXML() {
		ApplicationContext context = new ClassPathXmlApplicationContext("payment.xml");
		PaymentAction paymentAction = (PaymentAction) context.getBean("paymentAction");
		paymentAction.updateOrderAfterPayment("123456");
	}

	@Test
	public void test_PaymentAction_UpdateOrder_XML_SetInjection() {
		ApplicationContext context = new ClassPathXmlApplicationContext("payment.xml");
		PaymentAction_SetInjection paymentAction = (PaymentAction_SetInjection) context.getBean("paymentAction_setInjection");
		paymentAction.updateOrderAfterPayment("123456");
	}
}
