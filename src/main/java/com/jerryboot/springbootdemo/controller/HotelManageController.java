package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Hotel;
import com.jerryboot.springbootdemo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HotelManageController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("hotelManage")
    public String ttttt(Model model,@RequestParam(name = "p",defaultValue = "1") Integer pageNumber){
        Page<Hotel> page = hotelService.findByPage(pageNumber);
        model.addAttribute("page",page);

        return "hotelManage";
    }

    @GetMapping("/hotelManage1")
    @ResponseBody
    public List<Hotel> hotelManage(@RequestParam(name = "p",defaultValue = "1")Integer pageNumber){
        Page<Hotel> page = hotelService.findByPage(pageNumber);
        List<Hotel> content = page.getContent();

        return content;
    }
}

