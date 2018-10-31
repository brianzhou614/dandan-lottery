package com.yitian.demo2.Controller;

import com.yitian.demo2.Service.UserGoodsService;
import com.yitian.demo2.entity.DTO.UserGoodsDTO;
import com.yitian.demo2.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGoodsController {

    @Autowired
    private UserGoodsService userGoodsService;
    @RequestMapping(value="/goods",method = RequestMethod.GET)
    public RestResult<UserGoodsDTO> getGoodsByUserId(String userId) {
        return new RestResult(userGoodsService.getGoodsByUserId(userId));
    }
}
