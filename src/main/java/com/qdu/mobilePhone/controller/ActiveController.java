package com.qdu.mobilePhone.controller;

import com.alibaba.fastjson.JSON;
import com.qdu.mobilePhone.pojo.Active;
import com.qdu.mobilePhone.service.impl.ActiveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/active")
@Controller
public class ActiveController {

    @Autowired
    private ActiveServiceImpl activeService;

    @RequestMapping("/sel")
    public String showInfo(){
        List<Active> list = activeService.selAllActive(null);
        for (Active a: list) {
            System.out.println(a.getAct_desc());
        }
        return JSON.toJSONString(list);
    }

    @RequestMapping("/del")
    public String delInfo(HttpServletRequest request){
        //获取url id
        Integer id = Integer.parseInt(request.getParameter("id"));
        int count = activeService.delActive(id);
        return JSON.toJSONString(count);
    }

    @RequestMapping("/add")
    public String addInfo(Active active){
        int count = activeService.addActive(active);
        return JSON.toJSONString(count);
    }

    @RequestMapping("/update")
    public String updInfo(Active active){
        int count = activeService.updActive(active);
        return JSON.toJSONString(count);
    }

}
