package com.yitian.demo2.mapper;

import com.yitian.demo2.entity.DTO.UserGoodsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserGoodsMapper {

    UserGoodsDTO getGoodsByUserId(String userId);
}
