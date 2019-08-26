package com.fms.repository;

import java.util.HashMap;

import com.fms.beans.Address;


public class AddressRepository {
	public static HashMap<Integer,Address> addressRepo  = new HashMap<Integer,Address>();

	public AddressRepository() {
		
		Address address= new Address();
		address.setFlatNumber("25/A");
		address.setStreetAddress("1st main,5th cross shivaji nagar");
		address.setTownCity("Bangalore");
		address.setState("karnataka");
		address.setCountry("India");
		address.setPostCode(560001);
		addressRepo.put(1,address);
		
		address= new Address();
		address.setFlatNumber("100");
		address.setStreetAddress("7th cross RR nagar");
		address.setTownCity("Bangalore");
		address.setState("karnataka");
		address.setCountry("India");
		address.setPostCode(560057);
		addressRepo.put(2,address);
		
		address= new Address();
		address.setFlatNumber("99/B");
		address.setStreetAddress("MG road");
		address.setTownCity("Bangalore");
		address.setState("karnataka");
		address.setCountry("India");
		address.setPostCode(560060);
		addressRepo.put(3,address);
		
		address= new Address();
		address.setFlatNumber("17/A");
		address.setStreetAddress("SP road");
		address.setTownCity("Bangalore");
		address.setState("karnataka");
		address.setCountry("India");
		address.setPostCode(560039);
		addressRepo.put(4,address);
		
	}
}
