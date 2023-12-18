package com.example.thi.service.impl;

import com.example.thi.modal.Product;
import com.example.thi.repository.IProductRepository;
import com.example.thi.repository.impl.ProductRepository;
import com.example.thi.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> listProducts() {
        return productRepository.listProducts();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void removeProduct(int id) {
        productRepository.removeProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return productRepository.searchProductsByName(name);
    }
}
