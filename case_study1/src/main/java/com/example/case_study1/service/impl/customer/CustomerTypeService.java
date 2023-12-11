package com.example.case_study1.service.impl.customer;


import com.example.case_study1.model.customer.CustomerType;
import com.example.case_study1.repository.customer.CustomerTypeRepo;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    CustomerTypeRepo repo = new CustomerTypeRepo();

    @Override
    public List<CustomerType> find_all() {
        return repo.find_all();
    }
}
