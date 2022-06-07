package com.jerryboot.springbootdemo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomImgDao extends JpaRepository<RoomImg,Integer> {

    @Query(value = "select Img from RoomImg  where RoomImg.RoomID=?1",nativeQuery = true)
    List<RoomImg> findImgByRoomID(Integer id);


}
