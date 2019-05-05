package com.qdu.mobilePhone.service;

import com.qdu.mobilePhone.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 查看用户信息
     * @return
     */
    List<User> showUserInfo(User user);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int addUserInfo(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updUserInfo(User user);

}
