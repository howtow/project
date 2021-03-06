package com.jerryboot.springbootdemo.service;

import com.jerryboot.springbootdemo.model.Room;
import com.jerryboot.springbootdemo.model.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomDao roomDao;


    public void saveRoom(Room room) {
        roomDao.save(room);
    }

    public void updateRoom(Room room) {

        roomDao.save(room);
    }

    public void deleteRoom(Integer id) {

        roomDao.deleteRoomByRoomId(id);
    }

    public Page<Room> roomList(Integer pageNumber, String keyword) {
//        Sort sort = Sort.by(sortField);
//        sort = sortDir.equals("asc")? sort.ascending():sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "roomId");
        if (keyword != null) {
            return roomDao.roomList(keyword, pageable);
        }
        return roomDao.findAll(pageable);
    }

    public Room getRoomById(Integer id) {

        return roomDao.findRoomByRoomId(id);
    }

    //房間數
    public Integer roomSum(){
        return roomDao.roomSum();
    }

//    -------------------------------------------------------
    //廠商拿到自己的資料
    public Page<Room> findRoom1(Integer id,String keyword, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "roomId");

        if (keyword != null) {
            Page<Room> room = roomDao.findRoomByHotel_HotelId(keyword, id, pageable);
            return room;
        }
        return roomDao.findRoomByHotel_HotelId2(id, pageable);
    }
    }
