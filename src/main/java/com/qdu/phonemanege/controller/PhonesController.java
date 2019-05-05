package com.qdu.phonemanege.controller;

import cn.hutool.core.bean.BeanUtil;
import com.qdu.phonemanege.dao.PhonesDao;
import com.qdu.phonemanege.model.Phones;
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
@RequestMapping("/phones")
public class PhonesController {
    
    @Autowired
    private PhonesDao phonesDao;

    /*新增手机*/
    @RequestMapping("/insert")
    @ResponseBody
    public String login(Phones phones){
        phonesDao.insert(phones,"Phones");
        return "success";
    }
    /*更新手机*/
    @RequestMapping("/update")
    @ResponseBody
    public String update(Phones phones){
        Map<String, Object> map = BeanUtil.beanToMap(phones);
        phonesDao.update(phones.getId(),map,"Phones");
        return "success";
    }
    /*删除手机*/
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String id){
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        phonesDao.remove(map,"Phones");
        return "success";
    }

    /*分页获取所有手机*/
    @RequestMapping("/findAllPage")
    @ResponseBody
    public Page<Phones> findAllPage(Integer pageNum, Integer pageSize, Phones phones){
        Map<String,String> map = new HashMap<>();
        map.put("pCategoryId",phones.getpCategoryId()+"");
        return phonesDao.lianbiaoQuery(pageNum,pageSize,map);
    }
    /*根据id获取单个手机信息*/
    @RequestMapping("/findOneById")
    @ResponseBody
    public Phones findOneById(long id){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        return phonesDao.findOneByID(map,"Phones");
    }
    /*根据类型也就是名字获取同一类型手机信息  --购物手机使用*/
    @RequestMapping("/findOneByName")
    @ResponseBody
    public List<Phones> findOneByName(String name){
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        return phonesDao.paginationQuery(0,100,map).getContent();
    }
}
