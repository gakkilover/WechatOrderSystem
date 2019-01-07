package com.zwk.weibo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-27 12:29
 * @ Description：
 */
@Controller
public class DefaultController {

    @RequestMapping("/bootm")

    public String defaultIndex(){
        return "bootm";
    }
}
