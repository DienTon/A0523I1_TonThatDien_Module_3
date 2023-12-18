package com.example.thi.repository;

import com.example.thi.modal.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> listProducts();
    void addProduct(Product product);
    void removeProduct(int id);
    void updateProduct(Product product);
    List<Product> searchProductsByName(String name);
}
