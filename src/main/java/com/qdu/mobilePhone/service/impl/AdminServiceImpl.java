package com.qdu.mobilePhone.service.impl;

import com.qdu.mobilePhone.dao.AdminDao;
import com.qdu.mobilePhone.pojo.Admin;
import com.qdu.mobilePhone.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public List<Admin> showAdmin(Admin admin) {
        return adminDao.selAdmin(admin);
    }

    public int addAdmin(Admin admin) {
        if(admin != null){
            String user = admin.getUser();
            String password = admin.getPassword();
            Integer status = admin.getStatus();
            if(user == null || password == null || user.length()<8 || password.length()<8){
                return 0; //添加失败
            }
            int count = adminDao.addAdmin(admin);
            if(count >0){
                return 1; //添加成功
            }
            return 0; //添加失败
        }
        return 0;
    }

    public int updAdmin(Admin admin) {
        if(admin != null){
            String user = admin.getUser();
            String password = admin.getPassword();
            Integer status = admin.getStatus();
            if(user == null || password == null || user.length()<8 || password.length()<8){
                return 0; //修改失败
            }
            int count = adminDao.updAdmin(admin);
            if(count >0){
                return 1; //修改成功
            }
            return 0; //修改失败
        }
        return 0;
    }

    public int delAdmin(Integer id) {
        if(id > 0 && id <= showAdmin(null).size()){
            int count = adminDao.delAdmin(id);
            if(count > 0){
                return 1;
            }
            return 0;
        }
        return 0;
    }

    public String AdminLogin(HttpServletRequest request) {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        Admin admin1 = null;
        if(user != null && password != null && user.length() >= 8 && password.length() >= 8){
            Admin admin = new Admin();
            admin.setUser(user);
            admin.setPassword(password);
            List<Admin> list = adminDao.selAdmin(admin);
            if(list != null && list.size() > 0){
                admin1 = adminDao.selAdmin(admin).get(0);
                if(admin1 != null){
                    HttpSession session = request.getSession();
                    session.setAttribute("admin",admin1);
                    return "Manage"; //管理员登陆成功
                }
            }
            return "../Login";
        }
        return "../Login";
    }
}
