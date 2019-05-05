package com.qdu.mobilePhone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.mobilePhone.dao.ProductDao;
import com.qdu.mobilePhone.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl {

    @Autowired
    private ProductDao productDao;

    public PageInfo<Product> selPagePro(int pageNo, int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Product> list =  productDao.selAll(null);
        PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }

}
