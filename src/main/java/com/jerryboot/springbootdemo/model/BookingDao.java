package com.jerryboot.springbootdemo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public  interface BookingDao extends JpaRepository<Booking,Integer> {

    @Query("from Booking where bookingId=:id")
    Booking findBookingByBookingId(@Param("id") Integer id);

    void deleteByBookingId(Integer id);

//    -------------------------------------

    //廠商找到自己的訂單
//    @Query("select b from Booking b where b.hotel.hotelId=?1")
    Page<Booking> findBookingByHotel_HotelId(Integer id, Pageable pageable);

    //廠商搜尋自己訂單
    @Query("select b from Booking b where concat(b.bookingName,b.annotation,b.email) like %?1% and b.hotel.hotelId=?2")
    Page<Booking> findBookingByHotel_HotelId2(String keyword,Integer id,Pageable pageable);

}

