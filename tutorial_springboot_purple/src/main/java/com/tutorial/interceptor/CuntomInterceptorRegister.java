package com.tutorial.interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by jimmy on 2017/10/25.
 * 过滤器属于Servlet范畴的API，与Spring 没什么关系
 * Web开发中，我们除了使用 Filter 来过滤web请求外，还可以使用Spring提供的HandlerInterceptor（拦截器）。
 * HandlerInterceptor 的功能跟过滤器类似，但是提供更精细的的控制能力：在request被响应之前、request被响应之后、视
 * 图渲染之前以及request全部结束之后
 * 我们不能通过拦截器修改request内容，但是可以通过抛出异常（或者返回false）来暂停request的执行。
 * 拦截器注册
 * 只有经过DispatcherServlet 的请求，才会走拦截器链，我们自定义的Servlet 请求是不会被拦截的，比如我们自定义的* * Servlet地址http://localhost:8080/myServlet 是不会被拦截器拦截的。并且不管是属于哪个Servlet
 * 只要符合过滤器的过滤规则，过滤器都会拦截
 */
//@Configuration
public class CuntomInterceptorRegister extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new CustomInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
