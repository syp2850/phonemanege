package com.qdu.phonemanege.dao;


import com.qdu.phonemanege.model.Users;

import java.util.Map;

public interface UserDao extends MongoBase<Users>{
    //根据用户名和密码查找
    Users findOneByLoginNameAndPwd(Map<String,Object> params, String collectionName);
    Users findOneByLoginName(Map<String,Object> params, String collectionName);
} 