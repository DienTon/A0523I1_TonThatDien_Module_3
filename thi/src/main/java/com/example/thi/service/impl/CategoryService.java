package com.example.thi.service.impl;

import com.example.thi.modal.Category;
import com.example.thi.repository.ICategoryRepository;
import com.example.thi.repository.impl.CategoryRepository;
import com.example.thi.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    ICategoryRepository  categoryRepository = new CategoryRepository();
    @Override
    public List<Category> listCategory() {
        return categoryRepository.listCategory();
    }
}
