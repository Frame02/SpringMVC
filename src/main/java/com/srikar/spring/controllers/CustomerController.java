package com.srikar.spring.controllers;

import com.srikar.spring.domain.Customer;
import com.srikar.spring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @RequestMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.customers());
        return "customers";
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public String getCustomerDetails(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer";
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.POST)
    public String createOrUpdateCustomer(@PathVariable Integer id, Customer customer) {
        customerService.saveOrUpdate(customer);
        return "redirect:/customers";
    }


    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
        return "redirect:/customers";
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
