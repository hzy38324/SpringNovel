package com.springnovel.payment.springmixed;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springnovel.dao.IOrderDao;
import com.springnovel.perfectlogger.ILogger;

@Component
public class PaymentActionMixed {
	
	private ILogger logger;
	private IOrderDao orderDao;
	
	public PaymentActionMixed(ILogger logger) {
		super();
		this.logger = logger;
	}
	
//	@Autowired
	public PaymentActionMixed(IOrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}

	public void pay(BigDecimal payValue) {
		logger.log("pay begin, payValue is " + payValue);
		
		// do otherthing
		// ...
		
		logger.log("pay end");
	}
	
	public void addOrder(String orderType) {
		orderDao.addOrder(orderType);
	}

}
