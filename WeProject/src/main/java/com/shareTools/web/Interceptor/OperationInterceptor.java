package com.shareTools.web.Interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * todo  记录所有操作的拦截器
 */
@Component
public class OperationInterceptor extends HandlerInterceptorAdapter {

    private Logger log = LoggerFactory.getLogger(OperationInterceptor.class);

    //预处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Interceptor：preHandle ");
        return super.preHandle(request, response, handler);
    }

    //后处理
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        log.info("Interceptor：postHandle ");
    }

    //返回处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        log.info("Interceptor：afterCompletion ");
    }

    //处理异步请求
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
        log.info("Interceptor：afterConcurrentHandlingStarted ");
    }
}
