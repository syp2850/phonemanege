package com.qdu.mobilePhone.controller;

import com.qdu.mobilePhone.pojo.Admin;
import com.qdu.mobilePhone.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/add")
    public ModelAndView addAdmin(Admin admin){
        int count = adminService.addAdmin(admin);
        ModelAndView mav = new ModelAndView();
        mav.addObject("result",count);
        mav.setViewName("admin");
        return mav;
    }

    @RequestMapping("/del")
    public ModelAndView delAdmin(Integer id){
        int count = adminService.delAdmin(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("result",count);
        mav.setViewName("admin");
        return mav;
    }

    @RequestMapping("/upd")
    public ModelAndView updAdmin(Admin admin){
        int count = adminService.updAdmin(admin);
        ModelAndView mav = new ModelAndView();
        mav.addObject("result",count);
        mav.setViewName("admin");
        return mav;
    }

    @RequestMapping("/sel")
    public ModelAndView selAdmin(Admin admin){
        List<Admin> list = adminService.showAdmin(admin);
        ModelAndView mav = new ModelAndView();
        mav.addObject("redult",list);
        mav.setViewName("admin");
        return mav;
    }

    @RequestMapping("/login")
    public String AdminLogin(HttpServletRequest request){
        return adminService.AdminLogin(request);
    }

}
