package com.example.quanlyuser.repository;

import com.example.quanlyuser.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private static final String INSERT_USERS_SQL = "INSERT INTO users  (id_user,name_user, email_user, country_user) VALUES (?, ?, ?, ?);";
    private static final String FIND_ALL = "SELECT * FROM users";
    public static final String SELECT_USER_BY_COUNTRY = "SELECT * FROM users WHERE country_user =?";
    private static final String SELECT_USER_BY_ID = "select id_user,name_user,email_user,country_user from users where id_user =?";
    private static final String ORDER_BY_NAME = "SELECT * FROM users ORDER BY name_user ";
    private static final String DELETE_USERS_SQL = "delete from users where id_user = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name_user = ?,email_user= ?, country_user =? where id_user = ?";

    public UserDAO() {
    }


    @Override
    public List<User> showList() {
        List<User> users = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_user");
                String userName = resultSet.getString("name_user");
                String email = resultSet.getString("email_user");
                String country = resultSet.getString("country_user");
                users.add(new User(id, userName, email, country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void addUser(User user) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name_user");
                String email = rs.getString("email_user");
                String country = rs.getString("country_user");
                user = new User(id,name, email, country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        return null;
    }

    @Override
    public List<User> selectUserByCountry(String country) {
        List<User> users = new ArrayList<User>();
        Connection connection =BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            ps.setString(1, country);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_user");
                String name = rs.getString("name_user");
                String email = rs.getString("email_user");
                String countryUser = rs.getString("country_user");
                users.add(new User(id, name, email, countryUser));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> oderByName() {
        List<User> users = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(ORDER_BY_NAME);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_user");
                String name = rs.getString("name_user");
                String email = rs.getString("email_user");
                String country = rs.getString("country_user");
                users.add(new User(id,name, email, country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(DELETE_USERS_SQL);
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_USERS_SQL);
        ps.setString(1,user.getName());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getCountry());
        ps.setInt(4,user.getId());
        ps.executeUpdate();
    }
}
