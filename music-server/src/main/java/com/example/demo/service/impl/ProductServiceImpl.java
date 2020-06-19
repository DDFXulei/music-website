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
		return productMapper.updateProductPic(product) >0 ?true:false;
	}

	@Override
	public boolean deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> Product() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> productOfId(Long id) {
		// TODO Auto-generated method stub
		return productMapper.productOfId(id);
	}

	@Override
	public List<Product> productOfName(String productName) {
		// TODO Auto-generated method stub
		return productMapper.productOfName(productName);
	}

	public List<Product> productOfType(Long productType) {
		// TODO Auto-generated method stub
		return productMapper.productOfType(productType);
	}


}
