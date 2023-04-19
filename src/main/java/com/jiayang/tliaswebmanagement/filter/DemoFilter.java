package com.jiayang.tliaswebmanagement.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override //初始化方法, 只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override //拦截到请求之后调用, 调用多次
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Demo The request was intercepted...logic before release");
        //release
        chain.doFilter(request,response);

        System.out.println("Demo The request was intercepted...logic after release");
    }

    @Override //销毁方法, 只调用一次
    public void destroy() {
        System.out.println("destroy");
    }
}
