package com.jerryboot.springbootdemo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {

    @Query("from Admin where adminEmail=:email and password=:password")
    Admin findByAdminEmailAndPassword(@Param("email") String adminEmail,@Param("password") String password);
}
