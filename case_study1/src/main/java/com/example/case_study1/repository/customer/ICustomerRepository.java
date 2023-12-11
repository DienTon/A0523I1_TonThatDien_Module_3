package com.example.case_study1.repository.customer;

import com.example.case_study1.model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    List<Customer> showListCustomer();
    void addCustomer(Customer customer);
    public void deleteCustomer(int id) throws SQLException;

    public void updateCustomer(Customer customer) throws SQLException;
    public List<Customer>  selectByName(String name);
    public Customer selectById(int id);
}
