package com.tt.stack.controller;

import com.tt.stack.entity.Admin;
import com.tt.stack.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class Admin_LoginController {

    @Autowired
    AdminService adminService;

    @GetMapping({"","/","/login"})
    public String toAdmin(){
        return "admin_login";
    }

    @ResponseBody
    @PostMapping("/login")
    public String loginCheck(Admin admin, HttpSession session){
        /*
        *       -2：用户名空       -1：用户名不存在
        *       0：密码错误         1：通过
        * */

        if (admin.getAccount().trim().equals(null) || admin.getAccount().equals(null))
            return "-2";
        admin.setAccount(admin.getAccount().trim());
        String result =  adminService.loginCheck(admin);
        if (result.equals("1"))
            session.setAttribute("adminAccount",admin.getAccount());
        return result;
    }

    @RequestMapping("/out")
    public String loginOut(HttpSession session){
        session.removeAttribute("adminAccount");
        return "redirect:/admin/login";
    }

}
