package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Booking;
import com.jerryboot.springbootdemo.model.BookingDto;
import com.jerryboot.springbootdemo.model.Hotel;
import com.jerryboot.springbootdemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    //會員數
    @GetMapping("api/customerSum")
    public ResponseEntity<Map<String,Integer>> getCustomerSum() {

        Map<String,Integer> result = new HashMap<String,Integer>();
        result.put("customer", customerService.customerSum());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //旅館數
    @GetMapping("api/hotelSum")
    public ResponseEntity<Map<String, Integer>> getHotelSun(){
        Map<String, Integer> result = new HashMap<String,Integer>();
        result.put("hotel", hotelService.hotelSum());
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    //訂單總額
    @GetMapping("api/bookingSum")
    public ResponseEntity<Map<String, Integer>> getBookingSum(){
        Map<String, Integer> result=new HashMap<String,Integer>();
        result.put("booking", bookingService.bookingSum());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //房間數
    @GetMapping("api/roomSum")
    public ResponseEntity<Map<String, Integer>> getRoomSum(){
        Map<String, Integer> result=new HashMap<String,Integer>();
        result.put("room", roomService.roomSum());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //評論數
    @GetMapping("api/commentSum")
    public ResponseEntity<Map<String, Integer>> getCommentSum(){
        Map<String, Integer> result=new HashMap<String,Integer>();
        result.put("comment", commentService.commentSum());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/api/booking")
    @ResponseBody
    public List<Booking> BookingManage(@RequestParam(name = "p",defaultValue = "1")Integer pageNumber){
        Page<Booking> page = bookingService.findByPage1(pageNumber);
        List<Booking> content = page.getContent();

        return content;
    }

    @GetMapping("changeStatus/{p}")
    public ModelAndView postFirm(@RequestParam("bookingId") Integer id){
        Booking byId = bookingService.getBookingById(id);
        byId.setState("已確認");

        bookingService.updateBooking(byId);
        return new ModelAndView("redirect:firmBookingManage");
    }

}
