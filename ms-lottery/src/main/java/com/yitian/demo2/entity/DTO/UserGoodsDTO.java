package com.yitian.demo2.entity.DTO;

import com.yitian.demo2.entity.Good;
import com.yitian.demo2.entity.UserInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserGoodsDTO extends UserInfo implements Serializable {

    private String userName;

    private String userAvatar;

    private List<Good> goods;
}
