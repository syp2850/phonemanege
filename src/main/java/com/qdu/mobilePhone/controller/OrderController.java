package com.qdu.mobilePhone.controller;

import com.alibaba.fastjson.JSON;
import com.qdu.mobilePhone.pojo.Order;
import com.qdu.mobilePhone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/ord")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 查全部订单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selOrder")
//    @ApiOperation(value = "查询全部订单",httpMethod = "GET",response = String.class)
    public String selOrder(){
        Map<String, Order> orders = orderService.selOrder("qwerq");
        return JSON.toJSONString(orders);
    }

    /**
     * 新增订单   加入购物车！
     * //@param order @RequestBody Order order
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addOrder")
//    @ApiOperation(value = "新增订单",httpMethod = "POST",response = int.class)
    public int addOrder(){
        Order order1 = new Order();
        order1.setOrd_id(1);
        order1.setOrd_num(10);
        order1.setUsername("qwerq");
        order1.setPro_name("8848");
        return orderService.addOrder(order1);
    }

    @ResponseBody
    @RequestMapping(value = "delOrder")
//    @ApiOperation(value = "删除订单",httpMethod = "GET",response = int.class)
    public int delOrder(Integer ord_id,String username){
        return orderService.delOrder(ord_id,username);
    }

    @ResponseBody
    @RequestMapping(value = "buy")
//    @ApiOperation(value = "已购买")
    public int buy(){
        Order order = new Order();
        order.setUsername("qwerq");
        int count = orderService.persistence(order);
        return count;
    }

    @ResponseBody
    @RequestMapping(value = "shoOrder")
//    @ApiOperation(value = "展示购物车订单",httpMethod = "POST",response = int.class)
    public Map<String,Order> showOrder(){
        Order order = new Order();
        order.setUsername("qwerq");
        Map<String,Order> list = orderService.selOrder(order.getUsername());
        String list1 = JSON.toJSONString(list);
        System.out.println(list1);
        return list;
    }

}
