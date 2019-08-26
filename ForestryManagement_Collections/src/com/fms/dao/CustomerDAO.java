package com.fms.dao;

import java.util.List;

import com.fms.beans.Customer;

public interface CustomerDAO {
	public Boolean addCustomer(Customer customer);
	public Boolean modifyCustomer(Customer customer);
	public Boolean deleteCustomer(Integer customerId, String password);
	public Customer searchCustomer(Integer customerId);
	public List<Customer> displayAllCustomer();
	public Boolean loginCustomer(Integer customerId,String Password);
}
