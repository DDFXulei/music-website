package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductTypeMapper;
import com.example.demo.domain.ProductType;
import com.example.demo.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeMapper productTypeMapper;
	
	@Override
	public boolean addProductType(ProductType productType) {
		
		return productTypeMapper.addProductType(productType)>0 ? true : false;
	}

	@Override
	public boolean updateProductType(ProductType productType) {
		
		return productTypeMapper.updateProductType(productType)>0 ? true : false;
	}

	@Override
	public boolean deleteProductTypeById(Long productTypeId) {
		
		return productTypeMapper.deleteProductTypeById(productTypeId)>0 ? true : false;
	}

	@Override
	public List<ProductType> allProductType() {
		
		return productTypeMapper.productTypeList();
	}




}
