package com.srikar.spring.services;

import com.srikar.spring.domain.Customer;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private Map<Integer, Customer> customers = new HashMap<>();

    public CustomerServiceImpl() {
        loadCustomers();
    }

    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(getNextCustomerId());
        customer1.setFirstName("Srikar");
        customer1.setLastName("Vedantam");
        customer1.setEmail("v.srikar@gmail.com");
        customer1.setAddressLine1("Flat No. 204, Shravanthi Prosper Apartments");
        customer1.setAddressLine2("Sy. No. 2/3, Nyanappanahalli Main Road, Begur");
        customer1.setCity("Bangalore");
        customer1.setZipCode("560068");
        customer1.setState("Karnataka");
        customer1.setPhoneNumber("9900376400");

        customers.put(customer1.getId(), customer1);

        Customer customer2 = new Customer();
        customer2.setId(getNextCustomerId());
        customer2.setFirstName("Mahita");
        customer2.setLastName("Vedantam");
        customer2.setEmail("v.mahita@gmail.com");
        customer2.setAddressLine1("Flat No. 204, Shravanthi Prosper Apartments");
        customer2.setAddressLine2("Sy. No. 2/3, Nyanappanahalli Main Road, Begur");
        customer2.setCity("Bangalore");
        customer2.setZipCode("560068");
        customer2.setState("Karnataka");
        customer2.setPhoneNumber("9900376400");

        customers.put(customer2.getId(), customer2);

        Customer customer3 = new Customer();
        customer3.setId(getNextCustomerId());
        customer3.setFirstName("Venkata Leela Krishna Sameera");
        customer3.setLastName("Vedantam");
        customer3.setEmail("v.krishnasameera@gmail.com");
        customer3.setAddressLine1("Flat No. 204, Shravanthi Prosper Apartments");
        customer3.setAddressLine2("Sy. No. 2/3, Nyanappanahalli Main Road, Begur");
        customer3.setCity("Bangalore");
        customer3.setZipCode("560068");
        customer3.setState("Karnataka");
        customer3.setPhoneNumber("9900576400");

        customers.put(customer3.getId(), customer3);
    }

    @Override
    public List<Customer> customers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Integer saveOrUpdate(Customer customer) {
        if (customer != null) {
            if (customer.getId() == null) {
                // New customer
                customer.setId(getNextCustomerId());
            }
            customers.put(customer.getId(), customer);
            return customer.getId();
        } else {
            throw new RuntimeException("Customer can't be null!");
        }
    }

    private Integer getNextCustomerId() {
        if (!customers.isEmpty())
            return Collections.max(customers.keySet()) + 1;
        else
            return 1;
    }

    @Override
    public void delete(Integer id) {
        customers.remove(id);
    }


/*    public static void main(String[] args) {
        CustomerService cs = new CustomerServiceImpl();
    }*/
}
