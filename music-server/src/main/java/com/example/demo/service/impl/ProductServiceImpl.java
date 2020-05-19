package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ProductMapper;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProductMsg(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProductUrl(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProductPic(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> allProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> productOfId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> productOfName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
