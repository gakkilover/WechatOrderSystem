package com.zwk.weibo.controller;


import com.zwk.weibo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/name")
    public String testCon(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("adminList");
        List adminList=testService.selectAll();
        modelAndView.addObject("adminList",adminList);
        return "/index";
    }

    @RequestMapping(value = "/name2")
    public String testCon1(){

        return "/index";
    }

}
