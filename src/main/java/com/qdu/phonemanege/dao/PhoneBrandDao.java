package com.qdu.phonemanege.dao;

import com.qdu.phonemanege.model.PhoneBrand;
import com.qdu.phonemanege.model.Phones;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface PhoneBrandDao extends MongoBase<PhoneBrand>{
    /*查询品牌对应的手机列表*/
    Page<PhoneBrand> lianbiaoQuery(Integer pageNum, Integer pageSize, Map<String, String> map);
}
