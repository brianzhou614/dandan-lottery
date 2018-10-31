package com.yitian.demo2.Service.impl;

import com.yitian.demo2.Service.AreaService;
import com.yitian.demo2.entity.Area;
import com.yitian.demo2.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> queryArea() {
        return areaMapper.queryArea();
    }
}
