package com.jerryboot.springbootdemo.service;

import com.jerryboot.springbootdemo.model.Hotel;
import com.jerryboot.springbootdemo.model.HotelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelDao dao;

    public Page<Hotel> findByPage(Integer pageNumber) {
        Pageable request = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "hotelId");
        Page<Hotel> page = dao.findAll(request);
        return page;
    }
}
