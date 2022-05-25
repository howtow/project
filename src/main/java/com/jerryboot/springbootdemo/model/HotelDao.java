package com.jerryboot.springbootdemo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelDao extends JpaRepository<Hotel,Integer> {

    @Query("from Hotel where hotelId=:id")
    public Hotel findHotelByHotelId(@Param("id") Integer id);

    @Query("select r from Room r where r.hotel.hotelId=:id")
    public Room findRoomByHotelId(@Param("id") Integer id);


    public void deleteByHotelId(Integer id);

    @Query("select h from Hotel h where " +
            "concat(h.hotelName, h.add, h.description, h.Tel, h.serviceinfo, h.parkinginfo)"
            +"like %?1%")
    Page<Hotel> hotelList(String keyword, Pageable pageable);

    //廠商帳號密碼登入
    @Query("from Hotel where HotelAccount=?1 and HotelPassword=?2")
    Hotel findByHotelAccountAndHotelPassword(String HotelAccount,String HotelPassword);

    @Query("select r from Room r where r.hotel.hotelId= :id")
    Page<Room> findRoomByHotel_HotelId(@Param("id") Integer id,Pageable pageable);

}
