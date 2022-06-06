package com.jerryboot.springbootdemo.service;

import com.jerryboot.springbootdemo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private RoomDao roomDao;

    public Page<Hotel> findHotelByPage(Integer pageNumber) {
        Pageable request = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "hotelId");
        Page<Hotel> hotels = hotelDao.findAll(request);
        return hotels;
    }
    //    刪除旅館
    public void deleteHotelById(Integer id) {
        hotelDao.deleteByHotelId(id);
    }

    //    找到旅館資料
    public Hotel getHotelById(Integer id) {
        Hotel hotel = hotelDao.findHotelByHotelId(id);
        return hotel;
    }

    //    更新旅館
    public void updateHotel(Hotel hotel) {
         hotelDao.save(hotel);
    }

    //新增旅館
    public void addHotel(Hotel hotel){
        hotelDao.save(hotel);
    }


    //拿到房間列表
    public Page<Hotel> hotelList(Integer pageNumber,String keyword){
        Pageable pageable = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "hotelId");
        if(keyword != null){
            return hotelDao.hotelList(keyword,pageable);

        }
        return hotelDao.findAll(pageable);
    }

    //廠商登入
    public Hotel login(String account,String password){
        Hotel tempMember = hotelDao.findByHotelAccountAndHotelPassword(account, password);
        if(tempMember!=null){
            return tempMember;
        }else {
            return null;
        }
    }
    public Integer hotelSum(){
        return hotelDao.hotelSum();
    }

    }

