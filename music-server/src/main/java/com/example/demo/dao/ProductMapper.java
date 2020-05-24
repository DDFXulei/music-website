package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.Product;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_main
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_main
     *
     * @mbggenerated
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_main
     *
     * @mbggenerated
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_main
     *
     * @mbggenerated
     */
    Product selectByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_main
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_main
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_main
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Product record);
    
    
    List<Product> allProducts();

    List<Product> productOfProductId(Integer productId);

    List<Product> productOfId(Long id);

    List<Product> productOfProductName(String name);
}