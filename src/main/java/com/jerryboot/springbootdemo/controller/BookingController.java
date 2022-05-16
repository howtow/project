package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Booking;
import com.jerryboot.springbootdemo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/deleteBooking")
    public String deleteBooking(@RequestParam(name = "bookingId") Integer id){
        bookingService.deleteBookingById(id);
        return "redirect:bookingManage";
    }


}
