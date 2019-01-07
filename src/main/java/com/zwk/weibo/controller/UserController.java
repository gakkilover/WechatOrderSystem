package com.zwk.weibo.controller;

import com.zwk.weibo.entity.UserEntity;
import com.zwk.weibo.service.UserService;
import com.zwk.weibo.utils.CacheLocal;
import com.zwk.weibo.utils.CacheUtil;
import com.zwk.weibo.utils.SessionUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-25 16:19
 * @ Description：
 */
@Controller
public class UserController {

    private Logger logger=LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public String selectAll(Model model){
        List<UserEntity> userList=userService.selectList(null);
        SessionUtil.getSessionInfo();
        model.addAttribute("userLists",userList);
        return "view/system/user/user_list";
    }

    @RequestMapping("/loginValidate")
    public String loginValidate(Model model, @Param("nickName")String nickName,@Param("password")String password){
        if(!userService.loginValidate(nickName,password)){
            model.addAttribute("msg","用户名或者密码错误");
            return "login";
        }
        SessionUtil.setSessionAttribute("nickName",nickName);
        return "index";
    }

    @RequestMapping("/sendCode")
    public String sendCode(Model model,@Param("userTel")String userTel,@Param("nickName")String nickName,@Param("password")String password){
        userService.sendCode(userTel);
        model.addAttribute("userTel",userTel);
        model.addAttribute("nickName",nickName);
        model.addAttribute("password",password);
        return "register";
    }

    @RequestMapping("/registerUser")
    public String registerUser(@Param("nickName")String nickName,@Param("password")String password,@Param("userTel")String userTel,@Param("code")String code){
        if(userService.codeValidate(code)){
            userService.insertUser(nickName,password,userTel);
        }
        return "index";
    }

    @RequestMapping("/registerPost")
    public String registerPost(){
        return "register";
    }

}
