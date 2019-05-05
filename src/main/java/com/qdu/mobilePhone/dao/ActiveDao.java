package com.qdu.mobilePhone.dao;

import com.qdu.mobilePhone.pojo.Active;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 销售活动dao层接口
 */
@Mapper
public interface ActiveDao {

    /**
     * 查询活动
     * @param active
     * @return
     */
    List<Active> selActive(Active active);

    /**
     * 添加活动
     * @param active
     * @return
     */
    int addActive(Active active);

    /**
     * 根据id删除销售活动信息
     * @param id
     * @return
     */
    int delActive(Integer id);

    /**
     * 修改销售活动信息
     * @param active
     * @return
     */
    int updActive(Active active);

}