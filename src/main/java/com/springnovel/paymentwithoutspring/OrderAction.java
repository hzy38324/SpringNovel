package com.springnovel.paymentwithoutspring;

import com.springnovel.dao.IOrderDao;
import com.springnovel.dao.OrderDao;

public class OrderAction {
	public void deleteOrder(String orderId) {
		// 鉴权
		// 此处略去一万字...
		
		IOrderDao orderDao = new OrderDao();
		orderDao.deleteOrder(orderId);
	}
}
