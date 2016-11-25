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

    /**
     * Gets the list of customers and sends it for display
     * @param model
     * @return
     */
    @RequestMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.customers());
        return "customers";
    }

    /**
     * Gets the details of a specific customer
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public String getCustomerDetails(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer";
    }

    /**
     * Creates a new Customer
     * @param model
     * @return
     */
    @RequestMapping("/customer/new")
    public String createCustomer(Model model){
        model.addAttribute("Title", "Create New Customer");
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    /**
     * Updates / edits an existing customer
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/customer/edit/{id}")
    public String updateCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("Title", "Edit Customer Details");
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customerForm";
    }

    /**
     * Handles the data of form post, creates / updates a customer, and displays the updated list of customers
     * @param id
     * @param customer
     * @return
     */
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.POST)
    public String createOrUpdateCustomer(Customer customer) {
        customerService.saveOrUpdate(customer);
        return "redirect:/customers";
    }


    /**
     * Deletes an existing customer and displays the updated list of customers
     * @param id
     * @return
     */
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
