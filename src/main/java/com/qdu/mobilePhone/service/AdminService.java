package com.qdu.mobilePhone.service;

import com.qdu.mobilePhone.pojo.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdminService {

    /**
     * 展示管理员信息
     * @param admin
     * @return
     */
    List<Admin> showAdmin(Admin admin);

    /**
     * 增加管理员信息
     * @param admin
     * @return
     */
    int addAdmin(Admin admin);

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    int updAdmin(Admin admin);

    /**
     * 删除管理员信息
     * @param id
     * @return
     */
    int delAdmin(Integer id);

    /**
     * 管理员登陆
     * @param request 请求
     * @return
     */
    String AdminLogin(HttpServletRequest request);
}
