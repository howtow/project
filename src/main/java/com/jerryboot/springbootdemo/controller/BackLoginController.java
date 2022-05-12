package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Admin;
import com.jerryboot.springbootdemo.model.AdminDao;
import com.jerryboot.springbootdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
public class BackLoginController {

    @Autowired
    private AdminService adminService;

//    登入
    @GetMapping("/adminLogin")
    public String login(@ModelAttribute Admin admin,Model model) {
        System.out.println("admin" + admin.getAdminEmail());

        return "adminLoginForm";
    }

    // RedirectAttributes: redirect 帶值跳頁(不可以用Model)
//    帳號密碼
    @PostMapping("/adminPost")
    public String postForm(@RequestParam("adminEmail") String adminEmail,
                           @RequestParam("password") String password,
                           HttpSession httpSession, RedirectAttributes redirectAttributes){
        Admin result = adminService.login(adminEmail, password);

        if(result==null){
            // RedirectAttributes.addFlashAttribute: redirect 帶值跳頁(不可以用Model)
            redirectAttributes.addFlashAttribute("loginError","帳號密碼錯誤 ");
            return "redirect:adminLogin";
        }
            httpSession.setAttribute("loginAdmin",result);
            return "adminPage";
    }

}
