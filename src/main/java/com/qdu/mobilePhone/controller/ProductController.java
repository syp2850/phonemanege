package com.qdu.mobilePhone.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.qdu.mobilePhone.pojo.Product;
import com.qdu.mobilePhone.service.impl.PageServiceImpl;
import com.qdu.mobilePhone.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "product",produces = "application/json; charset=utf-8")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private PageServiceImpl pageService;

    /*关键接口一：最火的两款手机json数据发送*/
    @RequestMapping(value = "/getTwoProducts")
    @ResponseBody
    public String getTwoProducts(){
        return JSON.toJSONString(productService.getTwoProducts());
    }

    /*关键接口二：最火的其他八款手机json数据发送*/
    @RequestMapping(value = "/getEightProducts")
    @ResponseBody
    public String getEightProducts(){
        return JSON.toJSONString(productService.get8Products());
    }
    /*关键接口三：根据颜色和配置查询手机详细信息+colors+configs+imgs*/
    @RequestMapping(value = "/getProductsByColorAndConfig")
    @ResponseBody
    public String getEightProducts(Integer colorId,Integer versionId,String pro_sort){
        return JSON.toJSONString(productService.getProductsByColorAndConfig(colorId,versionId,pro_sort));
    }

    /*添加手机*/
    @RequestMapping(value = "/addPro")
    @ResponseBody
    public boolean addPro(Product product){
        return productService.insertPro(product);
    }

    /*根据品牌获取手机列表 分页*/
    @RequestMapping(value = "/getPhonesByPageAndBrand")
    @ResponseBody
    public String getPhonesByPageAndBrand(Integer pageNo,Integer pageSize,Integer brandId){
        if(brandId==null){
            PageInfo<Product> list = pageService.selPagePro(pageNo == null ? pageNo = 0 : pageNo,pageSize == null ? pageSize = 10 : pageSize);
            return JSON.toJSONString(list);
        }
        PageInfo<Product> list = productService.getPhonesByPageAndBrand(pageNo==null?pageNo=0:pageNo,pageSize==null?pageSize=10:pageSize,brandId);
        return JSON.toJSONString(list);
    }
    /*根据类型获取手机列表*/
    @RequestMapping(value = "/getPhonesBySort")
    @ResponseBody
    public String getPhonesBySort(String sort){
        List<Product> list = productService.getPhonesBySort(sort);
        return JSON.toJSONString(list);
    }


   /* @RequestMapping(value = "/selPro")
    @ResponseBody
//    @ApiOperation(value="根据具体情况获取产品信息",httpMethod="GET")
    public String selPro(Integer pageNo,Integer pageSize){
        PageInfo<Product> productPageInfo = pageService.selPagePro(pageNo == null ? pageNo = 0 : pageNo,pageSize == null ? pageSize = 10 : pageSize);
        return JSON.toJSONString(productPageInfo);
    }*/



    @RequestMapping(value = "/delPro")
    @ResponseBody
//    @ApiOperation(value="删除手机商品信息",httpMethod="GET")
    public boolean delPro(@RequestParam("Pro_id") Integer Pro_id){
        return productService.delPro(Pro_id);
    }

    @RequestMapping(value = "/updPro")
    @ResponseBody
//    @ApiOperation(value="修改手机商品信息",httpMethod="GET")
    public boolean updPro(Product p){
        return productService.updatePro(p);
    }

    @RequestMapping(value = "/selBrand")
    @ResponseBody
//    @ApiOperation(value="展示手机品牌信息",httpMethod="GET")
    public String showBrand(){
        List<String> list = productService.showBrand();
        return JSON.toJSONString(list);
    }


}

