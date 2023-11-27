package com.example.hien_thi_danh_sach.service;

import com.example.hien_thi_danh_sach.model.KhachHang;
import com.example.hien_thi_danh_sach.repository.KhachHangRepo;

import java.util.List;

public class KhachHangSv implements IKhachHangSv{
    KhachHangRepo khachHangRepo = new KhachHangRepo();
    @Override
    public List<KhachHang> showList() {
        return khachHangRepo.showList();
    }
}
