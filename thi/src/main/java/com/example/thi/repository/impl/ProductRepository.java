package com.example.thi.repository.impl;

import com.example.thi.modal.Product;
import com.example.thi.repository.BaseRepository;
import com.example.thi.repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL = "select * from product;";
    private static final String SELECT_BY_NAME = "select * from product where product_name like ?;";
    private static final String DELETE_PRODUCT = "delete from product where product_id = ?";
    private static final String UPDATE_PRODUCT = "update product set product_name =?,product_price=?,product_quantity=?,product_color=?,id_category=? where product_id =?;";
    private static final String ADD_PRODUCT = "insert into product(product_id,product_name,product_price,product_quantity,product_color,id_category) values (?,?,?,?,?,?);";

    @Override
    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                double price = rs.getDouble("product_price");
                int quantity = rs.getInt("product_quantity");
                String color = rs.getString("product_color");
                int id_category = rs.getInt("id_category");
                products.add(new Product(id, name, price, quantity, color, id_category));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void addProduct(Product product) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_PRODUCT);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setString(5, product.getColor());
            ps.setInt(6, product.getId_category());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeProduct(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(Product product) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);
            statement.setInt(6, product.getId());
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setInt(5, product.getId_category());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        List<Product> products = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                double price = rs.getDouble("product_price");
                int quantity = rs.getInt("product_quantity");
                String color = rs.getString("product_color");
                int id_category = rs.getInt("id_category");
                products.add(new Product(id, nameProduct, price, quantity, color, id_category));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
