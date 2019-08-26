package com.fms.dao;

import com.fms.beans.Admin;
import com.fms.repository.AdminRepository;
import com.fms.repository.CustomerRepository;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public Boolean adminLogin(Integer adminId, String password) {

		
		if(AdminRepository.adminRepo.containsKey(adminId)) {
			
			Admin admin = AdminRepository.adminRepo.get(adminId);
			
			
			if(admin.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean deleteCustomer(Integer CustomerId) {
		if(CustomerRepository.customerRepo.containsKey(CustomerId)) {
			CustomerRepository.customerRepo.remove(CustomerId);
			return true;
		}
		return false;
	}

}
