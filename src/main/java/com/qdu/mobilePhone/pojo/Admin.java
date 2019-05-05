package com.qdu.mobilePhone.pojo;

/**
 * 管理员类
 */
public class Admin {

    private Integer id;    //管理员ID
    private String user;   //账号
    private String password; //密码
    private Integer status; //管理权限

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
