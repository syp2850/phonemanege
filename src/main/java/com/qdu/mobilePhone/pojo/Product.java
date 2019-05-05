package com.qdu.mobilePhone.pojo;

import java.io.Serializable;

/**
 * 产品类
 */
public class Product implements Serializable {

    public boolean get;
    private Integer Pro_id;         //产品编号
    private String Pro_name;        //产品名字
    private String Pro_sort;        //产品类型
    private Double Pro_price;       //产品价格
    private String Pro_img;         //产品图片
    private String Pro_desc;        //产品描述
    private Integer Pro_num;        //库存数量
    private Integer Pro_weight;     //产品重量
    private Integer Pro_color;       //产品颜色编号
    private Integer Pro_version;     //产品版本编号
    private Color color;            //产品颜色
    private Version version;        //产品版本
    private Integer Pro_brand;   //品牌ID
    private Brand brand;
    private Integer Pro_hot;

    public Integer getPro_hot() {
        return Pro_hot;
    }

    public void setPro_hot(Integer pro_hot) {
        Pro_hot = pro_hot;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getPro_brand() {
        return Pro_brand;
    }

    public void setPro_brand(Integer pro_brand) {
        Pro_brand = pro_brand;
    }

    public boolean isGet() {
        return get;
    }

    public void setGet(boolean get) {
        this.get = get;
    }

    public Integer getPro_id() {
        return Pro_id;
    }

    public void setPro_id(Integer pro_id) {
        Pro_id = pro_id;
    }

    public String getPro_name() {
        return Pro_name;
    }

    public void setPro_name(String pro_name) {
        Pro_name = pro_name;
    }

    public String getPro_sort() {
        return Pro_sort;
    }

    public void setPro_sort(String pro_sort) {
        Pro_sort = pro_sort;
    }

    public Double getPro_price() {
        return Pro_price;
    }

    public void setPro_price(Double pro_price) {
        Pro_price = pro_price;
    }

    public String getPro_img() {
        return Pro_img;
    }

    public void setPro_img(String pro_img) {
        Pro_img = pro_img;
    }

    public String getPro_desc() {
        return Pro_desc;
    }

    public void setPro_desc(String pro_desc) {
        Pro_desc = pro_desc;
    }

    public Integer getPro_num() {
        return Pro_num;
    }

    public void setPro_num(Integer pro_num) {
        Pro_num = pro_num;
    }

    public Integer getPro_weight() {
        return Pro_weight;
    }

    public void setPro_weight(Integer pro_weight) {
        Pro_weight = pro_weight;
    }

    public Integer getPro_color() {
        return Pro_color;
    }

    public void setPro_color(Integer pro_color) {
        Pro_color = pro_color;
    }

    public Integer getPro_version() {
        return Pro_version;
    }

    public void setPro_version(Integer pro_version) {
        Pro_version = pro_version;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
