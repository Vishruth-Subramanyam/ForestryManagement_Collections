package com.fms.dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fms.beans.Customer;
import com.fms.repository.CustomerRepository;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Boolean addCustomer(Customer customer) {

		Customer customer1 = CustomerRepository.customerRepo.put(customer.getCustomerId(), customer);
		
		if(customer1== null) {
		return true;
		}
		return false;

	}

	@Override
	public Boolean modifyCustomer(Customer customer) {
		
		

				Customer modifiedCustomer= new Customer();
				
				modifiedCustomer=null;
				modifiedCustomer=CustomerRepository.customerRepo.replace(customer.getCustomerId(), customer);
					
				if(modifiedCustomer!=null) {
					return true;
			}
		
			return false;
		
		
	}

	@Override
	public Boolean deleteCustomer(Integer customerId, String password) {
		Customer customer=new Customer();
		customer=null;
		if(CustomerRepository.customerRepo.containsKey(customerId)) {
			Customer getCustomer= CustomerRepository.customerRepo.get(customerId);
			
			if(getCustomer.getPassword().equals(password)) {
				
				customer = CustomerRepository.customerRepo.remove(getCustomer.getCustomerId());
				
				
			}
		}
		if(customer != null) {
			return true;
		} 
		return false;
		
	}

	@Override
	public Customer searchCustomer(Integer customerId) {
		return  CustomerRepository.customerRepo.get(customerId);
		
		
	}

	@Override
	public List<Customer> displayAllCustomer() {
		
		Iterator<Entry<Integer, Customer>> iterator = CustomerRepository.customerRepo.entrySet().iterator();
		List<Customer> customer = new ArrayList<Customer>();
		
		while (iterator.hasNext()) {

			Map.Entry<Integer,Customer> pair = iterator.next();
			customer.add((Customer)pair.getValue());
		

		}

	return customer;	
	}

	@Override
	public Boolean loginCustomer(Integer customerId, String password) {
		if(CustomerRepository.customerRepo.containsKey(customerId)) {
			Customer customer=CustomerRepository.customerRepo.get(customerId);
			if(customer.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}



}
