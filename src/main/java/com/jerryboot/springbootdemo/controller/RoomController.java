package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Hotel;
import com.jerryboot.springbootdemo.model.Room;
import com.jerryboot.springbootdemo.model.RoomImg;
import com.jerryboot.springbootdemo.service.HotelService;
import com.jerryboot.springbootdemo.service.RoomImgService;
import com.jerryboot.springbootdemo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //????????????????????????
    @GetMapping("/editRoom")
    public String editRoom(Model model, @RequestParam("roomId") Integer id) {
        Room room = roomService.getRoomById(id);
        List<RoomImg> list = roomImgService.getRoomImgByRoomID(id);
        System.out.println(list);
        model.addAttribute("roomBean", room);
        model.addAttribute("roomImgByRoomID", list);
        return "updateRoom";
    }

    //
    @GetMapping("downloadImage/{i}")
    @ResponseBody
    public ResponseEntity<byte[]> getImg(@PathVariable("i") Integer id){
        RoomImg img = roomImgService.getImgById(id);
        byte[] imgImg = img.getImg();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(imgImg  , headers, HttpStatus.OK);
    }


    //??????????????????
    @PostMapping("postEditRoom")
    public String editCustomer(@ModelAttribute("roomBean") Room room,
                               @RequestParam("pic")MultipartFile[] pic) {
        for (MultipartFile p : pic) {
            try {
            RoomImg img = new RoomImg();
                img.setImg(p.getBytes());
                img.setRoom(room);
                roomImgService.saveRoomImg(img);
                roomService.saveRoom(room);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        roomService.updateRoom(room);
        return "redirect:roomManage";

    }

    //????????????
    @GetMapping("deleteRoom")
    public String deleteCustomer(@RequestParam("roomId") Integer id) {
        roomService.deleteRoom(id);

        return "redirect:roomManage";
    }

    //????????????????????????
    @GetMapping("room/add")
    public String addRoom() {
        return "addRoom";
    }

    //????????????
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
        StringBuilder tagBuilder = new StringBuilder();
        for (String s : tagArr) {
            if (!s.isEmpty()) {
                tagBuilder.append(s);
                tagBuilder.append(",");
            }
        }
        tag = tagBuilder.toString();

        Hotel hotelById = hotelService.getHotelById(hotelId);
        if (hotelById != null) {
            Room room = new Room();
            room.setRoomName(roomName);
            room.setPrice(price);
            room.setUpperLimit(upperLimit);
            room.setDescription(description);
            room.setTag(tag);
            //???????????????
            room.setHotel(hotelById);
            roomService.saveRoom(room);
            System.out.println(room);
            //??????????????????(???RoomImgService)
            for (MultipartFile p : pic) {
                RoomImg img = new RoomImg();
                img.setImg(p.getBytes());
                img.setImgDescribe(imgDescription);
                //???????????????
                img.setRoom(room);
                roomImgService.saveRoomImg(img);

            }
            model.addAttribute("message", "????????????");
            return "redirect:roomManage";
        } else {
            model.addAttribute("message", "??????????????????ID");
            return "redirect:room/add";

        }


    }



//----------------------------------------------------------
//    ?????????
    @GetMapping("/firmRoomManage")
    public ModelAndView roomList1(ModelAndView mav, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                                  @RequestParam(name = "firmRoomKeyword", required = false) String keyword,
                                  HttpSession session){

        Hotel firm = (Hotel) session.getAttribute("loginFirm");
        Page<Room> page = roomService.findRoom1(firm.getHotelId(), keyword,pageNumber);
        List<Room> list = page.getContent();
        mav.getModel().put("roomList", list);
        mav.getModel().put("page",page);
        mav.getModel().put("firmRoomKeyword",keyword);
        mav.setViewName("firmRoomManage");

        return mav;

    }

    //??????????????????
    @GetMapping("/firmDeleteRoom")
    public String firmDeleteRoom(@RequestParam("roomId") Integer id){
        roomService.deleteRoom(id);
        return "redirect:firmRoomManage";
    }

    //????????????????????????
    @GetMapping("firm/add")
    public String addRoom1() {
        return "firmAddRoom";
    }

    //????????????
    @PostMapping("/firmAddRoom")
    public String PostAddRoom1(Model model,
                              @RequestParam("roomName") String roomName,
                              @RequestParam("price") String price,
                              @RequestParam("allTags1") String tag,
                              @RequestParam("upperLimit") Integer upperLimit,
                              @RequestParam("description") String description,
                              @RequestParam("pic") MultipartFile[] pic,
                              @RequestParam("imgDescription") String imgDescription,
                               HttpSession session)
            throws IOException {
        String[] tagArr = tag.split(",");
        StringBuilder tagBuilder = new StringBuilder();
        for (String s : tagArr) {
            if (!s.isEmpty()) {
                tagBuilder.append(s);
                tagBuilder.append(",");
            }
        }
        tag = tagBuilder.toString();

        Hotel firm =(Hotel) session.getAttribute("loginFirm");
        Hotel hotelById = hotelService.getHotelById(firm.getHotelId());
            Room room = new Room();
            room.setRoomName(roomName);
            room.setPrice(price);
            room.setUpperLimit(upperLimit);
            room.setDescription(description);
            room.setTag(tag);
            //???????????????
            room.setHotel(hotelById);
            roomService.saveRoom(room);
            System.out.println(room);
            //??????????????????(???RoomImgService)
            for (MultipartFile p : pic) {
                RoomImg img = new RoomImg();
                img.setImg(p.getBytes());
                img.setImgDescribe(imgDescription);
                //???????????????
                img.setRoom(room);
                roomImgService.saveRoomImg(img);

            }
            model.addAttribute("message", "????????????");
            return "redirect:firmRoomManage";

        }
    //??????????????????????????????
    @GetMapping("/firmEditRoom")
    public String firmEditRoom(Model model, @RequestParam("roomId") Integer id) {
        Room room = roomService.getRoomById(id);
        model.addAttribute("roomBean", room);
        return "firmUpdateRoom";
    }

    //????????????????????????
    @PostMapping("firmPostEditRoom")
    public String firmEditRoom(@ModelAttribute("roomBean") Room room,
                               @RequestParam("pic")MultipartFile[] pic) {
        for (MultipartFile p : pic) {
            try {
                RoomImg img = new RoomImg();
                img.setImg(p.getBytes());
                img.setRoom(room);
                roomImgService.saveRoomImg(img);
                roomService.saveRoom(room);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        roomService.updateRoom(room);
        return "redirect:firmRoomManage";

    }

    }



