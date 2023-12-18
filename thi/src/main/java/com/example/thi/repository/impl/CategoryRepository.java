package com.example.thi.repository.impl;

import com.example.thi.modal.Category;
import com.example.thi.repository.BaseRepository;
import com.example.thi.repository.ICategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private static final String SELECT_ALL_CATEGORY = "select * from category;";
    @Override
    public List<Category> listCategory() {
        List<Category> categories = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String name = resultSet.getString("category_name");
                categories.add(new Category(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
