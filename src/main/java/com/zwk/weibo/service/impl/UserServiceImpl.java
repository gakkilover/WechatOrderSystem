package com.zwk.weibo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zwk.weibo.constant.Final;
import com.zwk.weibo.dao.UserDao;
import com.zwk.weibo.entity.UserEntity;
import com.zwk.weibo.service.UserService;
import com.zwk.weibo.utils.GetMessageCode;
import com.zwk.weibo.utils.Md5Cryption;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-25 15:38
 * @ Description：
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao,UserEntity> implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public  List<UserEntity> selectAllUser() {
        List<UserEntity> list=userDao.selectAllUser();
        return list;
    }

    @Override
    public void insertUser(String nickName,String password,String userTel) {
        UserEntity userEntity=new UserEntity();
        userEntity.setUserId(userDao.getMaxId());
        Date date=new Date();
        userEntity.setUserBirthday(date);
        userEntity.setNickName(nickName);
        userEntity.setPayPassword("111111");
        userEntity.setStatusCd("1000");
        userEntity.setUserAddress("北京市朝阳区大悦城");
        userEntity.setUserName("zwk");
        userEntity.setUserPic("nici.jpg");
        userEntity.setWechatId("xkk");
        userEntity.setUserSex("男");
        userEntity.setUserTel(userTel);
        userEntity.setUserPassword(Md5Cryption.encrypt(password+nickName));
        userDao.insert(userEntity);
    }

    @Override
    public UserEntity selectByName(String userName) {
        return userDao.selectByName(userName);
    }

    @Override
    public boolean loginValidate(String nickName, String password) {
        UserEntity userEntity=userDao.selectByName(nickName);
        if(userEntity!=null&&Md5Cryption.encrypt(password+nickName).equals(userEntity.getUserPassword())){
            return true;
        }
        return false;
    }

    @Override
    public void sendCode(String userTel) {
        GetMessageCode.getCode(userTel);
    }

    @Override
    public boolean codeValidate(String code) {
        List codeList =GetMessageCode.codeList;
        if(code!=null&&codeList.get(codeList.size()-1).equals(code)){
            return true;
        }
        return false;
    }
}
