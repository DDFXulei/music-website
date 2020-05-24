package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Product;
import java.lang.Long;

public interface ProductService {


	boolean addProduct (Product product);

    boolean updateProductMsg(Product product);

    boolean updateProductUrl(Product product);

    boolean updateProductPic(Product product);

    boolean deleteSong(Integer id);
    
    List<Product> allProducts();

    List<Product> Product();

    List<Product> productOfId(Long id);

    List<Product> productOfName(String name);

}
