package com.springnovel.dao;

import org.springframework.stereotype.Component;

@Component
public class OrderDao implements IOrderDao{

	@Override
	public void deleteOrder(String orderId) {
		// resume to connect db ...
		// ...
		
		System.out.println("real delete order, order id is " + orderId);
	}

	@Override
	public void addOrder(String orderType) {
		System.out.println("real add order, order type is " + orderType);
	}
	
}
