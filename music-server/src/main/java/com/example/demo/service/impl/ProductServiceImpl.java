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
		
		return productMapper.addProduct(product)>0 ? true:false;
	}

	@Override
	public boolean deleteProduct(Long productId) {
		
		return productMapper.deleteByProuductId(productId)>0 ? true : false;
	}
	
	@Override
	public boolean updateProduct(Product product) {
		
		return productMapper.updateProduct(product) > 0 ? true : false;
	}
	
	@Override
	public boolean updateProductPic(Product product) {
		
		return productMapper.updateProductPic(product) > 0 ? true : false;
	}
	
	@Override
	public boolean updateProductParam(Product product) {
		
		return productMapper.updateProductParam(product) > 0 ? true : false;
	}
	
    @Override
    public List<Product> allProducts()
    {
        return productMapper.allProducts();
    }
    
	@Override
	public Product productOfId(Long id) {
		return productMapper.productOfId(id);
	}
	

	//ABOVE



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
