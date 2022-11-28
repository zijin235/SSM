package com.Zijin.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截器的三个方法
 * 1、preHandler():在控制器方法执行之前执行，其返回值表示对控制方法的拦截(false)或放行(true)
 * 2、postHandler():在控制器方法执行之后执行
 * 3、afterCompletion():在控制器方法执行之后且视图渲染之前执行
 *
 * 多个拦截器的顺序执行和在springmvc的配置文件中的顺序有关
 * preHandle()按照配置的顺序执行，而postHandle()和afterHandle()会按照配置的反序执行
 *
 * 若拦截器中有某个拦截器的preHandle方法返回了false
 * 拦截器的preHandle()返回false和它之前的拦截器的preHandle()都会执行
 * 所有拦截器的postHandle()都不执行
 * 拦截器的preHandle()返回false之前的afterCompletion()会执行
 */
@Component
public class Firstinterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor-->preHandler");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInceptor-->postHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInceptor-->afterCompletion");
    }
}
