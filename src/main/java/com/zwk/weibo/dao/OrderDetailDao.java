package com.zwk.weibo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zwk.weibo.entity.OrderDetailEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-04 15:56
 * @ Description：
 */
public interface OrderDetailDao extends BaseMapper<OrderDetailEntity> {

    @Select(" SELECT MAX(ORDER_DETAIL_ID)+1 FROM ORDER_DETAIL WHERE 1=1 ")
    Long getMaxId();

    @Select(" SELECT * FROM ORDER_DETAIL WHERE order_id=#{orderId}")
    List<OrderDetailEntity> orderDetailList(Long orderId);
}
