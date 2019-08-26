package com.fms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fms.beans.Product;
import com.fms.repository.ProductRepository;

public class ProductDAOImpl implements ProductDAO{
	@Override
	public Boolean addProduct(Product product) {
		Product product1 = ProductRepository.productRepo.put(product.getProductId(), product);
		if(product1 == null) {
			return true;
		}
		return false;

	}

	@Override
	public Boolean modifyProduct(Product product) {
		Product modifiedProduct=new Product();
		
			
			modifiedProduct=null;
			
			modifiedProduct=ProductRepository.productRepo.replace(product.getProductId(), product);

			if(modifiedProduct!=null) {
				return true;
			}
		
			return false;
		
		
	}

	@Override
	public Boolean deleteProduct(Integer productId) {
		Product product = ProductRepository.productRepo.remove(productId);
		if(product != null) {
			return true;
		} 
		return false;
	}

	@Override
	public Product searchProduct(Integer productId) {
		return ProductRepository.productRepo.get(productId);

	}

	@Override
	public List<Product> displayAllProduct() {
		
		Iterator<Entry<Integer, Product>> iterator = ProductRepository.productRepo.entrySet().iterator();
		List<Product> products = new ArrayList<Product>();
		
		while (iterator.hasNext()) {

			Map.Entry<Integer,Product> pair = iterator.next();
			products.add((Product)pair.getValue());
			
			

		}
		return products;
	}




}
