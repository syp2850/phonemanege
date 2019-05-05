package com.qdu.phonemanege.dao.impl;

import cn.hutool.core.util.StrUtil;
import com.qdu.phonemanege.commens.PageModel;
import com.qdu.phonemanege.commens.SpringbootPageable;
import com.qdu.phonemanege.dao.UserDao;
import com.qdu.phonemanege.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository("UsersDaoImpl")  
public class UserDaoImpl implements UserDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Users object, String collectionName) {
        object.setDelStatus("0");
        mongoTemplate.insert(object, collectionName);
    }
    /*根据ID查询单个用户*/
    @Override
    public Users findOneByID(Map<String, Object> params, String collectionName) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(Long.parseLong(params.get("id")+""))), Users.class, collectionName);
    }

    @Override
    public Users findOneByLoginNameAndPwd(Map<String, Object> params, String collectionName) {
        return mongoTemplate.findOne(new Query(Criteria.where("uName").is(params.get("uName")+"").and("uPwd").is(params.get("uPwd")+"")), Users.class, collectionName);
    }

    @Override
    public Users findOneByLoginName(Map<String, Object> params, String collectionName) {
        return mongoTemplate.findOne(new Query(Criteria.where("uName").is(params.get("uName")+"")), Users.class, collectionName);
    }

    /* params 传null */
    @Override
    public List<Users> findAll(Map<String, Object> params, String collectionName) {
        List<Users> result = mongoTemplate.find(new Query(), Users.class, collectionName);
        return result;
    }

    @Override
    public void update(long id,Map<String, Object> params, String collectionName) {
        Update update = new Update();
        if(params.size()>0){
            Set<Map.Entry<String,Object>> es = params.entrySet();
            for(Map.Entry<String,Object> e : es){
                String k = e.getKey();
                String v = e.getValue().toString();
                if(StrUtil.isNotBlank(v)){
                    update.set(k,v);
                }
            }
        }
        mongoTemplate.updateFirst(new Query(Criteria.where("id").is(id)), update, Users.class, collectionName);
    }

    @Override
    public void createCollection(String name) {
        mongoTemplate.createCollection(name);
    }


    @Override
    public void remove(Map<String, Object> params, String collectionName) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(params.get("id"))), Users.class, collectionName);
    }

    @Override
    public Page<Users> paginationQuery(Integer pageNum,Integer pageSize,Map<String,String> map) {
        SpringbootPageable pageable = new SpringbootPageable();
        PageModel pm=new PageModel();
        Query query = new Query();
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        //排序
        orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
        Sort sort = new Sort(orders);
        // 开始页
        pm.setPagenumber(pageNum);
        // 每页条数
        pm.setPagesize(pageSize);
        // 排序
        pm.setSort(sort);
        pageable.setPage(pm);
        // 查询出一共的条数
        Long count = mongoTemplate.count(query, Users.class);
        // 多条件方式查询
        Query query2 =new Query();
        Criteria criteria = Criteria.where("delStatus").is("0");
        if(map.size()>0){
            Set<Map.Entry<String,String>> es = map.entrySet();
            for(Map.Entry<String,String> e : es){
                String k = e.getKey();
                String v = e.getValue();
                if(StrUtil.isNotBlank(v)){
                    criteria.and(k).is(v);
                }
            }
            query2.addCriteria(criteria);
        }
        List<Users> list = mongoTemplate.find(query2.with(pageable), Users.class);
        // 将集合与分页结果封装
        Page<Users> pagelist = new PageImpl<Users>(list, pageable, count);
        return pagelist;
    }
}