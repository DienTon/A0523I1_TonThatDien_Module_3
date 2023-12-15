package com.example.demo666.service.impl;

import com.example.demo666.model.Category;
import com.example.demo666.repository.ICategoryRepo;
import com.example.demo666.repository.impl.CategoryRepo;
import com.example.demo666.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    ICategoryRepo repo = new CategoryRepo();
    @Override
    public List<Category> showList() {
        return repo.showList();
    }
}
