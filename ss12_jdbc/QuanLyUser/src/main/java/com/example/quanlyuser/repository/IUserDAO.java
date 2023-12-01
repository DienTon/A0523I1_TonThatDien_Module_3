package com.example.quanlyuser.repository;

import com.example.quanlyuser.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    List<User> showList();
    void addUser(User user);

    public User selectUser(int id);

    public List<User> selectAllUsers();
    public List<User> selectUserByCountry(String country);
    public List<User> oderByName();

    public void deleteUser(int id) throws SQLException;

    public void updateUser(User user) throws SQLException;
}
