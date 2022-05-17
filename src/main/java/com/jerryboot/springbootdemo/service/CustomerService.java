package com.jerryboot.springbootdemo.service;

import com.jerryboot.springbootdemo.model.Customer;
import com.jerryboot.springbootdemo.model.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Page<Customer> findCustomerByPage(Integer pageNumber) {
        PageRequest page = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "userId");
        Page<Customer> customers = customerDao.findAll(page);
        return customers;
    }


    //    更新會員
    public void updateCustomer(Customer customer) {

        customerDao.save(customer);
    }

    public Customer getCustomerById(Integer id) {
        Customer customer = customerDao.findCustomerByUserId(id);
        return customer;
    }

    public void deleteCustomer(Integer id) {
        customerDao.deleteByUserId(id);
    }

}




