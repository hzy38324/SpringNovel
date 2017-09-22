package com.springnovel.order.springxml;

import com.springnovel.dao.IOrderDao;

public class OrderAction {
	
	private IOrderDao orderDao;
	
	public OrderAction(IOrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}

	public void deleteOrder(String orderId) {
		// 鉴权
		// 此处略去一万字...
		
		orderDao.deleteOrder(orderId);
	}
}
