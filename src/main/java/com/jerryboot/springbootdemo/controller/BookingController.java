package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Booking;
import com.jerryboot.springbootdemo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Email;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

//    拿到所有訂單資料
    @GetMapping("/bookingManage")
    public String bookingList(Model model, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber){
        Page<Booking> bookings = bookingService.findByPage(pageNumber);
        List<Booking> list = bookings.getContent();
        model.addAttribute("bookingList",list);
        model.addAttribute("page",bookings);
        return "bookingManage";
    }

//    跳到更新訂單頁面
    @GetMapping("editBooking")
    public String editBooking(@RequestParam("bookingId") Integer id,Model model){
        Booking booking = bookingService.getBookingById(id);
        model.addAttribute("bookingBean" ,booking);

        return "updateBooking";

    }

//    更新訂單資料
    @PostMapping("editPostBooking")
    public ModelAndView editBooking(ModelAndView msv, @ModelAttribute(name = "bookingBean") Booking booking){
        Booking booking1 = new Booking();

        msv.getModel().put("bookingBean",booking1);

        bookingService.updateBooking(booking1);
        msv.setViewName("redirect:bookingManage");
        return msv;
    }

//    刪除訂單
    @GetMapping("/deleteBooking")
    public String deleteBooking(@RequestParam(name = "bookingId") Integer id){
        bookingService.deleteBookingById(id);
        return "redirect:bookingManage";
    }


}
