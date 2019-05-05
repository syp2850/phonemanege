package com.qdu.mobilePhone.service.impl;

import com.qdu.mobilePhone.dao.UserDao;
import com.qdu.mobilePhone.pojo.User;
import com.qdu.mobilePhone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usi")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;

    public List<User> showUserInfo(User user) {
        List<User> list = userDao.selAllUser(null);
        if(list != null && list.size() > 0){
            return list;
        }
        return null;
    }

    public int addUserInfo(User user) {
        int count = userDao.addUser(user);
        return count;
    }

    public int updUserInfo(User user) {
        int count = userDao.updUser(user);
        return count;
    }
}
