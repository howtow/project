package com.jerryboot.springbootdemo.service;

import com.jerryboot.springbootdemo.model.RoomImg;
import com.jerryboot.springbootdemo.model.RoomImgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomImgService {

    @Autowired
    private RoomImgDao roomImgDao;

    public void saveRoomImg(RoomImg roomImg){
        roomImgDao.save(roomImg);
    }
}
