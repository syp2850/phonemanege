package com.qdu.mobilePhone.dao;

import com.qdu.mobilePhone.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    List<User> selAllUser(User user);

    /**
     * 添加用户
     * @return
     */
    int addUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updUser(User user);
    User selUserByUserName(String username);

}
