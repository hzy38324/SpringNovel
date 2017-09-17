package com.springnovel.paymentwithspringxml;

import java.math.BigDecimal;

import com.springnovel.perfectlogger.ILogger;

public class PaymentAction {
	
	private ILogger logger;
	
	public PaymentAction(ILogger logger) {
		super();
		this.logger = logger;
	}

	public void pay(BigDecimal payValue) {
		logger.log("pay begin, payValue is " + payValue);
		
		// do otherthing
		// ...
		
		logger.log("pay end");
	}
}
