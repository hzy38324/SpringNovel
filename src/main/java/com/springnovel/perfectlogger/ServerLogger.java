package com.springnovel.perfectlogger;

public class ServerLogger implements ILogger{

	@Override
	public void log(String logInfo) {
		System.out.println("ServerLogger: " + logInfo);
	}
	
}
