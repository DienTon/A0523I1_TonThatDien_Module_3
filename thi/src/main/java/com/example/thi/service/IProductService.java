package com.example.thi.service;

import com.example.thi.modal.Product;

import java.util.List;

public interface IProductService {
    List<Product> listProducts();
    void addProduct(Product product);
    void removeProduct(int id);
    void updateProduct(Product product);
    List<Product> searchProductsByName(String name);
}
