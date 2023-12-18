package com.example.thi.controller;

import com.example.thi.modal.Category;
import com.example.thi.modal.Product;
import com.example.thi.repository.ICategoryRepository;
import com.example.thi.repository.IProductRepository;
import com.example.thi.repository.impl.CategoryRepository;
import com.example.thi.repository.impl.ProductRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "product_servlet", value = "/product_servlet")
public class product_servlet extends HttpServlet {
    ICategoryRepository categoryRepository = new CategoryRepository();
    IProductRepository productRepository = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormAddProduct(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
            case "search":
                showFormSearch(request, response);
                break;
            default:
                showListProduct(request, response);
        }
    }
    public void showFormSearch(HttpServletRequest request, HttpServletResponse response){
        List<Product> products = productRepository.searchProductsByName(request.getParameter("search"));
        request.setAttribute("products",products);
        String message = "";
        if (products.size() == 0){
            message = "Không tìm thấy product ";
            request.setAttribute("message",message);
        }else {
            request.setAttribute("products",products);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showFormUpdate(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> products = productRepository.listProducts();
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == id){
                product = products.get(i);
            }
        }
        List<Category> categories = categoryRepository.listCategory();
        request.setAttribute("product",product);
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showFormAddProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categories = categoryRepository.listCategory();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productRepository.listProducts();
        List<Category> categories = categoryRepository.listCategory();
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            default:
                showListProduct(request, response);
        }
    }
    public void updateProduct(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(id,name,price,quantity,color,category);
        productRepository.updateProduct(product);
        try {
            response.sendRedirect("/product_servlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 1000);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(id, name, price, quantity, color, category);
        productRepository.addProduct(product);
        try {
            response.sendRedirect("/product_servlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productRepository.removeProduct(id);
        try {
            response.sendRedirect("/product_servlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
