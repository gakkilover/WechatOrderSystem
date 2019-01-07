package com.zwk.weibo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zwk.weibo.entity.AdminEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminDao extends BaseMapper<AdminEntity>{

    @Select(" SELECT * FROM ADMIN ")
    List<AdminEntity> selectAll();

    @Insert(" INSERT INTO ADMIN( USERNAME, PASSWORD) VALUE(#{ username},#{ password})")
    Integer insert(@Param("username") String username, @Param("password")String password);
}
