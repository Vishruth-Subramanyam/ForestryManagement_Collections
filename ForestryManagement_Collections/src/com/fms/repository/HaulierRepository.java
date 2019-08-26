package com.fms.repository;

import java.util.HashMap;

import com.fms.beans.Haulier;

public class HaulierRepository {
	public static HashMap<Integer,Haulier> haulierRepo  = new HashMap<Integer,Haulier>();
	
	public HaulierRepository() {
		Haulier haulier= new Haulier();
		haulier.setHaulierId(1000);
		haulier.setAddress(AddressRepository.addressRepo.get(3));
		haulier.setHaulierName("Ravi Kumar");
		haulier.setEmail("raviKumar@gmail.com");
		haulier.setTelephoneNo(9448182899L);
		haulierRepo.put(1000, haulier);
		
		haulier= new Haulier();
		haulier.setHaulierId(1001);
		haulier.setAddress(AddressRepository.addressRepo.get(4));
		haulier.setHaulierName("Praveen shetty");
		haulier.setEmail("praveen456@gmail.com");
		haulier.setTelephoneNo(8050325129L);
		haulierRepo.put(1001, haulier);
		
	}
	
	
	

}
