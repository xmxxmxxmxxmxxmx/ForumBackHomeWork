package com.connext.onlineadmin.controller;

import com.connext.onlineadmin.model.User;
import com.connext.onlineadmin.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("/adminController")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping("/toAdminLogin")
    public String toAdminLogin(){
        return "admin_login";
    }

    @RequestMapping("/login")
    public String login(User user){
        System.out.println(user.getPhone());
        if(this.adminService.login(user)==2){
            return "main";
        }else{
            return "admin_login";
        }
    }
}
