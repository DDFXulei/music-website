package com.example.demo.dao;

import com.example.demo.domain.TrafficStatistics;

public interface TrafficStatisticsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table traffic_statistics
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table traffic_statistics
     *
     * @mbggenerated
     */
    int insert(TrafficStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table traffic_statistics
     *
     * @mbggenerated
     */
    int insertSelective(TrafficStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table traffic_statistics
     *
     * @mbggenerated
     */
    TrafficStatistics selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table traffic_statistics
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TrafficStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table traffic_statistics
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TrafficStatistics record);
}