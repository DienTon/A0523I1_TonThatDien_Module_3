package com.example.case_study1.service.impl.customer;

import com.example.case_study1.model.customer.Customer;
import com.example.case_study1.repository.customer.CustomerRepository;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> showListCustomer() {
        return customerRepository.showListCustomer();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer>  selectByName(String name) {
        return customerRepository.selectByName(name);
    }
    public Customer selectById(int id) {
        return customerRepository.selectById(id);
    }
}
