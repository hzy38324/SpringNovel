package com.springnovel.test;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springnovel.paymentwithoutspring.PaymentActionV1;
import com.springnovel.paymentwithoutspring.PaymentActionV2;
import com.springnovel.paymentwithspringxml.PaymentAction;

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
	public void testPaymentActionWithSpringXML() {
		ApplicationContext context = new ClassPathXmlApplicationContext("payment.xml");
		PaymentAction paymentAction = (PaymentAction) context.getBean("paymentAction");
		paymentAction.pay(new BigDecimal(2));
	}
}
