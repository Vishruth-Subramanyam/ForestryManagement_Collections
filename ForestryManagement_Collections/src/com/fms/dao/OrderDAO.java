package com.fms.dao;

import java.util.List;

import com.fms.beans.Order;

public interface OrderDAO {
	public Boolean addOrder(Order order);
	public Boolean deleteOrder(Integer orderId);
	public Order searchOrder(Integer orderId);
	public List<Order> displayAllOrder();


}
