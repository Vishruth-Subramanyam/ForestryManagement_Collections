package com.fms.repository;
import java.util.HashMap;
import com.fms.beans.Customer;


public class CustomerRepository {
	public static HashMap<Integer,Customer> customerRepo  = new HashMap<Integer,Customer>();
	
public CustomerRepository(){
		
		
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("Surabhi AK");
		customer.setEmail("Surabhi789@gmail.com");
		customer.setTelephoneNo(7795884707L);
		customer.setAddress(AddressRepository.addressRepo.get(1));
		customer.setPassword("Vishruth");
		customerRepo.put(1, customer);
		
		customer = new Customer();
		customer.setCustomerId(101);
		customer.setCustomerName("Ranjan Das");
		customer.setEmail("abc@gmail.com");
		customer.setTelephoneNo(8762622707L);
		customer.setPassword("ranjanroot");
		customer.setAddress(AddressRepository.addressRepo.get(2));
		customerRepo.put(101, customer);
		
		
		 
		
		}
	
	}	



