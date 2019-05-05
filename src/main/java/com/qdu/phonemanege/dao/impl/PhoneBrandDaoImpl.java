package com.qdu.phonemanege.dao.impl;

import cn.hutool.core.util.StrUtil;
import com.mongodb.BasicDBObject;
import com.qdu.phonemanege.commens.PageModel;
import com.qdu.phonemanege.commens.RemoveDollarOperation;
import com.qdu.phonemanege.commens.SpringbootPageable;
import com.qdu.phonemanege.dao.PhoneBrandDao;
import com.qdu.phonemanege.model.PhoneBrand;
import com.qdu.phonemanege.model.Phones;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author songyunpeng
 * @decription
 * @date 2019/4/14
 */
@Repository("PhoneBrandDaoImpl")
public class PhoneBrandDaoImpl implements PhoneBrandDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(PhoneBrand object, String collectionName) {
        object.setDelStatus("0");
        mongoTemplate.insert(object, collectionName);
    }

    @Override
    public PhoneBrand findOneByID(Map<String, Object> params, String collectionName) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(Long.parseLong(params.get("id")+""))), PhoneBrand.class, collectionName);

    }

    @Override
    public List<PhoneBrand> findAll(Map<String, Object> params, String collectionName) {
        List<PhoneBrand > result = mongoTemplate.find(new Query(), PhoneBrand.class, collectionName);
        return result;
    }

    @Override
    public void update(long id, Map<String, Object> params, String collectionName) {
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
        mongoTemplate.upsert(new Query(Criteria.where("_id").is(id)), update, PhoneBrand.class, collectionName);
    }

    @Override
    public void createCollection(String collectionName) {

    }

    @Override
    public void remove(Map<String, Object> params, String collectionName) {
        mongoTemplate.remove(new Query(Criteria.where("_id").is(params.get("id"))), PhoneBrand.class, collectionName);
    }

    @Override
    public Page<PhoneBrand> paginationQuery(Integer pageNum, Integer pageSize, Map<String, String> map) {
        SpringbootPageable pageable = new SpringbootPageable();
        PageModel pm=new PageModel();
        Query query = new Query();
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        //排序
        orders.add(new Sort.Order(Sort.Direction.DESC, "pPrice"));
        Sort sort = new Sort(orders);
        // 开始页
        pm.setPagenumber(pageNum);
        // 每页条数
        pm.setPagesize(pageSize);
        // 排序
        pm.setSort(sort);
        pageable.setPage(pm);
        // 查询出一共的条数
        Long count = mongoTemplate.count(query, PhoneBrand.class);
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
        List<PhoneBrand> list = mongoTemplate.find(query2.with(pageable), PhoneBrand.class);
        // 将集合与分页结果封装
        Page<PhoneBrand> pagelist = new PageImpl<PhoneBrand>(list, pageable, count);
        return pagelist;
    }

    @Override
    public Page<PhoneBrand> lianbiaoQuery(Integer pageNum, Integer pageSize, Map<String, String> map) {
        SpringbootPageable pageable = new SpringbootPageable();
        PageModel pm=new PageModel();
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        //排序
        orders.add(new Sort.Order(Sort.Direction.DESC, "pPrice"));
        Sort sort = new Sort(orders);
        // 开始页
        pm.setPagenumber(pageNum);
        // 每页条数
        pm.setPagesize(pageSize);
        // 排序
        pm.setSort(sort);
        pageable.setPage(pm);
        //拼装关联信息
        LookupOperation lookupOperation = LookupOperation.newLookup().
                from("Phones").//关联表名
                localField("_id").//关联字段
                foreignField("pCategoryId").//主表关联字段对应的次表字段
                as("phones");//查询结果集合名
        //手机表查询条件
        Criteria qqq=Criteria.where("_id").is(Long.parseLong(map.get("id")+""));
        AggregationOperation match= Aggregation.match(qqq);
        Aggregation aggregation = Aggregation.newAggregation(match,lookupOperation,Aggregation.sort(pageable.getSort()),//排序
                Aggregation.skip(pageable.getPageNumber()>1?(pageable.getPageNumber()-1)*pageable.getPageSize():0),//pagenumber
                Aggregation.limit(pageable.getPageSize()));//pagesize
        // 查询出一共的条数
        Aggregation counts = Aggregation.newAggregation(match,lookupOperation);
        int count = mongoTemplate.aggregate(counts, "PhoneBrand", BasicDBObject.class).getMappedResults().size();

        List<BasicDBObject> results = mongoTemplate.aggregate(aggregation, "PhoneBrand", BasicDBObject.class).getMappedResults();
        System.out.println(results);
        return null;
    }
}
