package com.zwk.weibo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-15 14:29
 * @ Description：
 */
@WebFilter(filterName = "TestFilter",urlPatterns = "/genreList")
public class TestFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long timeNow=System.currentTimeMillis();
        System.out.println("tmienow"+timeNow);
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("tmieafter"+timeNow);
    }

    @Override
    public void destroy() {

    }
}
