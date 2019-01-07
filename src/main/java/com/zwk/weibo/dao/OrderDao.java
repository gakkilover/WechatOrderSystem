package com.zwk.weibo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zwk.weibo.entity.OrderDetailEntity;
import com.zwk.weibo.entity.OrderInfoEntity;
import com.zwk.weibo.entity.vo.OrderBO;
import com.zwk.weibo.entity.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-02 16:07
 * @ Description：
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderInfoEntity> {

    @Select(" SELECT * FROM ORDERINFO O LEFT JOIN  RECEIVE_ADDRESS R ON O.ADDRESS_ID=R.ADDRESS_ID where 1=1 ${sql} ")
     List<OrderVO> orderList(@Param("sql") String sql);

    @Select(" SELECT MAX(ORDER_ID)+1 FROM ORDERINFO  WHERE 1=1 ")
    Long getMaxId();

    @Select(" SELECT STATUS FROM ORDERINFO WHERE ORDER_NUMBER=#{orderNumber} ")
    String getOrderStatus(Long orderNumber);

    @Select(" SELECT * FROM ORDERINFO WHERE ORDER_NUMBER=#{orderNumber} ")
    OrderInfoEntity getOrderByOrderNumber(Long orderNumber);

    @Select(" SELECT * FROM ORDERINFO WHERE USER_ID=#{userId} ")
    List<OrderBO> orderLists(String userId);
}
