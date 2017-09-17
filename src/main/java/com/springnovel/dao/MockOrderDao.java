package com.springnovel.dao;

public class MockOrderDao implements IOrderDao{

	@Override
	public void deleteOrder(String orderId) {
		// no need to connect db...
		
		System.out.println("mock delete order, order id is " + orderId);
	}
	
}
