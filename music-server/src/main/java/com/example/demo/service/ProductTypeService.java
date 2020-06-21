package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.ProductType;

public interface ProductTypeService {
	
	boolean addProduct (ProductType productType);

    boolean updateProductTypeName(ProductType productType);

    boolean deleteProductType(Long productTypeId);
    
    List<ProductType> allProductType();


}
