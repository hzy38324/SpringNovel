package com.springnovel.perfectlogger;

public class FileLogger implements ILogger{

	@Override
	public void log(String logInfo) {
		System.out.println("FileLogger: " + logInfo);
	}
	
}
