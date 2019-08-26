package com.fms.repository;

import java.util.HashMap;

import com.fms.beans.Admin;

public class AdminRepository {
	public static HashMap<Integer,Admin> adminRepo  = new HashMap<Integer,Admin>();
	
	public AdminRepository() {
		
		Admin admin=new Admin();
		admin.setAdminId(1);
		admin.setPassword("root");
		adminRepo.put(1, admin);
	}


}
