package com.example.demo.dao;

import com.example.demo.domain.ProductFeatureAdvance;

public interface ProductFeatureAdvanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_feature_advance
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_feature_advance
     *
     * @mbggenerated
     */
    int insert(ProductFeatureAdvance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_feature_advance
     *
     * @mbggenerated
     */
    int insertSelective(ProductFeatureAdvance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_feature_advance
     *
     * @mbggenerated
     */
    ProductFeatureAdvance selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_feature_advance
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ProductFeatureAdvance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_feature_advance
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ProductFeatureAdvance record);
}