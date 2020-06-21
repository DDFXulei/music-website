package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.ProductTypeMapper;
import com.example.demo.domain.ProductType;
import com.example.demo.service.ProductTypeService;

public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeMapper productTypeMapper;
	
	@Override
	public boolean addProduct(ProductType productType) {
		
		return productTypeMapper.addProductType(productType)>0 ? true : false;
	}

	@Override
	public boolean updateProductTypeName(ProductType productType) {
		
		return productTypeMapper.updateProductTypeName(productType)>0 ? true : false;
	}

	@Override
	public boolean deleteProductType(Long productTypeId) {
		
		return productTypeMapper.deleteProductType(productTypeId)>0 ? true : false;
	}

	@Override
	public List<ProductType> allProductType() {
		
		return productTypeMapper.productTypeList();
	}

}
