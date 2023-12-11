package com.example.case_study1.repository.customer;

import com.example.case_study1.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeRepo {
    public List<CustomerType> find_all();
}
