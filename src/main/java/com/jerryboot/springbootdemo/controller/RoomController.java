package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Room;
import com.jerryboot.springbootdemo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoomController {

//    @Param("sortField") String sortField,
//    @Param("sortDir") String sortDir,

    @Autowired
    private RoomService roomService;

    @GetMapping("/roomManage")
    public ModelAndView roomList(ModelAndView mav, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                                 @Param("keyword") String keyword){
        Page<Room> page = roomService.roomList(pageNumber, keyword);

        List<Room> roomList = page.getContent();
        mav.getModel().put("page",page);
        mav.getModel().put("roomList", roomList);
//        model.addAttribute("page", page);
//        model.addAttribute("roomList", roomList);
//        model.addAttribute("sortDir", sortDir);
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("keyword",keyword);
//        mav.getModel().put("keyword",keyword);
//        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
//        model.addAttribute("reverseSortDir",reverseSortDir);
        return mav ;
    }

    @GetMapping("/roomManage2")
    public ModelAndView roomList2(ModelAndView mav,@RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                                  @ModelAttribute("qqq") String key){

        return mav;
    }

    @GetMapping("roomManage1")
    @ResponseBody
    public List<Room> roomList1(Model model, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                           @RequestParam("keyword") String keyword){
        Page<Room> page = roomService.roomList(pageNumber, keyword);

        List<Room> roomList = page.getContent();
        model.addAttribute("page", page);
        model.addAttribute("roomList", roomList);
        model.addAttribute("keyword",keyword);

        return roomList ;
    }
}
