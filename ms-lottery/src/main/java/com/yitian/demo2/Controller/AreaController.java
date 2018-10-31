package com.yitian.demo2.Controller;

import com.yitian.demo2.Service.AreaService;
import com.yitian.demo2.entity.Area;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AreaController {

    @Autowired
    private AreaService areaService;
    @RequestMapping(value="/listarea" ,method = RequestMethod.GET)
    public Map<String,Object> listarea() {
        Map<String,Object> map =  new HashMap<>();
        List<Area> list =areaService.queryArea();
        map.put("areaList",list);
        return map;
    }
}
