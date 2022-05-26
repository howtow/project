package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Admin;
import com.jerryboot.springbootdemo.model.AdminDao;
import com.jerryboot.springbootdemo.model.Hotel;
import com.jerryboot.springbootdemo.service.AdminService;
import com.jerryboot.springbootdemo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class BackLoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private HotelService hotelService;

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
        Hotel hotel = hotelService.login(adminEmail, password);
        if(result!=null){
            httpSession.setAttribute("loginAdmin",result);
            return "adminPage";
        }else if (hotel!=null){
            httpSession.setAttribute("loginFirm",hotel);
            return "firmPage";
        }else {
            // RedirectAttributes.addFlashAttribute: redirect 帶值跳頁(不可以用Model)
        redirectAttributes.addFlashAttribute("loginError","帳號密碼錯誤 ");
        return "redirect:adminLogin";
    }
    }

//    後台登出
    @GetMapping("/adminLogout")
    public String backLogout( HttpServletRequest request
                             ){

        request.getSession().invalidate();

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("JSESSIONID")){
                c.setMaxAge(0);
                break;
            }

        }
        return "redirect:adminLoginForm";
    }

}
