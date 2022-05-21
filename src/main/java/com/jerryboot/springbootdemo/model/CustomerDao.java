package com.jerryboot.springbootdemo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {

    @Query("from Customer where userId= :userId")
    Customer findCustomerByUserId(@Param("userId") Integer userId);


    void deleteByUserId(Integer userId);

    @Query("select c from Customer c where " +
            "concat(c.email, c.userName, c.nationality, c.gender, c.address, c.state) " +
            "like %?1%")
    Page<Customer> customerList(String keyword, Pageable pageable);


}
