package com.jerryboot.springbootdemo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDao extends JpaRepository<Hotel, Integer> {

    @Query("from Hotel where hotelId=:id")
    public Hotel findHotelByHotelId(@Param("id") Integer id);


    public void deleteByHotelId(Integer id);
}
