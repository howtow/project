package com.jerryboot.springbootdemo.service;

import com.jerryboot.springbootdemo.model.Admin;
import com.jerryboot.springbootdemo.model.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public Admin login(String adminEmail,String password){
        Admin tempMember = adminDao.findByAdminEmailAndPassword(adminEmail,password);

        if(tempMember!=null){
            return tempMember;
        }else {
            return null;
        }
    }
}
