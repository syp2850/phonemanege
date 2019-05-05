package com.qdu.mobilePhone.pojo;

/**
 * 用户类
 */
public class User {

    private Integer id; //用户ID
    private String username; //用户名
    private String password; //用户密码
    private String phone; //手机号
    private String address; //送货地址
    private Integer integral; //积分
    private String uopenid; //openID 微信唯一标识
    private String ulogo; //用户标识
    private String usernum; //用户码

    public String getUopenid() {
        return uopenid;
    }

    public void setUopenid(String uopenid) {
        this.uopenid = uopenid;
    }

    public String getUlogo() {
        return ulogo;
    }

    public void setUlogo(String ulogo) {
        this.ulogo = ulogo;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}
