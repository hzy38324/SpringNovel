package com.springnovel.perfectlogger;

public class ServerLogger implements ILogger{
    public ServerLogger() {
        System.out.println("aaa");
    }

    @Override
	public void log(String logInfo) {
		System.out.println("ServerLogger: " + logInfo);
	}
	
}
