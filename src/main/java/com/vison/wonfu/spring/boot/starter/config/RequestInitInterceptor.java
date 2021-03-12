package com.vison.wonfu.spring.boot.starter.config;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.logging.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 *
 * @author caowenpeng
 */
public class RequestInitInterceptor implements HandlerInterceptor {

    public RequestInitInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        App._uniq_req_no.set(UUID.randomUUID().toString());
        App.sqlCount.set(0);
        App.sqlDuration.set(0L);
        Log.setMsgTraceNo(App._uniq_req_no.get());
        MDC.put("REQ_NO", App._uniq_req_no.get());
        Log.info("request start... || ");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        Log.info(String.format("finish request... || sql执行次数:%s sql总耗时:%s ms", App.sqlCount.get(), App.sqlDuration.get()));
    }

}
