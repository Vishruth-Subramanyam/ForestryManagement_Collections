package com.fms.dao;

public interface AdminDAO {
	public Boolean adminLogin(Integer adminId,String password);
	public Boolean deleteCustomer(Integer CustomerId);

}
