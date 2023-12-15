package com.example.demo666.controller;

import com.example.demo666.model.Category;
import com.example.demo666.model.Phone;
import com.example.demo666.service.ICategoryService;
import com.example.demo666.service.IPhoneService;
import com.example.demo666.service.impl.CategoryService;
import com.example.demo666.service.impl.PhoneService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "phone_servlet", value = "/phone_servlet")
public class phone_servlet extends HttpServlet {
    ICategoryService categoryService = new CategoryService();
    IPhoneService phoneService = new PhoneService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormAddPhone(request, response);
                break;
            case "delete":

                break;
            case "edit":
                showFormUpdate(request,response);
                break;
            case "sort":

                break;
            case "search":
                showFormSearch(request,response);
                break;
            default:
                showList(request, response);


        }
    }
    public void showFormSearch(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("search");
        List<Category> categories = categoryService.showList();
        List<Phone> phones = phoneService.searchPhone(name);
        String message;
        if (phones.size() == 0){
            message = "No phones found";
            request.setAttribute("message", message);
        }else{
            request.setAttribute("categories" , categories);
            request.setAttribute("phones",phones);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void showFormUpdate(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        List<Phone> phones = phoneService.showList();
        List<Category> categories = categoryService.showList();
        Phone phone = null;
        for (int i = 0; i < phones.size(); i++) {
            if(phones.get(i).getId() == id){
                phone = phones.get(i);
            }
        }
        request.setAttribute("phone", phone);
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showFormAddPhone(HttpServletRequest request, HttpServletResponse response){
        List<Category> categories = categoryService.showList();
        request.setAttribute("categories",categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showList(HttpServletRequest request, HttpServletResponse response){
        List<Phone> phones = phoneService.showList();
        List<Category> categories = categoryService.showList();
        request.setAttribute("phones", phones);
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
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
                addPhone(request, response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "edit":
                update(request, response);
                break;
            case "sort":

                break;
            case "search":

                break;
            default:

        }
    }
    public void update(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int id_category = Integer.parseInt(request.getParameter("category"));
        Phone phone = new Phone(id, name, price, id_category);
        phoneService.updatePhone(phone);
        try {
            response.sendRedirect("/phone_servlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void delete(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        phoneService.removePhoneById(id);
        try {
            response.sendRedirect("/phone_servlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addPhone(HttpServletRequest request, HttpServletResponse response){
        int id = (int) (Math.random() * 1000);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int  category = Integer.parseInt(request.getParameter("category"));
        Phone phone = new Phone(id,name, price, category);
        phoneService.addPhone(phone);
        try {
            response.sendRedirect("/phone_servlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
