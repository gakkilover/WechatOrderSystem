package com.zwk.weibo.controller;
import com.alibaba.fastjson.JSONObject;
import com.zwk.weibo.service.TestService;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;
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

    /**
     * 调用另一个项目的接口
     * @return
     */
    @RequestMapping(value = "/name2")
    public String testHttpClient() throws IOException{
        HttpClient client = HttpClients.createDefault();
        // 要调用的接口方法
        String url = "http://192.168.8.101:8080/Weibo/api/genre/genreList";
        HttpPost post = new HttpPost(url);
        JSONObject jsonObject = null;
            Date date=new Date();
            StringEntity s = new StringEntity(date.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
            post.addHeader("content-type", "text/xml");
            HttpResponse res = client.execute(post);
            String response1 = EntityUtils.toString(res.getEntity());
            System.out.println(response1);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = response1;// 返回json格式：
            }
        return "/index";
    }

    /**
     * 测试 WebSocket
     * @return
     */
    @RequestMapping(value = "/name3")
    public String testWebSocket(Model model, @RequestParam("sid")String sid, @RequestParam("message")String message){
//        try {
//            WebSocketServer.sendInfo(message, sid);
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
        return "login";
    }

    @RequestMapping(value = "/name4")
    public String testRedis(){
        return "login";
    }

}
