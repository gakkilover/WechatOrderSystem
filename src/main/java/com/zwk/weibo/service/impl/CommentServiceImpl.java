package com.zwk.weibo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zwk.weibo.dao.CommentDao;
import com.zwk.weibo.entity.CommentEntity;
import com.zwk.weibo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-24 14:12
 * @ Description：
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, CommentEntity> implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void insertComment(CommentEntity entity) {
        if(entity!=null&&entity.getCommentDiscreption()!=null){
            entity.setCommentId(commentDao.getMaxId());
            entity.setCommentDate(new Date());
            entity.setFoodId(1L);
            entity.setUserId(1L);
            entity.setCommentLevel(1);
            entity.setStoreId(1L);
            commentDao.insert(entity);
        }
    }
}
