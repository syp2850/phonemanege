package com.qdu.mobilePhone.pojo;

/**
 * 该实体类代表了购物车里的一行数据
 */
public class Item {
    private int id; //商品id
    private String name; //商品名称
    private String city; //商品产地
    private double price; //商品价格
    private int number; //商品数量
    private String picture; //商品图片地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 重写hashCode方法，使得在购物车添加商品的时候，如果id和名称相同就判定为同一件商品
     * @return
     */
    @Override
    public int hashCode() {
        return (this.getId()+this.getName()).hashCode();
    }

    /**
     * 重写equals方法，判断是否为同一个对象
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj instanceof Item){
            Item i= (Item) obj;
            if(this.getId()==i.getId()&&this.getName().equals(i.getName())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", picture='" + picture + '\'' +
                '}';
    }

    //有参构造
    public Item(int id, String name, String city, double price, int number, String picture) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.price = price;
        this.number = number;
        this.picture = picture;
    }
    //无参构造
    public Item() {
    }
}
