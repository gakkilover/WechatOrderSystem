package com.zwk.weibo.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-15 10:27
 * @ Description：
 */
public class Test1Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long timeNow=System.currentTimeMillis();
        System.out.println("----------------------------------------tmienow"+timeNow);
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("----------------------------------------tmieafter"+timeNow);
    }

    @Override
    public void destroy() {

    }


}
