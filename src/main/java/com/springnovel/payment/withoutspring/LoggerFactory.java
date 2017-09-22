package com.springnovel.payment.withoutspring;

import com.springnovel.perfectlogger.ILogger;
import com.springnovel.perfectlogger.ServerLogger;

public class LoggerFactory {
	public static ILogger createLogger() {
		return new ServerLogger();
	}
}
