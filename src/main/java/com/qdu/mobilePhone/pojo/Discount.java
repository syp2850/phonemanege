package com.qdu.mobilePhone.pojo;

/**
 * 优惠券类
 */
public class Discount {

    private Integer id; //优惠券ID
    private String name; //优惠券名
    private Integer rule; //优惠规则
    private Double discount; //优惠券面额
    private Integer status; //优惠卷状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRule() {
        return rule;
    }

    public void setRule(Integer rule) {
        this.rule = rule;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

