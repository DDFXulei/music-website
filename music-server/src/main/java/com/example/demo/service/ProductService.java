package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Product;

public interface ProductService {

	boolean addProduct(Product product);
	
	boolean updateProductMsg(Product product);
	
	boolean updateProductUrl(Product product);
	
	boolean updateProductPic(Product product);
	
	boolean deleteProduct(Integer id);
	
	List<Product> allProducts();
	
	List<Product> productOfId(Integer id);
	
	List<Product> productOfName(String name);
	
	
}
