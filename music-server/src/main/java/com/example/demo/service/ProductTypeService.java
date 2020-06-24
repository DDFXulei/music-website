package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.ProductType;

public interface ProductTypeService {
	
	boolean addProductType (ProductType productType);

    boolean updateProductType(ProductType productType);

    boolean deleteProductTypeById(Long productTypeId);
    
    List<ProductType> allProductType();


}
