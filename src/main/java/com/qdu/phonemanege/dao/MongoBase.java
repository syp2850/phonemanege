package com.qdu.phonemanege.dao;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface MongoBase<T> {
    //添加  
    void insert(T object,String collectionName);
    //根据ID查找
    T findOneByID(Map<String,Object> params, String collectionName);
    //查找所有  
    List<T> findAll(Map<String,Object> params, String collectionName);
    //修改  
    void update(long id,Map<String,Object> params,String collectionName);
    //创建集合  
    void createCollection(String collectionName);
    //根据条件删除  
    void remove(Map<String,Object> params,String collectionName);
    /*分页查询*/
     Page<T> paginationQuery(Integer pageNum,Integer pageSize,Map<String,String> map);
      
}  