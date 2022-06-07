package com.jerryboot.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String goIndex() {
		return "index";
	}
	
	@GetMapping("about")
	public String goAbout() {
		return "about";
	}

	@GetMapping("/adminLoginForm")
	public String backLogin(){
		return "adminLoginForm";
	}


	@GetMapping("/adminPage")
	public String adminPage(){
		return "adminPage";
	}

	@GetMapping("/updateHotel")
	public ModelAndView hotel(ModelAndView modelAndView){

		modelAndView.setViewName("updateHotel");
		return modelAndView;
	}

	@GetMapping("/newsPage")
	public String newsPage(){
		return "newsPage";
	}


//	@GetMapping("/hotelManage")
//	public String hotelManage(){
//		return "hotelManage";
//	}
}
