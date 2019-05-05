package com.qdu.mobilePhone.dao;

import com.qdu.mobilePhone.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员操作接口
 */
@Mapper
public interface AdminDao {

    /**
     * 查找管理员
     * @param admin
     * @return
     */
    List<Admin> selAdmin(Admin admin);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    int addAdmin(Admin admin);

    /**
     * 删除管理员
     * @param id
     * @return
     */
    int delAdmin(Integer id);

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    int updAdmin(Admin admin);

}
