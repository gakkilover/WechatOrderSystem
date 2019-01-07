package com.zwk.weibo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zwk.weibo.dao.OrderDetailDao;
import com.zwk.weibo.entity.OrderDetailEntity;
import com.zwk.weibo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-05 16:19
 * @ Description：
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailDao,OrderDetailEntity> implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public List<OrderDetailEntity> orderDetailList(Long orderId) {
        return orderDetailDao.orderDetailList(orderId);
    }
}
