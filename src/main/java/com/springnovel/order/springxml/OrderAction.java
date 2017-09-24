package com.springnovel.order.springxml;

import com.springnovel.dao.IOrderDao;

public class OrderAction {
	
	private IOrderDao orderDao;
	
	public OrderAction(IOrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}

	public void deleteOrder(String orderId) {
		orderDao.deleteOrder(orderId);
	}
}
