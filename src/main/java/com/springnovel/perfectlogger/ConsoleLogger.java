package com.springnovel.perfectlogger;

public class ConsoleLogger implements ILogger{

	@Override
	public void log(String logInfo) {
		System.out.println("ConsoleLogger: " + logInfo);
	}
	
}
