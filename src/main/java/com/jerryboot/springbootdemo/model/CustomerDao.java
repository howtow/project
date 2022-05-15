package com.jerryboot.springbootdemo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {

    @Query("from Customer where userId= :userId")
    public Customer findCustomerByUserId(@Param("userId") Integer userId);


    public void deleteByUserId(Integer userId);

}
