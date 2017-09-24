package com.springnovel.dao;

public class MockOrderDao implements IOrderDao{

	@Override
	public void deleteOrder(String orderId) {
		// no need to connect db...
		
		System.out.println("mock delete order, order id is " + orderId);
	}

	@Override
	public void addOrder(String orderType) {
		System.out.println("mock add order, order type is " + orderType);
	}

	@Override
	public void updateOrderAfterPayment(String orderId) {
		System.out.println("mock update order after payment, orderId is " + orderId);
	}

}
