package com.qdu.mobilePhone.service.impl;

import com.alibaba.fastjson.JSON;
import com.qdu.mobilePhone.dao.OrderDao;
import com.qdu.mobilePhone.dao.ProductDao;
import com.qdu.mobilePhone.pojo.Order;
import com.qdu.mobilePhone.pojo.Product;
import com.qdu.mobilePhone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Resource
    private RedisTemplate redisTemplate;

    public int addOrder(Order order) {
        //设置订单生成时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = sdf.format(new Date());
        order.setOrd_date(datetime);
        //设置订单状态 0：未下单状态
        order.setOrd_status(0);
        //设置订单编号
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String number = sdf1.format(new Date());
        order.setOrd_number(number);
        //存入redis
        Map<String,Order> orderMap = new HashMap<String, Order>(); //键：订单编号 值：订单对象
       orderMap.put(order.getOrd_number(),order);
        //根据用户名放入redis
        redisTemplate.opsForHash().put(order.getUsername(),order.getOrd_number(), JSON.toJSONString(order));
        //设置订单保存时长一小时
        redisTemplate.expire(order.getUsername(),60*60, TimeUnit.SECONDS);
        return 1;
    }

    public int delOrder(Integer ord_id,String username) {
        Map<String,Order> orderMap = redisTemplate.opsForHash().entries(username);
        for (Order o: orderMap.values()) {
            if(o.getOrd_id() == ord_id){
                orderMap.remove(o);
            }
        }
        //删除后的订单集合放回到redis中
        redisTemplate.opsForHash().putAll(username,orderMap);
        return 0;
    }

    public Map<String,Order> selOrder(String username) {
        Map<String,Order> orderMap = redisTemplate.opsForHash().entries(username);
        if(orderMap != null){
            return orderMap;
        }
        return null;
    }

    public int updOrder(Order order) {
        String username = order.getUsername(); //用户名
        String ord_number = order.getOrd_number(); //订单编号
        Integer ord_num = order.getOrd_num(); //购买数量
        Integer pro_version = order.getPro_version(); //手机版本
        Integer ord_status = order.getOrd_status(); //订单状态
        if(username == null || ord_number == null ){
            return 0;
        }
        if(ord_num == null && ord_num < 0 && ord_status == null && ord_status < 0 && pro_version == null && pro_version < 0){
            return 0;
        }
        Map<String,Order> orderMap = redisTemplate.opsForHash().entries(username);
        for (Order o: orderMap.values()) {
            if(o.getOrd_number().equals(ord_number)){
                o.setOrd_num(ord_num);
                o.setOrd_status(ord_status);
                o.setPro_version(pro_version);
            }
        }
        return 1;
    }

    public int persistence(Order order) {
        String username = order.getUsername(); //用户名
        String ord_number = order.getOrd_number(); //订单编号
        String pro_name = order.getPro_name(); //产品名称
        Integer ord_num = order.getOrd_num(); //购买数量
        Integer ord_status = order.getOrd_status(); //订单状态
        if(username == null || ord_number == null){
            return 0;
        }
        //减库存
        Product oldProduct = new Product();
        oldProduct.setPro_name(pro_name);
        Product product = productDao.selAll(oldProduct).get(0);
        product.setPro_num(product.getPro_num()-ord_num);
        //改变订单状态 1:已下单
        order.setOrd_status(1);
        Map<String,Order> orderMap = redisTemplate.opsForHash().entries(username);
        for (Order o: orderMap.values()) {
            if(o.getOrd_number().equals(ord_number)){
                return orderDao.addOrder(o); //持久化订单
            }
        }
        return 0;
    }

    public List<Order> showOrder(Order order) {
        return orderDao.selAll(order);
    }

    public int delOrders(Integer id) {
        return orderDao.delOrder(id);
    }

    /**
     * 修改订单信息 主要用于修改订单状态
     * @param order
     * @return
     */
    public int updOrders(Order order) {
        return orderDao.updOrder(order);
    }
}