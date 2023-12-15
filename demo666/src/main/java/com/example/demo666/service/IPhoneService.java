package com.example.demo666.service;

import com.example.demo666.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> showList();
    List<Phone> searchPhone(String name);
    void addPhone(Phone phone);
    void removePhoneById(int id);
    void updatePhone(Phone phone);
}
