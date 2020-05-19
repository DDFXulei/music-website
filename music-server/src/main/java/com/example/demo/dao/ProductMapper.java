package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.Product;
import com.example.demo.domain.Song;

public interface ProductMapper {
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(Product product);
	
	int insertSelective(Song record);
	
	Product selectByPrimaryId(Integer id);
	
	int updateByPrimaryKeySelective(Product prodcut);
	
	int updateBypeimarykeyWithBLOBs(Product product);
	
	int updateByPrimary(Product product);
	
	int updateProductMsg(Product product);
	
	int updateProductUrl(Product product);
	
	int updateProductPic(Product product);
	
	int deleteProduct(Integer id);
	
	List<Product> allProducts();
	
	List<Product> productOfId(Integer id);
	
	List<Product> productOfName(String name);

}
