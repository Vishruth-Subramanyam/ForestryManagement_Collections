package com.fms.repository;

import java.util.HashMap;

import com.fms.beans.Product;

public class ProductRepository {
	public static HashMap<Integer,Product> productRepo  = new HashMap<Integer,Product>();

	public ProductRepository() {
		Product product=new Product();
		product.setProductId(500);
		product.setProductName("Rubber");
		product.setProductDescription("rubber raw material from Africa" );
		productRepo.put(500, product);
		
		product=new Product();
		product.setProductId(501);
		product.setProductName("Oak");
		product.setProductDescription("oak timbers from north America" );
		productRepo.put(501, product);
		
		
	}
	
	
	
}

