package com.qdu.phonemanege.controller;

import cn.hutool.core.util.StrUtil;
import com.qdu.phonemanege.dao.UserDao;
import com.qdu.phonemanege.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songyunpeng
 * @decription
 * @date 2019/4/9
 */
/*@Controller
@RequestMapping("/user")*/
public class UsersController {

    @Autowired
    private UserDao userDao;

    /*用户登录验证*/
    @RequestMapping("/login")
    @ResponseBody
    public boolean login(String uName,String uPwd){
        Map<String,Object> map = new HashMap();
        map.put("uName",uName);
        map.put("uPwd",uPwd);
        Users users = userDao.findOneByLoginNameAndPwd(map, "Users");
        if(users!=null){
            return true;
        }
        return false;
    }

    /* 获取用户登录信息 */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Users getUserInfo(String id){
        Map<String,Object> map = new HashMap();
        map.put("id",id);
        return userDao.findOneByID(map,"Users");
    }

    /*新增用户*/
    @RequestMapping("/insertUser")
    @ResponseBody
    public String InsertUser(Users users){
        Map<String,Object> map = new HashMap();
        map.put("uName",users.getuName());
        Users users1 = userDao.findOneByLoginName(map, "Users");
        if(users1!=null){
            return "failed";
        }
        userDao.insert(users,"Users");
        return "success";
    }

    /*获取所有用户*/
    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<Users> getAllUser(){
       return userDao.findAll(null,"Users");
    }

    /*分页获取所有用户*/
    @RequestMapping("/getUserPage")
    @ResponseBody
    public Page<Users> getUserPage(Integer pageNum, Integer pageSize,String uName){
        Map<String,String> map = new HashMap<>();
        map.put("uName",uName);
        return userDao.paginationQuery(pageNum,pageSize,map);
    }

    /*密码更改*/
    @RequestMapping("/updatePwd")
    @ResponseBody
    public String updatePwd(long id,String oldPwd,String newpwd){
        Map<String,Object> map = new HashMap<>();
        map.put("uPwd",newpwd);
        userDao.update(id,map,"Users");
        return "success";
    }
}
