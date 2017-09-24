package com.springnovel.order.withoutspring;

import com.springnovel.dao.IOrderDao;
import com.springnovel.dao.OrderDao;

public class OrderAction {
	public void deleteOrder(String orderId) {
		IOrderDao orderDao = new OrderDao();
		orderDao.deleteOrder(orderId);
	}
}
