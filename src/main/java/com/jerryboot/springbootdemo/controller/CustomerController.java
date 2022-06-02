package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Customer;
import com.jerryboot.springbootdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //拿到所有會員資料
    @GetMapping("/customerManage")
    public ModelAndView customerList(ModelAndView mav, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                                     @RequestParam(name = "customerKeyword",required=false) String keyword){
        Page<Customer> customerByPage = customerService.customerList(pageNumber, keyword);
        List<Customer> list = customerByPage.getContent();
        mav.getModel().put("customerList",list);
        mav.getModel().put("page",customerByPage);
        mav.getModel().put("customerKeyword",keyword);
        mav.setViewName("customerManage");
        return mav;

    }

    //跳到更新會員頁面 改成跳到查看會員資料
    @GetMapping("/editCustomer")
    public String editCustomer(@RequestParam("userId")Integer id,Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customerBean" ,customer);

        return "updateCustomer";
    }

    //更新會員資料 改成查看會員資料
    @GetMapping("postEditCustomer")
    public String editCustomer(@ModelAttribute("customerBean") Customer customer){


//            customerService.updateCustomer(customer);
            return "redirect:customerManage";


    }

    //刪除會員
    @GetMapping("deleteCustomer")
    public String deleteCustomer(@RequestParam("userId") Integer id){
        customerService.deleteCustomer(id);

        return "redirect:customerManage";
    }
}
