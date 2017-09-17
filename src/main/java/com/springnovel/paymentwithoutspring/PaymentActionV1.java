package com.springnovel.paymentwithoutspring;

import java.math.BigDecimal;

import com.springnovel.perfectlogger.FileLogger;
import com.springnovel.perfectlogger.ILogger;

public class PaymentActionV1 {
	
	private ILogger logger = new FileLogger();
	
	public void pay(BigDecimal payValue) {
		logger.log("pay begin, payValue is " + payValue);
		
		// do otherthing
		// ...
		
		logger.log("pay end");
	}
}
