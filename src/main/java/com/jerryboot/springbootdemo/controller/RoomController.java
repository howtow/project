package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;


}
