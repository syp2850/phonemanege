package com.qdu.phonemanege.controller;

import cn.hutool.core.bean.BeanUtil;
import com.qdu.phonemanege.dao.PhoneBrandDao;
import com.qdu.phonemanege.model.PhoneBrand;
import com.qdu.phonemanege.model.Phones;
import com.qdu.phonemanege.model.Users;
import org.springframework.beans.BeanUtils;
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
 * @date 2019/4/14
 */
@Controller
@RequestMapping("/phoneBrand")
public class PhoneBrandController {

    @Autowired
    private PhoneBrandDao phoneBrandDao;

    /*新增品牌*/
    @RequestMapping("/insert")
    @ResponseBody
    public String login(PhoneBrand phoneBrand){
       phoneBrandDao.insert(phoneBrand,"PhoneBrand");
       return "success";
    }
    /*更新品牌*/
    @RequestMapping("/update")
    @ResponseBody
    public String update(PhoneBrand phoneBrand){
        Map<String, Object> map = BeanUtil.beanToMap(phoneBrand);
        phoneBrandDao.update(phoneBrand.getId(),map,"PhoneBrand");
        return "success";
    }
    /*删除品牌*/
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String id){
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        phoneBrandDao.remove(map,"PhoneBrand");
        return "success";
    }

    /*分页获取所有品牌*/
    @RequestMapping("/findAllPage")
    @ResponseBody
    public Page<PhoneBrand> findAllPage(Integer pageNum, Integer pageSize, PhoneBrand phoneBrand){
        Map<String,String> map = new HashMap<>();
        map.put("bName",phoneBrand.getbName());
        return phoneBrandDao.paginationQuery(pageNum,pageSize,map);
    }
    /*分页获取所有品牌对应的手机*/
    @RequestMapping("/findAllPhonesPage")
    @ResponseBody
    public Page<PhoneBrand> findAllPhonesPage(Integer pageNum, Integer pageSize, PhoneBrand phoneBrand){
        Map<String,String> map = new HashMap<>();
        map.put("id",phoneBrand.getId()+"");
        return phoneBrandDao.lianbiaoQuery(pageNum,pageSize,map);
    }
}
