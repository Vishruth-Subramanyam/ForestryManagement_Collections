package com.fms.dao;

import java.util.List;

import com.fms.beans.Product;

public interface ProductDAO {
	public Boolean addProduct(Product product);
	public Boolean modifyProduct(Product product);
	public Boolean deleteProduct(Integer productId);
	public Product searchProduct(Integer productId);
	public List<Product> displayAllProduct();
}
