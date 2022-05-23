package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Hotel;
import com.jerryboot.springbootdemo.model.Room;
import com.jerryboot.springbootdemo.model.RoomImg;
import com.jerryboot.springbootdemo.service.HotelService;
import com.jerryboot.springbootdemo.service.RoomImgService;
import com.jerryboot.springbootdemo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class RoomController {

//    @Param("sortField") String sortField,
//    @Param("sortDir") String sortDir,

    @Autowired
    private RoomService roomService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomImgService roomImgService;

    @GetMapping("/roomManage")
    public ModelAndView roomList(ModelAndView mav, @RequestParam(name = "p", defaultValue = "1") Integer pageNumber,
                                 @RequestParam(name = "roomKeyword", required = false) String keyword) {
        Page<Room> page = roomService.roomList(pageNumber, keyword);

        List<Room> roomList = page.getContent();
        mav.getModel().put("page", page);
        mav.getModel().put("roomList", roomList);
        mav.getModel().put("roomKeyword", keyword);
        mav.setViewName("roomManage");
//        model.addAttribute("page", page);
//        model.addAttribute("roomList", roomList);
//        model.addAttribute("sortDir", sortDir);
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("keyword",keyword);
//        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
//        model.addAttribute("reverseSortDir",reverseSortDir);

        return mav;
    }

    //跳到更新房間頁面
    @GetMapping("/editRoom")
    public String editRoom(Model model, @RequestParam("roomId") Integer id) {
        Room room = roomService.getRoomById(id);
        model.addAttribute("roomBean", room);
        return "updateRoom";
    }

    //更新房間資料
    @PostMapping("postEditRoom")
    public String editCustomer(@ModelAttribute("roomBean") Room room,
                               @RequestParam("pic")MultipartFile[] pic) {
        for (MultipartFile p : pic) {
            try {
            RoomImg img = new RoomImg();
                img.setImg(p.getBytes());
                img.setRoom(room);
                roomImgService.saveRoomImg(img);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        roomService.updateRoom(room);
        return "redirect:roomManage";

    }

    //刪除房間
    @GetMapping("deleteRoom")
    public String deleteCustomer(@RequestParam("roomId") Integer id) {
        roomService.deleteRoom(id);

        return "redirect:roomManage";
    }

    //跳到新增房間頁面
    @GetMapping("room/add")
    public String addRoom() {
        return "addRoom";
    }

    //新增房間
    @PostMapping("/addRoom")
    public String PostAddRoom(Model model,
                              @RequestParam("roomName") String roomName,
                              @RequestParam("price") String price,
                              @RequestParam("allTags") String tag,
                              @RequestParam("upperLimit") Integer upperLimit,
                              @RequestParam("description") String description,
                              @RequestParam("pic") MultipartFile[] pic,
                              @RequestParam("hotelId") Integer hotelId,
                              @RequestParam("imgDescription") String imgDescription)
            throws IOException {
        String[] tagArr = tag.split(",");
        tag = "";
        for (String s : tagArr) {
            if (!s.isEmpty()) {
                tag += s;
                tag += ",";
            }
        }

        Hotel hotelById = hotelService.getHotelById(hotelId);
        if (hotelById != null) {
            Room room = new Room();
            room.setRoomName(roomName);
            room.setPrice(price);
            room.setUpperLimit(upperLimit);
            room.setDescription(description);
            room.setTag(tag);
            //和飯店關聯
            room.setHotel(hotelById);
            roomService.saveRoom(room);
            System.out.println(room);
            //新增房間照片(用RoomImgService)
            for (MultipartFile p : pic) {
                RoomImg img = new RoomImg();
                img.setImg(p.getBytes());
                img.setImgDescribe(imgDescription);
                //和房間關聯
                img.setRoom(room);
                roomImgService.saveRoomImg(img);

            }
            model.addAttribute("message", "新增成功");
            return "redirect:room/add";
        } else {
            model.addAttribute("message", "找不到此飯店ID");
            return "redirect:room/add";

        }

    }

}


