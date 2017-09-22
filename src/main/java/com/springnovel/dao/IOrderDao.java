package com.springnovel.dao;

public interface IOrderDao {
	void deleteOrder(String orderId);
	void addOrder(String orderType);
}
