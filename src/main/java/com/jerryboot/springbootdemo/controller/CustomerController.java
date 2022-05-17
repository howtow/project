package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Customer;
import com.jerryboot.springbootdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //拿到所有會員資料
    @GetMapping("/customerManage")
    public String customerList(Model model, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber){
        Page<Customer> customerByPage = customerService.findCustomerByPage(pageNumber);
        List<Customer> list = customerByPage.getContent();
        model.addAttribute("customerList",list);
        model.addAttribute("page",customerByPage);
        return "customerManage";

    }

    //跳到更新會員頁面
    @GetMapping("/editCustomer")
    public String editCustomer(@RequestParam("userId")Integer id,Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customerBean" ,customer);

        return "updateCustomer";
    }

    //更新會員資料
    @PostMapping("postEditCustomer")
    public String editCustomer(@ModelAttribute("customerBean") Customer customer){

        customerService.updateCustomer(customer);
        return "redirect:customerManage";

    }

    //刪除會員
    @GetMapping("deleteCustomer")
    public String deleteCustomer(@RequestParam("userId") Integer id){
        customerService.deleteCustomer(id);

        return "redirect:customerManage";
    }
}
