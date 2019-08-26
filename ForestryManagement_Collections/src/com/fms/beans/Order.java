package com.fms.beans;

import java.util.Calendar;


public class Order {

	private Integer orderNo;
	private Customer customer;
	private Product product;
	private Haulier haulier;
	private Integer quantity;
	private Calendar deliveryDate;
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", customer=" + customer + ", product=" + product + ", haulier=" + haulier
				+ ", quantity=" + quantity + ", deliveryDate=" + deliveryDate + "]";
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
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
	
}
