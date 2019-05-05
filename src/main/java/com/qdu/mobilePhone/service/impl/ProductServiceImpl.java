package com.qdu.mobilePhone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.mobilePhone.dao.ProductDao;
import com.qdu.mobilePhone.pojo.Imgs;
import com.qdu.mobilePhone.pojo.Product;
import com.qdu.mobilePhone.service.ProductService;
import com.qdu.mobilePhone.util.MapObjUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("Pro")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao pd;

    public ProductDao getPd() {
        return pd;
    }

    public void setPd(ProductDao pd) {
        this.pd = pd;
    }

    private static String HUAWEI_BRAND = "1";
    private static String OPPO_BRAND = "2";
    private static String VIVO_BRAND = "3";
    private static String IPONE_BRAND = "4";
    private static String MI_BRAND = "5";
    private static String SMARTISAN_BRAND = "6";
    private static String NUBIA_BRAND = "7";
    private static String MEIZU_BRAND = "8";
    private static String PNEPLUS_BRAND = "9";
    private static String ONEPLUS_BRAND="10";
    @Override
    public List<Object> getTwoProducts() {
        //第一步！整合第一个手机  json数据
        List<Product> products = pd.getTwoProducts(OPPO_BRAND);
        List<Object> jsonData1 = new ArrayList<>();
        jsonData1.add("left");
        jsonData1.add(products);
        //第二个手机
        List<Product> products2 = pd.getTwoProducts(HUAWEI_BRAND);
        List<Object> jsonData2 = new ArrayList<>();
        jsonData2.add("right");
        jsonData2.add(products2);
        /*终极json*/
        List<Object> endJsonData = new ArrayList<>();
        endJsonData.add(jsonData1);
        endJsonData.add(jsonData2);
        /*for(Product product:products){
            Map<String, Object> map = MapObjUtil.object2Map(product);
            jsonData.add(map)
        }*/
        return endJsonData;
    }

    @Override
    public List<Object> get8Products() {
        List<Object> endJson = new ArrayList<>();
        //第一步！整合第一个手机  json数据
        List<Product> products = pd.getTwoProducts(VIVO_BRAND);
        endJson.add(getProductJson(products));
        /*2*/
        List<Product> products2 = pd.getTwoProducts(IPONE_BRAND);
        endJson.add(getProductJson(products2));
        /*3*/
        List<Product> products3 = pd.getTwoProducts(MI_BRAND);
        endJson.add(getProductJson(products3));
        /*4*/
        List<Product> products4 = pd.getTwoProducts(SMARTISAN_BRAND);
        endJson.add(getProductJson(products4));
        /*5*/
        List<Product> products5 = pd.getTwoProducts(NUBIA_BRAND);
        endJson.add(getProductJson(products5));
        /*6*/
        List<Product> products6 = pd.getTwoProducts(MEIZU_BRAND);
        endJson.add(getProductJson(products6));
        /*7*/
        List<Product> products7 = pd.getTwoProducts(PNEPLUS_BRAND);
        endJson.add(getProductJson(products7));
        /*8*/
        List<Product> products8 = pd.getTwoProducts(ONEPLUS_BRAND);
        endJson.add(getProductJson(products8));
        return endJson;
    }

    @Override
    public Object getProductsByColorAndConfig(Integer colorId, Integer versionId, String pro_sort) {
        List<Object> endJson = new ArrayList<>();
        List<Product> products = pd.getProductsByColorAndConfig(colorId,versionId,pro_sort);
        endJson.add(getProductJson(products).get(0));
        return endJson;
    }

    /*整理下面八个手机JSON数据的方法
    * endJson数据：手机信息+colors+configs
    * */
    private List<Object> getProductJson(List<Product> products){
        List<Object> endJson = new ArrayList<>();
        /*逻辑：1.查出每个产品的图片地址，填到endsjon
         * 2.查出所有版本 填到json
         * 3.查出所有颜色，填到json
          * */
        for(Product product : products){
            Integer id = product.getPro_id();
            List<Imgs> imgs = pd.getIMGS(id);
            Map<String,Object> map = new HashMap<>();
            map.put("proData",product);
            List<Imgs> maxImgs = new ArrayList<>();
            List<Imgs> minImgs = new ArrayList<>();
            for(Imgs imgs1 : imgs){
                if(imgs1.getImg_type().equals("0")){
                    minImgs.add(imgs1);
                    continue;
                }
                maxImgs.add(imgs1);
            }
            map.put("minImgs",minImgs);
            map.put("MaxImgs",maxImgs);
            map.put("colors",pd.getColors(product.getPro_sort()));
            map.put("configs",pd.getVersions(product.getPro_sort()));
            endJson.add(map);
        }
        return endJson;
    }
    public List<Product> selPro(Product p) {
        List<Product> list=pd.selPro(p);
        return list;
    }

    public boolean insertPro(Product p) {
        if(p.getPro_name()!=null && p.getPro_sort()!=null && p.getPro_price() != null && p.getPro_img() != null
                && p.getPro_desc() != null&&p.getPro_num() != null && p.getPro_weight() != null && p.getPro_color() != null && p.getPro_version() !=null){
            if(pd.insertPro(p)>0){
                System.out.println("新增成功");
                return true;
            }else {
                System.out.println("新增失败");
                return false;
            }
        }else {
            System.out.println("请将数据填充完整");
            return false;
        }
    }


    public boolean delPro(Integer Pro_id) {
        if (Pro_id !=null && Pro_id > 0){
            if (pd.delPro(Pro_id)>0){
                System.out.println("删除成功");
                return true;
            }else {
                System.out.println("删除失败");
                return false;
            }
        }else{
            System.out.println("请输入正确的数字");
            return false;
        }

    }

    public boolean updatePro(Product p) {
        if(p!=null){
            if(p.getPro_color()!=null||p.getPro_version()!=null){
                if((p.getPro_color()<0&&p.getPro_color()>4)||(p.getPro_version()<0&&p.getPro_version()>4)){
                    return false;
                }
            }
            if(pd.updatePro(p)>0){
                System.out.println("修改成功");
                return true;
            }else{
                System.out.println("修改失败");
                return false;
            }
        }else{
            return false;
        }
    }

    public List<String> showBrand() {
        List<String> list = pd.selBrand();
        if(list != null){
            return list;
        }
        return null;
    }

    @Override
    public PageInfo<Product> getPhonesByPageAndBrand(Integer pageNo, Integer pageSize, Integer brandId) {
        PageHelper.startPage(pageNo,pageSize);
        List<Product> list =  pd.getPhonesByPageAndBrand(brandId);
        PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }

    @Override
    public List<Product> getPhonesBySort(String sort) {
        return pd.getPhonesBySort(sort);
    }
}