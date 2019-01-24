package com.zwk.weibo.service;

import com.baomidou.mybatisplus.service.IService;
import com.zwk.weibo.entity.CommentEntity;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-25 15:22
 * @ Description：
 */
public interface CommentService extends IService<CommentEntity> {
    void insertComment(CommentEntity entity);
}
