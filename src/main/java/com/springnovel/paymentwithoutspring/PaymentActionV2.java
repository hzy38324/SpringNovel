package com.springnovel.paymentwithoutspring;

import java.math.BigDecimal;

import com.springnovel.perfectlogger.ILogger;

public class PaymentActionV2 {
	
	private ILogger logger = LoggerFactory.createLogger();
	
	public void pay(BigDecimal payValue) {
		logger.log("pay begin, payValue is " + payValue);
		
		// do otherthing
		// ...
		
		logger.log("pay end");
	}
}
