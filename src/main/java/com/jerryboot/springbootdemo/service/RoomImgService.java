package com.jerryboot.springbootdemo.service;

import com.jerryboot.springbootdemo.model.Room;
import com.jerryboot.springbootdemo.model.RoomImg;
import com.jerryboot.springbootdemo.model.RoomImgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomImgService {

    @Autowired
    private RoomImgDao roomImgDao;

    public void saveRoomImg(RoomImg roomImg){

        roomImgDao.save(roomImg);
    }

    public List<RoomImg> getRoomImgByRoomID(Integer id){
        return roomImgDao.getALLImg(id);
    }

    public RoomImg getImgById(Integer id){

        Optional<RoomImg> option = roomImgDao.findById(id);
        return option.orElse(null);
    }
}
