package com.qdu.mobilePhone.service.impl;

import com.alibaba.fastjson.JSON;
import com.qdu.mobilePhone.dao.UserDao;
import com.qdu.mobilePhone.pojo.User;
import com.qdu.mobilePhone.service.LoginService;
import com.qdu.mobilePhone.util.Base64Utils;
import com.qdu.mobilePhone.util.FourNumUtil;
import com.qdu.mobilePhone.util.GetOpenIdUtil;
import com.qdu.mobilePhone.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private GetOpenIdUtil getopenid;
    public GetOpenIdUtil getGetopenid() {
        return this.getopenid;
    }
    public void setGetopenid(GetOpenIdUtil getopenid) {
        this.getopenid = getopenid;
    }

    @Autowired
    private UserDao userdao;
    public UserDao getUserdao() {
        return this.userdao;
    }
    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }

    @Autowired
    private FourNumUtil fnu;
    public FourNumUtil getFnu() {
        return fnu;
    }
    public void setFnu(FourNumUtil fnu) {
        this.fnu = fnu;
    }


    public String logUser(String username, String password) {
        Map<String,Object> map = new HashMap<String, Object>();
        if (username != null&&password!=null){
                User user1 = userdao.selUserByUserName(username);
                if (user1!=null){
                    password = MD5Util.digest(password);
                    if(user1.getPassword().equals(password)){
                        map.put("data",user1);
                        map.put("errmsg","查找成功");
                        map.put("code","0");
                    }else{
                        map.put("errmsg","账号密码不匹配");
                        map.put("code","0");
                    }

                }else {
                    map.put("errmsg","没有该用户请注册！");
                    map.put("code","1");
                }
        }else{
            map.put("errmsg","无账号密码");
            map.put("code","1");
        }
        return JSON.toJSONString(map);
    }


    public String addUser(User user) {
        Map<String,Object> map = new HashMap<String, Object>();
        if (user!=null){
            /*先判断是否重名*/
            User user1 = userdao.selUserByUserName(user.getUsername());
            if(user1!=null){
                map.put("errmsg","用户名重复！");
                map.put("code","1");
                return JSON.toJSONString(map);
            }
            String account=null;
            account = fnu.CreateAccount();
            user.setUsernum(account);
            String pwd = user.getPassword();
            user.setPassword(MD5Util.digest(pwd));
            int veriinfo= userdao.addUser(user);
            if (veriinfo!=0){
                map.put("errmsg","注册成功");
                map.put("code","0");
            }else {
                map.put("errmsg","注册失败！");
                map.put("code","1");
            }

        }else{
            map.put("errmsg","实体类错误！");
            map.put("code","1");
        }
        return JSON.toJSONString(map);
    }


}
