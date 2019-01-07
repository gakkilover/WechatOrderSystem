package com.zwk.weibo.controller.Api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zwk.weibo.constant.Final;
import com.zwk.weibo.entity.OrderInfoEntity;
import com.zwk.weibo.entity.vo.OrderBO;
import com.zwk.weibo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-03 08:46
 * @ Description：
 */
@RestController
@Api(tags = "订单操作》",description = "接口")
@RequestMapping("/api/order")
public class OrderApi {

    @Autowired
    private OrderService orderService;

    @ApiOperation("全部订单")
    @PostMapping("/orderList")
    public String orderList(@RequestParam("userId")String userId){
        List<OrderBO> orderList = orderService.selectAllOrders(userId);
        return JSONObject.toJSONString(orderList);
    }

    @ApiOperation("插入订单")
    @PostMapping("/insertOrder")
    public Long insertOrder(@RequestParam String orderDetail, @RequestParam Float totalPrice, @RequestParam Long addressId,
                              @RequestParam String orderDescription,  @RequestParam Long coversNumber, @RequestParam Long userId){
        OrderInfoEntity orderInfoEntity=new OrderInfoEntity();
        orderInfoEntity.setStoreId(1L);
        orderInfoEntity.setTotalPrice(totalPrice);
        orderInfoEntity.setUserId(userId);
        orderInfoEntity.setOrderDescription(orderDescription);
        orderInfoEntity.setCoversNumber(coversNumber);
        orderInfoEntity.setAddressId(addressId);
        Long orderNumber=orderService.insertOrder(orderInfoEntity,orderDetail);
        return orderNumber;
    }

    @ApiOperation("查询订单状态")
    @PostMapping("/getOrderStatus")
    public String getOrderStatus(@RequestParam("orderId")Long orderId){

        return orderService.getOrderStatus(orderId);
    }

    @ApiOperation("支付完成通知")
    @PostMapping("/confirmOrderPay")
    public String confirmOrderPay(@RequestParam("orderNumber")Long orderNumber){
        String msg=orderService.confirmOrderPay(orderNumber);
        return msg;
    }

}
