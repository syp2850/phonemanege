package com.qdu.mobilePhone.service;

import com.qdu.mobilePhone.pojo.Discount;

import java.util.List;

public interface DiscountService {

    /**
     * 展示优惠券信息
     * @param discount
     * @return
     */
    List<Discount> showDiscount(Discount discount);

    /**
     * 新增优惠券
     * @param discount
     * @return
     */
    int addDiscount(Discount discount);

    /**
     * 修改优惠券信息
     *
     * @param discount
     * @return
     */
    int updDiscount(Discount discount);

    /**
     * 删除优惠券
     * @param id
     * @return
     */
    int delDiscount(Integer id);
}
