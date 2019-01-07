package com.zwk.weibo.service;

import com.baomidou.mybatisplus.service.IService;
import com.zwk.weibo.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-25 15:27
 * @ Description：
 */
public interface UserService extends IService<UserEntity> {
    List<UserEntity> selectAllUser();
    void insertUser(String nickName,String password,String userTel);
    UserEntity selectByName(String userName);
    boolean loginValidate(String nickName,String password);
    void sendCode(String userTel);
    boolean codeValidate(String code);
}
