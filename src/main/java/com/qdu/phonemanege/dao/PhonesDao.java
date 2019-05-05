package com.qdu.phonemanege.dao;

import com.qdu.phonemanege.model.Phones;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface PhonesDao extends MongoBase<Phones>{
    /*连表查当前品牌的手机列表*/
    Page<Phones> lianbiaoQuery(Integer pageNum, Integer pageSize, Map<String, String> map);
}
