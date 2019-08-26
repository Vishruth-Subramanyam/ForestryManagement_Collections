package com.fms.repository;


import java.util.Calendar;
import java.util.HashMap;
import com.fms.beans.Contract;

public class ContractRepository {
	public static HashMap<Integer,Contract> contractRepo  = new HashMap<Integer,Contract>();
	
	 public ContractRepository(){
		 Calendar calender = Calendar.getInstance();
		 Contract contract= new Contract();
		 contract.setContractNo(5000);
		 contract.setCustomer(CustomerRepository.customerRepo.get(100));
		 contract.setProduct(ProductRepository.productRepo.get(500));
		 contract.setQuantity(250);
		 contract.setHaulier(HaulierRepository.haulierRepo.get(1000));
		 calender.set(2019,04,25);
		 contract.setDeliveryDate(calender);
		 ContractRepository.contractRepo.put(5000,contract);
		 
		 calender = Calendar.getInstance();
		 contract= new Contract();
		 contract.setContractNo(5001);
		 contract.setCustomer(CustomerRepository.customerRepo.get(101));
		 contract.setProduct(ProductRepository.productRepo.get(501));
		 contract.setQuantity(450);
		 contract.setHaulier(HaulierRepository.haulierRepo.get(1001));
		 calender.set(2019,04,30);
		 contract.setDeliveryDate(calender);
		 ContractRepository.contractRepo.put(5001,contract);
		 
		 
	}
	
	
}
