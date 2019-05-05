package com.qdu.mobilePhone.service;

import com.qdu.mobilePhone.pojo.Active;

import java.util.List;

public interface ActiveService {

    /**
     * 展示销售活动信息
     * @param active
     * @return
     */
    List<Active> selAllActive(Active active);

    /**
     * 添加销售活动
     * @param active
     * @return
     */
    int addActive(Active active);

    /**
     * 通过 id 删除销售活动
     * @param id
     * @return
     */
    int delActive(Integer id);

    /**
     * 修改活动
     * @param active
     * @return
     */
    int updActive(Active active);

}
