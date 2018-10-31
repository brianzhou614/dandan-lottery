package com.yitian.demo2.Service.impl;

import com.yitian.demo2.Service.UserGoodsService;
import com.yitian.demo2.entity.DTO.UserGoodsDTO;
import com.yitian.demo2.mapper.UserGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGoodsServiceImpl implements UserGoodsService {


    @Autowired
    private UserGoodsMapper userGoodsMapper;
    @Override
    public UserGoodsDTO getGoodsByUserId(String userId) {
        return userGoodsMapper.getGoodsByUserId(userId);
    }
}
