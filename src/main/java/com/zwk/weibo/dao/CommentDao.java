package com.zwk.weibo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zwk.weibo.entity.CommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-24 14:11
 * @ Description：
 */
@Mapper
public interface CommentDao extends BaseMapper<CommentEntity> {

    @Select(" SELECT MAX(COMMENT_ID)+1 FROM COMMENT WHERE 1=1 ")
    Long getMaxId();
}
