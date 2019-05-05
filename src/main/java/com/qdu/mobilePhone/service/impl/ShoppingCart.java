package com.qdu.mobilePhone.service.impl;

import com.qdu.mobilePhone.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service
public class ShoppingCart {
    //购买商品的集合
    private HashMap<Item,Integer> goods;
    //购物车的总金额
    private double totalPrice;

    //构造方法初始化数据
    public ShoppingCart(){
        goods=new HashMap<Item,Integer>();
        totalPrice=0.0;
    }
    public HashMap<Item, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Item, Integer> goods) {
        this.goods = goods;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    //添加商品进购物车的方法
    public boolean addGoodsInCart(Item item,int number){
        if(goods.containsKey(item)){
            goods.put(item,goods.get(item)+number);
        }else{
            goods.put(item,number);
        }
        calTotalPrice();//重新计算购物车的总金额
        return  true;
    }
    //删除商品的方法
    public  boolean removeGoodsFromCart(Item item){
        goods.remove(item);
        calTotalPrice();//重新计算购物车的总金额
        return true;
    }
    //统计购物车的总金额
    public double calTotalPrice(){
        double sum=0.0;
        Set<Item> keys=goods.keySet();
        Iterator<Item> iterator = keys.iterator();
        while (iterator.hasNext()){
            Item i = iterator.next();
            sum+=i.getPrice()*goods.get(i);
        }
        this.setTotalPrice(sum);//设置购物车的总金额
        return this.getTotalPrice();
    }

    //测试的main方法
    public static void main(String[] args) {
        //先创建两个商品对象
        Item i1=new Item(1,"耐克","温州",300.0,500,"001.jpg");
        Item i2=new Item(2,"阿迪","广州",500.0,500,"001.jpg");
        Item i3=new Item(1,"耐克","温州",300.0,500,"001.jpg");
        ShoppingCart c=new ShoppingCart();
        c.addGoodsInCart(i1,1);
        c.addGoodsInCart(i2,2);
        //再次购买耐克鞋
        c.addGoodsInCart(i3,3);
        //遍历购买商品的集合
        HashMap<Item, Integer> goods = c.getGoods();
        Set<Map.Entry<Item, Integer>> entries = goods.entrySet();
        for(Map.Entry<Item, Integer> itemEntry:entries){
            System.out.println(itemEntry.toString());
        }
        System.out.println("购物车总金额:"+c.getTotalPrice());
    }

}
