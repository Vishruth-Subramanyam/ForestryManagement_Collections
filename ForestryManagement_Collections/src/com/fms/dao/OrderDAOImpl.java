package com.fms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fms.beans.Order;
import com.fms.repository.OrderRepository;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public Boolean addOrder(Order order) {
		Order order1=OrderRepository.orderRepo.put(order.getOrderNo(), order);
		if(order1 == null){
		return true;
		}
		return false;
	}

	@Override
	public Boolean deleteOrder(Integer orderId) {
		Order order = OrderRepository.orderRepo.remove(orderId);
		if(order != null) {
		return true;
		} 
		return false;
	}

	@Override
	public Order searchOrder(Integer orderId) {
		return OrderRepository.orderRepo.get(orderId);
	}

	@Override
	public List<Order> displayAllOrder() {
		
		Iterator<Entry<Integer, Order>> iterator = OrderRepository.orderRepo.entrySet().iterator();
		List<Order> orders = new ArrayList<Order>();
		
		while (iterator.hasNext()) {

			Map.Entry<Integer,Order> pair = iterator.next();
			orders.add((Order)pair.getValue());
			

		}
		return orders;
	}


}
