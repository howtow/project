package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Room;
import com.jerryboot.springbootdemo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RoomController {

//    @Param("sortField") String sortField,
//    @Param("sortDir") String sortDir,

    @Autowired
    private RoomService roomService;

    @GetMapping("/roomManage")
    public String roomList(Model model, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                           @RequestParam("keyword") String keyword){
        Page<Room> page = roomService.roomList(pageNumber, keyword);

        List<Room> roomList = page.getContent();
        model.addAttribute("p", pageNumber);
        model.addAttribute("roomList", roomList);
//        model.addAttribute("sortDir", sortDir);
//        model.addAttribute("sortField", sortField);
        model.addAttribute("p", pageNumber);
        model.addAttribute("keyword",keyword);
//        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
//        model.addAttribute("reverseSortDir",reverseSortDir);
        return "roomManage";
    }

}
