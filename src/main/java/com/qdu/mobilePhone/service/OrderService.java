package com.qdu.mobilePhone.service;

import com.qdu.mobilePhone.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderService {

    /**
     * 添加订单 状态（加入购物车，未下单）
     * @param order 订单
     * @return
     */
    int addOrder(Order order);

    /**
     * 根据id删除 用户未下单的订单
     * @param ord_id 订单id
     * @param username 用户名
     * @return 删除个数
     */
    int delOrder(@Param("ord_id") Integer ord_id, @Param("username") String username);

    /**
     * 在购物车显示客户定单
     * @param username 用户名
     * @return map集合
     */
    Map<String,Order> selOrder(String username);

    /**
     * 修改redis中的订单信息
     * @param order 订单
     * @return
     */
    int updOrder(Order order);

    /**
     * 顾客下单 持久化redis里的订单信息
     * @param order 订单
     * @return
     */
    int persistence(Order order);

    /**
     * 查询已付款订单信息
     *
     * @param order
     * @return
     */
    List<Order> showOrder(Order order);

    /**
     * 删除已付款订单信息
     *
     * @param id
     * @return
     */
    int delOrders(Integer id);

    /**
     * 修改已付款订单信息
     *
     * @param order
     * @return
     */
    int updOrders(Order order);
}
