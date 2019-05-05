package com.qdu.mobilePhone.pojo;

import java.io.Serializable;

public class Order implements Serializable{

    private Integer ord_id; //订单ID
    private String ord_number; //订单编号
    private String username; //用户名
    private String pro_name; //产品名
    private double pro_price;//产品单价
    private Integer ord_num;//订单数量
    private double ord_total;//订单总价
    private String pro_img;//产品图片
    private Integer pro_color;//产品颜色
    private Integer pro_version;//产品型号
    private String pro_desc;//描述
    private String Ord_date;//时间
    private Color co;//手机颜色
    private Version ve;//手机型号
    private Integer ord_status; //订单状态

    public Integer getOrd_status() {
        return ord_status;
    }

    public void setOrd_status(Integer ord_status) {
        this.ord_status = ord_status;
    }

    public Integer getOrd_id() {
        return ord_id;
    }

    public void setOrd_id(Integer ord_id) {
        this.ord_id = ord_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public double getPro_price() {
        return pro_price;
    }

    public void setPro_price(double pro_price) {
        this.pro_price = pro_price;
    }

    public Integer getOrd_num() {
        return ord_num;
    }

    public void setOrd_num(Integer ord_num) {
        this.ord_num = ord_num;
    }

    public double getOrd_total() {
        return ord_total;
    }

    public void setOrd_total(double ord_total) {
        this.ord_total = ord_total;
    }

    public String getPro_img() {
        return pro_img;
    }

    public void setPro_img(String pro_img) {
        this.pro_img = pro_img;
    }

    public Integer getPro_color() {
        return pro_color;
    }

    public void setPro_color(Integer pro_color) {
        this.pro_color = pro_color;
    }

    public Integer getPro_version() {
        return pro_version;
    }

    public void setPro_version(Integer pro_version) {
        this.pro_version = pro_version;
    }

    public String getPro_desc() {
        return pro_desc;
    }

    public void setPro_desc(String pro_desc) {
        this.pro_desc = pro_desc;
    }

    public String getOrd_date() {
        return Ord_date;
    }

    public void setOrd_date(String ord_date) {
        Ord_date = ord_date;
    }

    public Color getCo() {
        return co;
    }

    public void setCo(Color co) {
        this.co = co;
    }

    public Version getVe() {
        return ve;
    }

    public void setVe(Version ve) {
        this.ve = ve;
    }

    public String getOrd_number() {
        return ord_number;
    }

    public void setOrd_number(String ord_number) {
        this.ord_number = ord_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
