package com.springnovel.dao;

public class OrderDao implements IOrderDao{

	@Override
	public void deleteOrder(String orderId) {
		// resume to connect db ...
		// ...
		
		System.out.println("real delete order, order id is " + orderId);
	}
	
}
