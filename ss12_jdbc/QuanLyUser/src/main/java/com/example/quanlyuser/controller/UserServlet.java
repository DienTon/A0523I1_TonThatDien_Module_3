package com.example.quanlyuser.controller;

import com.example.quanlyuser.model.User;
import com.example.quanlyuser.repository.IUserDAO;
import com.example.quanlyuser.repository.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    IUserDAO iUserDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String search = request.getParameter("searchCountry") ;
        System.out.println(search);
        if (search != null) {
            showFormSearch(request, response);
        }
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "sort":
                sortByName(request, response);
                break;
            default:
                showListUser(request, response);
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
                addNewUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "edit":
                editUser(request, response);
                break;
            case "search":
//                searchByCountry(request, response);
                break;
            default:
                showListUser(request, response);
        }
    }

    public void showListUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = iUserDAO.showList();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = iUserDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("user", user);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = iUserDAO.selectUser(id);
//        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/delete.jsp");
        request.setAttribute("user", user);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
//        List<User> list = iUserDAO
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void sortByName(HttpServletRequest request, HttpServletResponse response){
        List<User> list = iUserDAO.oderByName();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showFormSearch(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = iUserDAO.selectUserByCountry(request.getParameter("searchCountry"));
        if (list.size() == 0) {
            String messages = "Không tìm thấy User.";
            request.setAttribute("message",messages);
        }
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNewUser(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 1000);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        iUserDAO.addUser(user);
        try {
            response.sendRedirect("/UserServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            iUserDAO.deleteUser(id);
            response.sendRedirect("/UserServlet");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void editUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        try {
            iUserDAO.updateUser(user);
            response.sendRedirect("/UserServlet");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
//            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
