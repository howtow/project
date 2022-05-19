package com.jerryboot.springbootdemo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends JpaRepository<Room,Integer> {

    public void deleteRoomByRoomId(Integer id);

    @Query("select r from Room r where "
    +"concat(r.roomId, r.roomName, r.price, r.tag)"+
    "like %?1%")
    public Page<Room> roomList(String keyword, Pageable pageable);
}
