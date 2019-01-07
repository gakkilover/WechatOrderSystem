package com.zwk.weibo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zwk.weibo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-25 15:20
 * @ Description：
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    @Select(" SELECT * FROM USER WHERE 1=1")
    List<UserEntity> selectAllUser();

    @Select(" SELECT * FROM USER WHERE NICK_NAME=#{userName} ")
    UserEntity selectByName(String userName);

    @Select(" SELECT max(user_id)+1 FROM USER ")
    Long getMaxId();
}
