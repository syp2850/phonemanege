package com.qdu.mobilePhone.service;

import com.github.pagehelper.PageInfo;
import com.qdu.mobilePhone.pojo.Product;

import java.util.List;

public interface ProductService {
    /**
     * 关键接口  获取上面两个手机
     * */
    List<Object> getTwoProducts();
    /**
     * 获取下面八个手机
     * */
    List<Object> get8Products();

    /**根据颜色配置查找手机*/
    Object getProductsByColorAndConfig(Integer colorId, Integer versionId, String pro_sort);

    /**
     * 查相应的产品
     * @return
     */
    List<Product> selPro(Product p);

    /**
     * 新增产品
     * @return
     */
    boolean insertPro(Product p);

    /**
     * 删除产品
     * @return
     */
    boolean delPro(Integer Pro_id);

    /**
     * 修改产品信息
     * @return
     */
    boolean updatePro(Product p);

    /**
     * 展示手机品牌类型
     * @return
     */
    List<String> showBrand();
    /**
     * 分页获取手机
     * */
    PageInfo<Product> getPhonesByPageAndBrand(Integer integer, Integer integer1, Integer brandId);
    /*根据类型查手机*/
    List<Product> getPhonesBySort(String sort);

}
