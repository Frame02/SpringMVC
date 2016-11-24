package com.srikar.spring.services;

import com.srikar.spring.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> customers();
    Customer getCustomerById(Integer Id);
    Integer saveOrUpdate(Customer customer);
    void delete(Integer id);
}
