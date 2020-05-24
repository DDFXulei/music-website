package com.example.demo.service.impl;

import com.example.demo.dao.Rank2Mapper;
import com.example.demo.domain.Rank2;
import com.example.demo.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private Rank2Mapper rankMapper;

    @Override
    public int rankOfSongListId(Long songListId) {
        return rankMapper.selectScoreSum(songListId) / rankMapper.selectRankNum(songListId);
    }

    @Override
    public boolean addRank(Rank2 rank) {

        return rankMapper.insertSelective(rank) > 0 ? true:false;
    }
}
