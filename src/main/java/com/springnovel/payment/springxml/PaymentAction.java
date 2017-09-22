package com.springnovel.payment.springxml;

import java.math.BigDecimal;

import com.springnovel.dao.IOrderDao;
import com.springnovel.perfectlogger.ILogger;

public class PaymentAction {
	
	private ILogger logger;
	private IOrderDao orderDao;
	
	public PaymentAction(ILogger logger) {
		super();
		this.logger = logger;
	}
	
	public PaymentAction(ILogger logger, IOrderDao orderDao) {
		super();
		this.logger = logger;
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