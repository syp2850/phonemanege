package com.qdu.mobilePhone.dao;

import com.qdu.mobilePhone.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface OrderDao {
    /**
     * 查全部订单
     * @return
     */
    List<Order> selAll(Order order);

    /**
     * 增加订单
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 删除订单
     * @param Ord_id
     * @return
     */
    int delOrder(Integer Ord_id);

    /**
     * 修改订单信息
     * @param order
     * @return
     */
    int updOrder(Order order);
}
