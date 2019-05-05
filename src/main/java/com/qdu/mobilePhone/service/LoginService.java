package com.qdu.mobilePhone.service;

import com.qdu.mobilePhone.pojo.User;
import org.springframework.stereotype.Service;

/**
 * 登陆接口
 */
@Service
public interface LoginService {

    String logUser(String username, String code);

    String addUser(User user);

}
