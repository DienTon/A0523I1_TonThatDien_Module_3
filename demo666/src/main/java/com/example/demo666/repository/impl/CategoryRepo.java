package com.example.demo666.repository.impl;

import com.example.demo666.model.Category;
import com.example.demo666.model.Phone;
import com.example.demo666.repository.BaseRepository;
import com.example.demo666.repository.ICategoryRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo {
    private static final String SELECT_ALL = "SELECT * FROM category;";
    @Override
    public List<Category> showList() {
        List<Category> categories = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_category");
                String name = resultSet.getString("name_category");
                categories.add(new Category(id,name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
