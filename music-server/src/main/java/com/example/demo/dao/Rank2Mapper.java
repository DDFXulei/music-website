package com.example.demo.dao;

import com.example.demo.domain.Rank2;

public interface Rank2Mapper {

    int insert(Rank2 record);

    int insertSelective(Rank2 record);

    /**
     * 查总分
     * @param songListId
     * @return
     */
    int selectScoreSum(Long songListId);

    /**
     * 查总评分人数
     * @param songListId
     * @return
     */
    int selectRankNum(Long songListId);
}