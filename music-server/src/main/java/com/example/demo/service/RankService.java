package com.example.demo.service;

import com.example.demo.domain.Rank2;

public interface RankService {

    int rankOfSongListId(Long songListId);

    boolean addRank(Rank2 rank);
}
