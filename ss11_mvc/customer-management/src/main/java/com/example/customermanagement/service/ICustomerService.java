package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showList();
    void add(Customer customer);
    Customer findById(int id);
    void update(int id,Customer customer);
    void delete(int id);
}
