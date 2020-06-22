package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int customerId);

    public void deleteCustomer(int theId);

    public List<Customer> searchCustomersByName(String name);
}
