package com.qdu.mobilePhone.dao;

import com.qdu.mobilePhone.pojo.Color;
import com.qdu.mobilePhone.pojo.Imgs;
import com.qdu.mobilePhone.pojo.Product;
import com.qdu.mobilePhone.pojo.Version;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductDao {
    /**
     * 关键接口  查询两个手机
     * */
    List<Product> getTwoProducts(String Pro_brand);

    /**
    * 根据手机型号获取所有配置
    * */
    List<Version> getVersions(String Pro_sort);
    /**
     * 根据手机型号获取所有颜色
     * */
    List<Color> getColors(String Pro_sort);

    /**根据ID获取所有图片*/
    List<Imgs> getIMGS(Integer pro_id);

    /**根据颜色配置查找手机*/
    List<Product> getProductsByColorAndConfig(Integer Pro_color, Integer Pro_version,String Pro_sort);


    /**
     * 查相应的产品
     * @return
     */
    List<Product> selPro(Product p);

    /**
     * 普通查全部
     * @param p
     * @return
     */
    List<Product> selAll(Product p);

    /**
     * 新增产品
     * @return
     */
    int insertPro(Product p);

    /**
     * 删除产品
     * @return
     */
    int delPro(Integer Pro_id);

    /**
     * 修改产品信息
     * @return
     */
    int updatePro(Product p);

    /**
     * 查询手机品牌类型
     * @return
     */
    List<String> selBrand();
    /*查询手机根据品牌*/
    List<Product> getPhonesByPageAndBrand(Integer Pro_brand);
    /*根据手机类型查手机*/
    List<Product> getPhonesBySort(String Pro_sort);
}
