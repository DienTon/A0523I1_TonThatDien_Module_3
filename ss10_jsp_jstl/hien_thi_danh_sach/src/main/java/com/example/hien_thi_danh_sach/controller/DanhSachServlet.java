package com.example.hien_thi_danh_sach.controller;


import com.example.hien_thi_danh_sach.model.KhachHang;
import com.example.hien_thi_danh_sach.service.IKhachHangSv;
import com.example.hien_thi_danh_sach.service.KhachHangSv;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DanhSachServlet", value = "/DanhSach-Servlet")
public class DanhSachServlet extends HttpServlet {
    private IKhachHangSv iKhachHangSv = new KhachHangSv();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> list = iKhachHangSv.showList();
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/khachHang-list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
