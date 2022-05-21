package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Customer;
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
                                 @RequestParam(name = "roomKeyword",defaultValue = "") String keyword){
        Page<Room> page = roomService.roomList(pageNumber, keyword);

        List<Room> roomList = page.getContent();
        mav.getModel().put("page",page);
        mav.getModel().put("roomList", roomList);
        mav.getModel().put("roomKeyword",keyword);
        mav.setViewName("roomManage");
//        model.addAttribute("page", page);
//        model.addAttribute("roomList", roomList);
//        model.addAttribute("sortDir", sortDir);
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("keyword",keyword);
//        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
//        model.addAttribute("reverseSortDir",reverseSortDir);

        return mav ;
    }

    //跳到更新房間頁面
    @GetMapping("/editRoom")
    public String editRoom(Model model,@RequestParam("roomId") Integer id){
        Room room = roomService.getRoomById(id);
        model.addAttribute("roomBean",room);
        return "updateRoom";
    }

    //更新房間資料
    @PostMapping("postEditRoom")
    public String editCustomer(@ModelAttribute("roomBean") Room room){

        roomService.updateRoom(room);
        return "redirect:roomManage";

    }

    //刪除房間
    @GetMapping("deleteRoom")
    public String deleteCustomer(@RequestParam("roomId") Integer id){
        roomService.deleteRoom(id);

        return "redirect:roomManage";
    }


}
