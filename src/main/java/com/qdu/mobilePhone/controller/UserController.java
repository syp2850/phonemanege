package com.qdu.mobilePhone.controller;

import com.qdu.mobilePhone.pojo.User;
import com.qdu.mobilePhone.service.UserService;
import com.qdu.mobilePhone.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/getUser")
    @ResponseBody
//    @ApiOperation(value="根据ID获取用户信息",httpMethod="GET",notes="get user by id",response= User.class)
    public User getUser(@RequestParam(value="userId")Integer userId) {
        return userService.showUserInfo(null).get(0);
    }

    @RequestMapping(value = "/login")
    @ResponseBody
//    @ApiOperation(value="获取用户信息")
    public String login(String username,String password) {
        return loginService.logUser(username,password);
    }

    @RequestMapping(value = "/addUer")
//    @ApiOperation(value="添加用户信息")
    @ResponseBody
    public String addUer(User user) {
        return loginService.addUser(user);
    }

}

