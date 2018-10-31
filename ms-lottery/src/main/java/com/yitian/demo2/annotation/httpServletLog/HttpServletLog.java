package com.yitian.demo2.annotation.httpServletLog;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HttpServletLog {

    public static  HttpServletLog httpServletLog ;

    @ApiModelProperty("请求方法名称")
    private String methodName;
    @ApiModelProperty("请求方法路径")
    private String urlPath;
    @ApiModelProperty("请求方法参数")
    private String params;
    @ApiModelProperty("请求方法异常类型")
    private String exceptionType;
    @ApiModelProperty("请求方法错误信息")
    private String errorMsg;
    @ApiModelProperty("请求方法操作的时间")
    private long operateTime;
    @ApiModelProperty("请求方法超时时间")
    private String feginTime;

    public static  HttpServletLog newInstance() {
        return new HttpServletLog();
    }
}
