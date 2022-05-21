package com.jerryboot.springbootdemo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public  interface BookingDao extends JpaRepository<Booking,Integer> {

    @Query("from Booking where bookingId=:id")
    Booking findBookingByBookingId(@Param("id") Integer id);


    void deleteByBookingId(Integer id);
}
