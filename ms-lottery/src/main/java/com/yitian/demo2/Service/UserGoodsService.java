package com.yitian.demo2.Service;

import com.yitian.demo2.entity.DTO.UserGoodsDTO;

public interface UserGoodsService {

    UserGoodsDTO getGoodsByUserId(String userId);
}
