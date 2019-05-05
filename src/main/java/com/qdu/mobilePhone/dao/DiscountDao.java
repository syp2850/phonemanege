package com.qdu.mobilePhone.dao;

import com.qdu.mobilePhone.pojo.Discount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 优惠券
 */
@Mapper
public interface DiscountDao {

    /**
     * 查找优惠券
     * @param count
     * @return 集合
     */
    List<Discount> selDiscount(Discount count);

    /**
     * 添加一种优惠券
     * @param discount
     * @return 影响行数
     */
    int addDiscount(Discount discount);

    /**
     * 删除一种优惠券
     * @param id
     * @return 影响行数
     */
    int delDiscount(Integer id);

    /**
     * 修改优惠券信息 主要用于修改优惠券的状态
     *
     * @param discount
     * @return 影响行数
     */
    int updDiscount(Discount discount);
}
