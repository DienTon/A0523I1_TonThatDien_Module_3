package com.example.case_study1.controller;

import com.example.case_study1.model.customer.Customer;
import com.example.case_study1.model.customer.CustomerType;
import com.example.case_study1.service.impl.customer.ICustomerService;
import com.example.case_study1.service.impl.customer.ICustomerTypeService;
import com.example.case_study1.service.impl.customer.CustomerService;
import com.example.case_study1.service.impl.customer.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "customer-servlet", value = "/customer-servlet")
public class customerservlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    ICustomerTypeService customerTypeService = new CustomerTypeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormAdd(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "sort":

                break;
            case "search":
                showFormSearch(request, response);
                break;
            default:
                showListCustomer(request,response);

        }
    }
    public void showFormSearch(HttpServletRequest request, HttpServletResponse response){
        String message = "";
        String name = request.getParameter("searchByName");
        List<Customer> customer = customerService.selectByName(name);
        if (customer.size() == 0){
            message = "Không tìm thấy Customer: " + name;
            request.setAttribute("message", message);
            customer = null;
        }else {
            request.setAttribute("customer",customer);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/search.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showFormEdit(HttpServletRequest request, HttpServletResponse response){
        Customer customer = customerService.selectById(Integer.parseInt(request.getParameter("id")));
        List<CustomerType> customerTypeList = customerTypeService.find_all();
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showFormAdd(HttpServletRequest request, HttpServletResponse response){
        List<CustomerType> customerTypeList = customerTypeService.find_all();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showListCustomer(HttpServletRequest request, HttpServletResponse response){
        List<Customer> customers = customerService.showListCustomer();
        List<CustomerType> customerTypeList = customerTypeService.find_all();
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("/customer/home.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showFormDelete(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectById(id);
        List<CustomerType> customerTypeList = customerTypeService.find_all();
        request.setAttribute("customerTypeList",customerTypeList);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/delete.jsp");
        try {
            dispatcher.forward(request, response);
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
            case "create":
                addCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "sort":

                break;
            case "search":

                break;
            default:
//                showListCustomer(request,response);

        }
    }
    public void updateCustomer(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idCustomerType = Integer.parseInt(request.getParameter("type"));
        Customer customer = new Customer(id,name,date,gender,id_card,phone,email,address,idCustomerType);
        try {
            customerService.updateCustomer(customer);
            response.sendRedirect("/customer-servlet");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response){

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            customerService.deleteCustomer(id);
            response.sendRedirect("/customer-servlet");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addCustomer(HttpServletRequest request, HttpServletResponse response){
        int id = (int) (Math.random() * 1000);
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int type = Integer.parseInt(request.getParameter("type"));
        Customer customer = new Customer(id,name,date,gender,id_card,phone,email,address,type);
        customerService.addCustomer(customer);
        try {
            response.sendRedirect("/customer-servlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
