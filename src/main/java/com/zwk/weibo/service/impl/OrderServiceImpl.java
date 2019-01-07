package com.zwk.weibo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zwk.weibo.constant.Final;
import com.zwk.weibo.dao.OrderDao;
import com.zwk.weibo.dao.OrderDetailDao;
import com.zwk.weibo.entity.OrderDetailEntity;
import com.zwk.weibo.entity.OrderInfoEntity;
import com.zwk.weibo.entity.vo.OrderBO;
import com.zwk.weibo.entity.vo.OrderVO;
import com.zwk.weibo.service.OrderService;
import com.zwk.weibo.utils.OrderNumberGenerateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-02 16:09
 * @ Description：
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao,OrderInfoEntity> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public Long insertOrder(OrderInfoEntity orderInfoEntity, String orderDetailInfo) {

        //String param = "[{\"foodName\":\"红烧狮子头\",\"count\":2,\"foodPic\":\"lion.jpg\"},{\"foodName\":\"炸鸡\",\"count\":4,\"foodPic\":\"lion.jpg\"}]";
       //orderDetailInfo=param;
        List<OrderDetailEntity> orderDeatilList=JSONObject.parseArray(orderDetailInfo,OrderDetailEntity.class);
        Long orderId=orderDao.getMaxId();
        Long orderNumber=OrderNumberGenerateUtil.getNmber();
        orderInfoEntity.setOrderNumber(orderNumber);
        orderInfoEntity.setOrderId(orderId);
        orderInfoEntity.setStatus(Final.ORDER_STATUS_UNNPAY);
        orderDao.insert(orderInfoEntity);
        for (OrderDetailEntity orderDetail:orderDeatilList) {
            orderDetail.setOrderDetailId(orderDetailDao.getMaxId());
            orderDetail.setOrderId(orderId);
            orderDetailDao.insert(orderDetail);
        }
        return orderNumber;
    }

    @Override
    public List<OrderVO> selectAllOrder(String userId) {
        StringBuffer sb=new StringBuffer();

        if(userId!=null&&StringUtils.isNotBlank(userId)){
            sb.append(" AND USER_ID= "+userId);
        }
        return orderDao.orderList(sb.toString());
    }

    @Override
    public String refuseOrder(Long orderId) {
        OrderInfoEntity orderInfoEntity=orderDao.selectById(orderId);
        if(orderInfoEntity.getStatus().equals(Final.ORDER_STATUS_PAY)||orderInfoEntity.getStatus().equals(Final.ORDER_STATUS_UNNPAY)){
            orderInfoEntity.setStatus(Final.ORDER_STATUS_UNEFFECT);
            this.updateById(orderInfoEntity);
        }
        return "订单状态信息有误";
    }

    @Override
    public String acceptOrder(Long orderId) {
        OrderInfoEntity orderInfoEntity=orderDao.selectById(orderId);
        if(orderInfoEntity.getStatus().equals(Final.ORDER_STATUS_PAY)){
            orderInfoEntity.setStatus(Final.ORDER_STATUS_UNDISPATCH);
            this.updateById(orderInfoEntity);
        }
        return "订单状态信息有误";
    }

    @Override
    public String getOrderStatus(Long orderId) {
        return orderDao.getOrderStatus(orderId);
    }

    @Override
    public String confirmOrderPay(Long orderNumber) {
        OrderInfoEntity order= orderDao.getOrderByOrderNumber(orderNumber);
        order.setStatus(Final.ORDER_STATUS_PAY);
        this.updateById(order);
        return Final.SUCCESS;
    }

    @Override
    public List<OrderBO> selectAllOrders(String userId) {
        List<OrderBO> orderInfoList=new ArrayList<>();
        if(userId!=null&&StringUtils.isNotBlank(userId)){
            orderInfoList= orderDao.orderLists(userId);
        }
        for (OrderBO orderInfo:orderInfoList) {
            List<OrderDetailEntity> orderDeatilList=orderDetailDao.orderDetailList(orderInfo.getOrderId());
            orderInfo.setOrderDetail(orderDeatilList);
        }
        return orderInfoList;
    }

    @Override
    public String dispatch(Long orderId) {
        OrderInfoEntity orderInfoEntity=orderDao.selectById(orderId);
        if(orderInfoEntity.getStatus().equals(Final.ORDER_STATUS_UNDISPATCH)){
            orderInfoEntity.setStatus(Final.ORDER_STATUS_SENDED);
            this.updateById(orderInfoEntity);
            return Final.SUCCESS;
        }
        return "订单状态信息有误";
    }
}
