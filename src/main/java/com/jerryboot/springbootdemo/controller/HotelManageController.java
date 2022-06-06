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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HotelManageController {

    @Autowired
    private HotelService hotelService;

    //拿到所有旅館資料
    @GetMapping("/hotelManage")
    public ModelAndView hotelList(ModelAndView mav, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                                  @RequestParam(name = "hotelKeyword",required = false) String keyword){
        Page<Hotel> page = hotelService.hotelList(pageNumber, keyword);
        List<Hotel> hotelList = page.getContent();
        mav.getModel().put("page", page);
        mav.getModel().put("hotelList", hotelList);
        mav.getModel().put("hotelKeyword", keyword);
        mav.setViewName("hotelManage");
        return mav;

    }

    //跳到新增旅館頁面
    @GetMapping("hotel/add")
    public String addHotel(Model model){
        model.addAttribute("addHotelBean" ,new Hotel());

        return "addHotel";
    }

    //新增旅館
    @PostMapping("/addHotel")
    public String postHotel(@ModelAttribute(name = "addHotelBean") Hotel hotel){
        hotelService.addHotel(hotel);

        return "redirect:hotelManage";
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
//-----------------------------------------------
    //廠商更新旅館資料
    @GetMapping("/firmEditHotel")
    public String firmEditHotel(HttpSession session, Model model){
        Hotel firm = (Hotel) session.getAttribute("loginFirm");
        Hotel hotel = hotelService.getHotelById(firm.getHotelId());
        model.addAttribute("hotelBean" ,hotel);

        return "firmUpdateHotel";
    }

    @PostMapping("firmPostEditHotel")
    public String firmEditHotel(@ModelAttribute("hotelBean") Hotel hotel){

        hotelService.updateHotel(hotel);
        return "firmPage";

    }






    // 根據頁數找到hotel ajax
    @GetMapping("/hotelManage1")
    @ResponseBody
    public List<Hotel> hotelManage(@RequestParam(name = "p",defaultValue = "1")Integer pageNumber){
        Page<Hotel> page = hotelService.findHotelByPage(pageNumber);
        List<Hotel> content = page.getContent();

        return content;
    }


}

