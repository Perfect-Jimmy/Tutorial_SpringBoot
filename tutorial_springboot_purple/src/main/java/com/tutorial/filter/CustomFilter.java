package com.tutorial.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by jimmy on 2017/10/25.
 * Filter作用：
 * 可以改变一个request和修改一个response.
 * Filter 不是一个servlet,它不能产生一个response,它能够在一个request到达servlet之前预处理request,也可以在离开* servlet时处理response
 * 包括：
 * 1）、在servlet被调用之前截获;
 * 2）、在servlet被调用之前检查servlet request;
 * 3）、根据需要修改request头和request数据;
 * 4）、根据需要修改response头和response数据;
 * 5）、在servlet被调用之后截获.
 */
@Order(1)
@WebFilter(filterName="customFilter",urlPatterns="/*")
//@WebFilter(filterName="TestFilter",urlPatterns={"/test/index","/test/home"})//多个过滤路径
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行过滤操作");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
