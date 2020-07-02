package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Product;
import java.lang.Long;

public interface ProductService {


	boolean addProduct (Product product);
	
	boolean deleteProduct(Long productId);

    boolean updateProduct(Product product); 
    
    boolean updateProductPic(Product product); 
    
    List<Product> allProducts();

    Product productOfId(Long productId);
    //ABOVE
    List<Product> productOfName(String name);
    
    List<Product> productOfType(Long productType);

}
