package com.springnovel.test;

import org.junit.Test;

import com.springnovel.dao.IOrderDao;
import com.springnovel.dao.MockOrderDao;
import com.springnovel.paymentwithspringxml.OrderAction;

public class OrderTest {
	
	@Test
	public void mockDeleteOrderTest() {
		IOrderDao orderDao = new MockOrderDao();
		OrderAction orderAction = new OrderAction(orderDao);
		orderAction.deleteOrder("1234567@#%^$");
	}
}	
