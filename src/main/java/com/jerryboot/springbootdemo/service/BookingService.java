package com.jerryboot.springbootdemo.service;

import com.jerryboot.springbootdemo.model.Booking;
import com.jerryboot.springbootdemo.model.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingService {

    @Autowired
    private BookingDao bookingDao;

    //    根據頁數找到幾筆資料
    public Page<Booking> findByPage(Integer pageNumber) {
        Pageable pageRequest = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "bookingId");
        Page<Booking> bookings = bookingDao.findAll(pageRequest);
        return bookings;
    }
    //    根據頁數找到幾筆資料 顯示最近訂單
    public Page<Booking> findByPage1(Integer pageNumber) {
        Pageable pageRequest = PageRequest.of(pageNumber - 1, 10, Sort.Direction.DESC, "bookingId");
        Page<Booking> bookings = bookingDao.findAll(pageRequest);
        return bookings;
    }
    //    刪除會員
    public void deleteBookingById(Integer id) {
        bookingDao.deleteByBookingId(id);
    }

    //    找到訂單資料
    public Booking getBookingById(Integer id) {
        Booking booking = bookingDao.findBookingByBookingId(id);
        return booking;
    }

    //    更新訂單
    public void updateBooking(Booking booking) {
        Booking booking1 = bookingDao.save(booking);
    }

    //訂單總額
    public Integer bookingSum(){
        return bookingDao.BookingSum();
    }


//    -------------------------------------------------
//    廠商自己的訂單

    public Page<Booking> findBooking(Integer id,String keyword,Integer pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "bookingId");
        if (keyword!=null){
            return bookingDao.findBookingByHotel_HotelId2(keyword,id,pageable);
        }
        return bookingDao.findBookingByHotel_HotelId(id,pageable);


    }

}

