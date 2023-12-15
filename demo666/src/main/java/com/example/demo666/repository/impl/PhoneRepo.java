package com.example.demo666.repository.impl;

import com.example.demo666.model.Phone;
import com.example.demo666.repository.BaseRepository;
import com.example.demo666.repository.IPhoneRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepo implements IPhoneRepo {
    private static final String SELECT_ALL = "SELECT * FROM phone;";
    private static final String SELECT_BY_NAME = "SELECT * FROM phone where name_phone like ?;";
    private static final String UPDATE_PHONE = "UPDATE phone SET name_phone = ?, price_phone = ? , id_category = ? where id_phone = ?; ";
    private static final String DELETE_PHONE = "delete from phone where id_phone = ?";
    private static final String ADD_NEW_PHONE = "insert into phone(id_phone,name_phone,price_phone,id_category) values (?,?,?,?);";

    @Override
    public List<Phone> showList() {
        List<Phone> phones = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_phone");
                String name = resultSet.getString("name_phone");
                double price = resultSet.getDouble("price_phone");
                int id_category = resultSet.getInt("id_category");
                phones.add(new Phone(id,name, price, id_category));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phones;
    }

    @Override
    public List<Phone> searchPhone(String name) {
        List<Phone> phone = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME);
            statement.setString(1, "%"+name+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_phone");
                String name_phone = resultSet.getString("name_phone");
                double price_phone = resultSet.getDouble("price_phone");
                int id_category = resultSet.getInt("id_category");
                phone.add(new Phone(id,name_phone,price_phone,id_category));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phone;
    }

    @Override
    public void addPhone(Phone phone) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_NEW_PHONE);
            statement.setInt(1, phone.getId());
            statement.setString(2, phone.getName());
            statement.setDouble(3, phone.getPrice());
            statement.setInt(4, phone.getCategory());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removePhoneById(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PHONE);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePhone(Phone phone) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PHONE);
            statement.setInt(4, phone.getId());
            statement.setString(1, phone.getName());
            statement.setDouble(2, phone.getPrice());
            statement.setInt(3, phone.getCategory());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
