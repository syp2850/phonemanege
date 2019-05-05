package com.qdu.mobilePhone.controller;

import com.qdu.mobilePhone.dao.ProductDao;
import com.qdu.mobilePhone.pojo.Product;
import com.qdu.mobilePhone.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
public class UploadController {

    @Autowired
    private UploadUtil uploadUtil;

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/upload")
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) {

        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String path = "ftp://47.95.116.4/springUpload" + file.getOriginalFilename();
                    //上传
                    //写入数据库
                    Product product = new Product();
                    product.setPro_img(path);
                    product.setPro_id(1);
                    productDao.updatePro(product);

                    try {
                        file.transferTo(new File(path));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    }
