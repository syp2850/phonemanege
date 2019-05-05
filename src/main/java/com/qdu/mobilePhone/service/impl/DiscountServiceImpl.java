package com.qdu.mobilePhone.service.impl;

import com.qdu.mobilePhone.dao.DiscountDao;
import com.qdu.mobilePhone.pojo.Discount;
import com.qdu.mobilePhone.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountDao discountDao;

    public List<Discount> showDiscount(Discount discount) {
        return discountDao.selDiscount(discount);
    }

    public int addDiscount(Discount discount) {
        int count = 0;
        if(discount != null){
            count = discountDao.addDiscount(discount);
            if(count > 0){
                return count;
            }
        }
        return count;
    }

    public int updDiscount(Discount discount) {
        return 0;
    }

    public int delDiscount(Integer id) {
        int total = discountDao.selDiscount(null).size();
        if(id > 0 && id <= total){
            return discountDao.delDiscount(id);
        }
        return 0;
    }
}
