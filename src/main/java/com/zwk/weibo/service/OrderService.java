package com.zwk.weibo.service;

import com.baomidou.mybatisplus.service.IService;
import com.zwk.weibo.entity.OrderInfoEntity;
import com.zwk.weibo.entity.vo.OrderBO;
import com.zwk.weibo.entity.vo.OrderVO;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-25 15:25
 * @ Description：
 */
public interface OrderService extends IService<OrderInfoEntity> {

    Long insertOrder(OrderInfoEntity orderInfoEntity,String orderDetail);

    List<OrderVO> selectAllOrder(String userId);

    String refuseOrder(Long orderId);

    String acceptOrder(Long orderId);

    String getOrderStatus(Long orderId);

    String confirmOrderPay(Long orderNumber);

    List<OrderBO> selectAllOrders(String userId);

    String dispatch(Long orderId);

}
