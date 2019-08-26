package com.fms.forestryservices;

import java.util.List;

import com.fms.beans.Contract;
import com.fms.beans.Customer;
import com.fms.beans.Haulier;
import com.fms.beans.Order;
import com.fms.beans.Product;
import com.fms.dao.AdminDAO;
import com.fms.dao.AdminDAOImpl;
import com.fms.dao.ContractDAO;
import com.fms.dao.ContractDAOImpl;
import com.fms.dao.CustomerDAO;
import com.fms.dao.CustomerDAOImpl;
import com.fms.dao.HaulierDAO;
import com.fms.dao.HaulierDAOImpl;
import com.fms.dao.OrderDAO;
import com.fms.dao.OrderDAOImpl;
import com.fms.dao.ProductDAO;
import com.fms.dao.ProductDAOImpl;

public class ForestryServicesImpl implements ForestryServices {
	
	private CustomerDAO customerServices = new CustomerDAOImpl();
	private ContractDAO contractServices=new ContractDAOImpl();
	private HaulierDAO haulierServices= new HaulierDAOImpl();
	private ProductDAO productServices= new ProductDAOImpl();
	private OrderDAO orderServices= new OrderDAOImpl();
	private AdminDAO adminServices=new AdminDAOImpl();

	
	@Override
	public Boolean addCustomer(Customer customer) {
		
		return customerServices.addCustomer(customer);
	}
	@Override
	public Boolean modifyCustomer(Customer customer) {
		
		return customerServices.modifyCustomer(customer);
	}
	@Override
	public Boolean deleteCustomer(Integer customerId, String password) {
		return customerServices.deleteCustomer(customerId, password);
	}
	@Override
	public Customer searchCustomer(Integer customerId) {
		return customerServices.searchCustomer(customerId);
	}
	@Override
	public List<Customer> displayAllCustomer() {
		
		return customerServices.displayAllCustomer();
	}
	@Override
	public Boolean addProduct(Product product) {
		
		return productServices.addProduct(product);
	}
	@Override
	public Boolean modifyProduct(Product product) {
		return productServices.modifyProduct(product);
	}
	@Override
	public Boolean deleteProduct(Integer productId) {
		return productServices.deleteProduct(productId);
	}
	@Override
	public Product searchProduct(Integer productId) {
		return productServices.searchProduct(productId);
	}
	@Override
	public List<Product> displayAllProduct() {
		return productServices.displayAllProduct();
	}
	@Override
	public Boolean addHaulier(Haulier haulier) {
		return haulierServices.addHaulier(haulier);
	}
	@Override
	public Boolean deleteHaulier(Integer haulierId) {
		return haulierServices.deleteHaulier(haulierId);
	}
	@Override
	public Haulier searchHaulier(Integer haulierId) {
		return haulierServices.searchHaulier(haulierId);
	}
	@Override
	public List<Haulier> displayAllHaulier() {
		return haulierServices.displayAllHaulier();
	}
	@Override
	public Boolean addOrder(Order order) {
		return orderServices.addOrder(order);
	}
	@Override
	public Boolean deleteOrder(Integer orderId) {
		return orderServices.deleteOrder(orderId);
	}
	@Override
	public Order searchOrder(Integer orderId) {
		return orderServices.searchOrder(orderId);
	}
	@Override
	public List<Order> displayAllOrder() {
		return orderServices.displayAllOrder();
	}
	@Override
	public Boolean addContract(Contract contract) {
		return contractServices.addContract(contract);
	}
	@Override
	public Boolean deleteContract(Integer contractNo) {
		return contractServices.deleteContract(contractNo);
	}
	@Override
	public Contract searchContract(Integer contractNo) {
		return contractServices.searchContract(contractNo);
	}
	@Override
	public List<Contract> displayAllContract() {
		return contractServices.displayAllContract();
	}
	
	@Override
	public Boolean loginCustomer(Integer customerId, String Password) {
		
		return customerServices.loginCustomer(customerId, Password);
	}
	@Override
	public Boolean adminLogin(Integer adminId, String password) {
		
		return adminServices.adminLogin(adminId, password);
	}
	@Override
	public Boolean deleteCustomer(Integer CustomerId) {
		
		return adminServices.deleteCustomer(CustomerId);
	}
	
	
	
	
}
