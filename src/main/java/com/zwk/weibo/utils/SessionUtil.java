package com.zwk.weibo.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-02 10:45
 * @ Description：session信息
 */
public class SessionUtil {
    public static HttpServletRequest request=null;
    //获取http请求
    public static HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    //获取session信息
    public static void getSessionInfo(){
        request=getHttpServletRequest();
        Enumeration<String> enumLIst=request.getAttributeNames();
        String nickName=(String)request.getAttribute("nickName");
    }

    public static void setSessionAttribute(String key ,String value){
        request=getHttpServletRequest();
        request.setAttribute(key, value);
    }
}
