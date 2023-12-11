package com.example.case_study1.service.impl.customer;

import com.example.case_study1.model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    List<Customer> showListCustomer();
    void addCustomer(Customer customer);
    public void deleteCustomer(int id) throws SQLException;

    public void updateCustomer(Customer customer) throws SQLException;
    public List<Customer> selectByName(String name);
    public Customer selectById(int id);
}
