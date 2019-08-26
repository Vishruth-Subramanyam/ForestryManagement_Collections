package com.fms.repository;


import java.util.Calendar;
import java.util.HashMap;
import com.fms.beans.Order;

public class OrderRepository {
	public static HashMap<Integer,Order> orderRepo  = new HashMap<Integer,Order>();
	
	public OrderRepository() {
		Order order=new Order();
		Calendar calender = Calendar.getInstance();
		
		order.setOrderNo(2000);
		order.setCustomer(CustomerRepository.customerRepo.get(100));
		order.setHaulier(HaulierRepository.haulierRepo.get(1000));
		order.setProduct(ProductRepository.productRepo.get(500));
		order.setQuantity(100);
		calender.set(2019,6,27);
		order.setDeliveryDate(calender);
		orderRepo.put(2000, order);
				
		order=new Order();
		calender = Calendar.getInstance();
		order.setOrderNo(2001);
		order.setCustomer(CustomerRepository.customerRepo.get(101));
		order.setHaulier(HaulierRepository.haulierRepo.get(1001));
		order.setProduct(ProductRepository.productRepo.get(501));
		order.setQuantity(199);
		calender.set(2019,5,15);
		order.setDeliveryDate(calender);
		orderRepo.put(2001, order);
		
		
		
		
	}
	
}
