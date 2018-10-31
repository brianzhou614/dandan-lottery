package com.yitian.demo2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Good {

    private Integer goodsId ;

    private String goodsName;

    private Integer number;

    private String sponsor;

    private String goodsImage;

    private Date endTime;

    private String sponsorDetail;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer isTake;

    private Integer lucky;
}
