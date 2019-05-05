package com.qdu.mobilePhone.pojo;

/**
 * 用户评论类
 */
public class Comment {

    private Integer com_id; //评论编号
    private String username; //用户名
    private String pro_name; //产品名
    private String comment; //评论内容
    private String com_date; //评论日期
    private String com_type; //评论类型

    public Integer getCom_id() {
        return com_id;
    }

    public void setCom_id(Integer com_id) {
        this.com_id = com_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCom_date() {
        return com_date;
    }

    public void setCom_date(String com_date) {
        this.com_date = com_date;
    }

    public String getCom_type() {
        return com_type;
    }

    public void setCom_type(String com_type) {
        this.com_type = com_type;
    }
}
