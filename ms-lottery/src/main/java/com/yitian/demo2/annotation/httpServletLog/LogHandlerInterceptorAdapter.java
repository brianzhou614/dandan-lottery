package com.yitian.demo2.annotation.httpServletLog;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger("【==_REQUEST_LOG_==】");
    private static NamedThreadLocal<Long> time = new NamedThreadLocal<>("LogHandlerInterceptorAdapter");

    public static Long getLogUnionId(){
        return time.get();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        time.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = time.get();
        Long endTime = System.currentTimeMillis();
        JSONObject jo = new JSONObject();
        jo.putAll(request.getParameterMap());
        HttpServletLog httpServletLog = HttpServletLog.newInstance();
        httpServletLog.setMethodName(request.getMethod());
        httpServletLog.setUrlPath(request.getServletPath());
        httpServletLog.setParams(jo.toJSONString());
//		httpServletLog.setBody(HttpServletLogRequestWrapper.getBody());
        // logginESEntity.setResult(Objects.toString(proceed));
        if (ex != null) {
            httpServletLog.setExceptionType(ex.getClass().getName());
            httpServletLog.setErrorMsg(getStackTraceAsString(ex));
        }
        httpServletLog.setOperateTime(endTime - startTime);
        if( endTime - startTime > 10000){//超过十秒，记录feign时间
            //httpServletLog.setFeignTime(LogFeignInterceptor.getLogs());
            //做个断路器
        }
        logger.info(JSONObject.toJSONString(httpServletLog));
    }

    private static String getStackTraceAsString(Throwable e) {
        if (e == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
