package com.zwk.weibo.service;

import com.baomidou.mybatisplus.service.IService;
import com.zwk.weibo.entity.OrderDetailEntity;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-25 15:26
 * @ Description：
 */
public interface OrderDetailService extends IService<OrderDetailEntity> {

    List<OrderDetailEntity> orderDetailList(Long orderId);
}
