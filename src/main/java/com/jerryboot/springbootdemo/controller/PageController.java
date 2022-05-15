package com.jerryboot.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

	@GetMapping("/side")
	public String side(){
		return "sidebar";
	}

	@GetMapping("/adminLoginForm")
	public String backLogin(){
		return "adminLoginForm";
	}

	@GetMapping("/adminPage")
	public String adminPage(){
		return "adminPage";
	}


//	@GetMapping("/hotelManage")
//	public String hotelManage(){
//		return "hotelManage";
//	}
}
