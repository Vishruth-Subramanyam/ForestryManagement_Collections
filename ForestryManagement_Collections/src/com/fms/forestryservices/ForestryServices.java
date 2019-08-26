package com.fms.forestryservices;


import com.fms.dao.AdminDAO;
import com.fms.dao.ContractDAO;
import com.fms.dao.CustomerDAO;
import com.fms.dao.HaulierDAO;
import com.fms.dao.OrderDAO;
import com.fms.dao.ProductDAO;

public interface ForestryServices extends CustomerDAO, ProductDAO, HaulierDAO, OrderDAO,ContractDAO,AdminDAO {

}
