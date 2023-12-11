package com.example.case_study1.repository.customer;

import com.example.case_study1.model.customer.Customer;
import com.example.case_study1.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SHOW_LIST_CUSTOMER = "select * from khach_hang;";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from khach_hang where ho_ten like ? ;";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from khach_hang where ma_khach_hang = ? ;";
    private static final String DELETE_CUSTOMER_BY_ID = "delete from khach_hang where ma_khach_hang = ?;";
    private static final String UPDATE_CUSTOMER_BY_ID = "update khach_hang set ho_ten=?,ngay_sinh=?,gioi_tinh=?,so_cmnd=?,so_dien_thoai=?,email=?,dia_chi=?,ma_loai_khach=? where ma_khach_hang = ?;";
    private static final String ADD_NEW_CUSTOMER ="insert into khach_hang(ma_khach_hang,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) values (?,?,?,?,?,?,?, ?,?)";

    public List<Customer>  selectByName(String name){
        List<Customer> customers = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            statement.setString(1,"%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("ma_khach_hang");
                String customerName = resultSet.getString("ho_ten");
                String customerDate = resultSet.getString("ngay_sinh");
                int customerGender = resultSet.getInt("gioi_tinh");
                String customerCmnd = resultSet.getString("so_cmnd");
                String customerPhone = resultSet.getString("so_dien_thoai");
                String customerEmail = resultSet.getString("email");
                String customerAddress = resultSet.getString("dia_chi");
                int customerType = resultSet.getInt("ma_loai_khach");
                customers.add(new Customer(customerId,customerName,customerDate,customerGender,customerCmnd,customerPhone,customerEmail,customerAddress,customerType));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public Customer selectById(int id) {
        Customer customers = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("ma_khach_hang");
                String customerName = resultSet.getString("ho_ten");
                String customerDate = resultSet.getString("ngay_sinh");
                int customerGender = resultSet.getInt("gioi_tinh");
                String customerCmnd = resultSet.getString("so_cmnd");
                String customerPhone = resultSet.getString("so_dien_thoai");
                String customerEmail = resultSet.getString("email");
                String customerAddress = resultSet.getString("dia_chi");
                int customerType = resultSet.getInt("ma_loai_khach");
                customers = new Customer(customerId,customerName,customerDate,customerGender,customerCmnd,customerPhone,customerEmail,customerAddress,customerType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public List<Customer> showListCustomer() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SHOW_LIST_CUSTOMER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("ma_khach_hang");
                String customerName = resultSet.getString("ho_ten");
                String customerDate = resultSet.getString("ngay_sinh");
                int customerGender = resultSet.getInt("gioi_tinh");
                String customerCmnd = resultSet.getString("so_cmnd");
                String customerPhone = resultSet.getString("so_dien_thoai");
                String customerEmail = resultSet.getString("email");
                String customerAddress = resultSet.getString("dia_chi");
                int customerType = resultSet.getInt("ma_loai_khach");
                customers.add(new Customer(customerId,customerName,customerDate,customerGender,customerCmnd,customerPhone,customerEmail,customerAddress,customerType));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_NEW_CUSTOMER);
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getBirthDay());
            statement.setInt(4, customer.getGender());
            statement.setString(5, customer.getId_card());
            statement.setString(6, customer.getPhone());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAddress());
            statement.setInt(9, customer.getIdCustomerType());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
        statement.setInt(1,id);
        statement.executeUpdate();
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
        statement.setInt(9,customer.getId());
        statement.setString(1,customer.getName());
        statement.setString(2,customer.getBirthDay());
        statement.setInt(3,customer.getGender());
        statement.setString(4,customer.getId_card());
        statement.setString(5,customer.getPhone());
        statement.setString(6,customer.getEmail());
        statement.setString(7,customer.getAddress());
        statement.setInt(8,customer.getIdCustomerType());
        statement.executeUpdate();
    }
}
