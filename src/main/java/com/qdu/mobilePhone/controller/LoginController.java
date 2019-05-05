package com.qdu.mobilePhone.controller;

import com.alibaba.fastjson.JSON;
import com.qdu.mobilePhone.pojo.User;
import com.qdu.mobilePhone.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping("/userLogin")
    public String userLogin(String username,String code){
        return JSON.toJSONString(loginService.logUser(username, code));
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        return loginService.addUser(user);
    }

}
