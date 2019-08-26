package com.fms.beans;

import java.util.Calendar;


public class Contract {
	private Integer contractNo;
	private Customer customer;
	private Product product;
	private Haulier haulier;
	private Integer quantity;
	private Calendar deliveryDate;
	
	public Integer getContractNo() {
		return contractNo;
	}
	public void setContractNo(Integer contractNo) {
		this.contractNo = contractNo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Haulier getHaulier() {
		return haulier;
	}
	public void setHaulier(Haulier haulier) {
		this.haulier = haulier;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Calendar getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	@Override
	public String toString() {
		return "Contract [contractNo=" + contractNo + ", customer=" + customer + ", product=" + product + ", haulier="
				+ haulier + ", quantity=" + quantity + ", deliveryDate=" + deliveryDate + "]";
	}
	
	
}
