package com.qdu.phonemanege.dao.impl;

import cn.hutool.core.util.StrUtil;
import com.mongodb.BasicDBObject;
import com.qdu.phonemanege.commens.PageModel;
import com.qdu.phonemanege.commens.SpringbootPageable;
import com.qdu.phonemanege.dao.PhonesDao;
import com.qdu.phonemanege.model.Phones;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
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
 * @date 2019/4/10
 */
@Repository("PhonesDaoImpl")
public class PhonesDaoImpl implements PhonesDao {


    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Phones object, String collectionName) {
        object.setDelStatus("0");
        mongoTemplate.insert(object, collectionName);
    }

    @Override
    public Phones findOneByID(Map<String, Object> params, String collectionName) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(Long.parseLong(params.get("id")+""))), Phones.class, collectionName);

    }

    @Override
    public List<Phones> findAll(Map<String, Object> params, String collectionName) {
        List<Phones > result = mongoTemplate.find(new Query(), Phones.class, collectionName);
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
        mongoTemplate.upsert(new Query(Criteria.where("id").is(id)), update, Phones.class, collectionName);

    }

    @Override
    public void createCollection(String collectionName) {
        mongoTemplate.createCollection(collectionName);
    }

    @Override
    public void remove(Map<String, Object> params, String collectionName) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(params.get("id")+"")), Phones.class, collectionName);

    }

    @Override
    public Page<Phones> paginationQuery(Integer pageNum, Integer pageSize, Map<String, String> map) {
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
        Long count = mongoTemplate.count(query, Phones.class);
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
        List<Phones> list = mongoTemplate.find(query2.with(pageable), Phones.class);
        // 将集合与分页结果封装
        Page<Phones> pagelist = new PageImpl<Phones>(list, pageable, count);
        return pagelist;
    }

    @Override
    public Page<Phones> lianbiaoQuery(Integer pageNum, Integer pageSize, Map<String, String> map) {
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
                from("PhoneBrand").//关联表名
                localField("pCategoryId").//关联字段
                foreignField("_id").//主表关联字段对应的次表字段
                as("phones");//查询结果集合名
        //手机表查询条件
        Criteria qqq=Criteria.where("pCategoryId").is(map.get("pCategoryId")+"");
        AggregationOperation match= Aggregation.match(qqq);
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation,match,Aggregation.sort(pageable.getSort()),//排序
                Aggregation.skip(pageable.getPageNumber()>1?(pageable.getPageNumber()-1)*pageable.getPageSize():0),//pagenumber
                Aggregation.limit(pageable.getPageSize()));//pagesize
        // 查询出一共的条数
        Aggregation counts = Aggregation.newAggregation(lookupOperation,match);
        int count = mongoTemplate.aggregate(counts, "Phones", BasicDBObject.class).getMappedResults().size();

        List<BasicDBObject> results = mongoTemplate.aggregate(aggregation, "Phones", BasicDBObject.class).getMappedResults();
        System.out.println(results);
        return null;
    }
}
