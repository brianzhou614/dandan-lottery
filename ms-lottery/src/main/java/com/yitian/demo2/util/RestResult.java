package com.yitian.demo2.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestResult<T> implements Serializable {

    private static final long serialVersionUID =1 ;

    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    public static final int NO_PEMISSION=2;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public RestResult() {
        super();
    }

    public RestResult(T data) {
        super();
        this.data = data;
    }

    public RestResult(Throwable e) {
        super();
        this.msg=msg;
        this.code=FAIL;
    }

}
