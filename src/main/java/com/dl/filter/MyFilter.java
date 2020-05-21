package com.dl.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * 配置过滤器
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter Process....");
        filterChain.doFilter(servletRequest,servletResponse);//放行
    }

    @Override
    public void destroy() {

    }
}
