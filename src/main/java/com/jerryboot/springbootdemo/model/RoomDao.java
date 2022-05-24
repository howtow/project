package com.jerryboot.springbootdemo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDao extends JpaRepository<Room,Integer> {

    Room findRoomByRoomId(Integer id);

     void deleteRoomByRoomId(Integer id);

    @Query("select r from Room r where "
    +"concat(r.roomName, r.price, r.tag, r.description)"+
    "like %?1%")
     Page<Room> roomList(String keyword, Pageable pageable);

//    廠商搜尋自己所屬房間
    @Query("select r from Room r where r.hotel.hotelId= :id")
    Page<Room> findRoomByHotel_HotelId(@Param("id") Integer id,Pageable pageable);
}
