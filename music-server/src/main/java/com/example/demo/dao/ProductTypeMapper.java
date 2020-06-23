package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.ProductType;

public interface ProductTypeMapper {
	
	int deleteProductType(Long productTypeName);

    int insert(ProductType record);
    
    int insertSelective(ProductType record);
    
    int addProductType(ProductType record);
    
    ProductType selectByPrimaryKey(Long productTypeId);
    
    int updateProductType(ProductType productType);
    
    List<ProductType> productTypeList();


}
