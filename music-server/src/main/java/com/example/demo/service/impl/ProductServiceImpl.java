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
    public List<Product> allProducts()
    {
        return productMapper.allProducts();
    }
    
	@Override
	public boolean addProduct(com.example.demo.domain.Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProductMsg(com.example.demo.domain.Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProductUrl(com.example.demo.domain.Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProductPic(com.example.demo.domain.Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSong(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<com.example.demo.domain.Product> Product() {
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
