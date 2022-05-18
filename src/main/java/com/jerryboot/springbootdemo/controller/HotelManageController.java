package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Booking;
import com.jerryboot.springbootdemo.model.Customer;
import com.jerryboot.springbootdemo.model.Hotel;
import com.jerryboot.springbootdemo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HotelManageController {

    @Autowired
    private HotelService hotelService;

    //拿到所有旅館資料
    @GetMapping("/hotelManage")
    public String hotelList(Model model, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber){
        Page<Hotel> page = hotelService.findHotelByPage(pageNumber);
        List<Hotel> hotelList = page.getContent();
        model.addAttribute("hotelList",hotelList);
        model.addAttribute("page",page);
        return "hotelManage";

    }

    //新增旅館
    @PostMapping("/hotel/add")
    public String postHotel(@ModelAttribute(name = "addHotelBean") Hotel hotel){
        hotelService.addHotel(hotel);

        return "hotelManage";
    }


    //跳到更新旅館頁面
    @GetMapping("/editHotel")
    public String editHotel(@RequestParam("hotelId")Integer id,Model model){
        Hotel hotel = hotelService.getHotelById(id);
        model.addAttribute("hotelBean" ,hotel);

        return "updateHotel";
    }

    //更新旅館資料
    @PostMapping("postEditHotel")
    public String editHotel(@ModelAttribute("hotelBean") Hotel hotel){

        hotelService.updateHotel(hotel);
        return "redirect:hotelManage";

    }

    //刪除旅館
    @GetMapping("deleteHotel")
    public String deleteHotel(@RequestParam("hotelId") Integer id){
        hotelService.deleteHotelById(id);

        return "redirect:hotelManage";
    }

    @GetMapping("keyword1")
    public String listByKeyword(Model model, @RequestParam(name = "p",defaultValue = "1")Integer pageNumber,
                                @RequestParam(name = "keyword") String keyword){

        Page<Hotel> hotelByKeyowrd = hotelService.findHotelByKeyowrd(pageNumber, keyword);
        List<Hotel> list = hotelByKeyowrd.getContent();
        model.addAttribute("hotelList",hotelByKeyowrd);
        model.addAttribute("page",list);
        model.addAttribute("keyword",keyword);
        return "hotelManage";
    }






    // 根據頁數找到hotel ajax
//    @GetMapping("/hotelManage1")
//    @ResponseBody
//    public List<Hotel> hotelManage(@RequestParam(name = "p",defaultValue = "1")Integer pageNumber){
//        Page<Hotel> page = hotelService.findHotelByPage(pageNumber);
//        List<Hotel> content = page.getContent();
//
//        return content;
//    }


}

