package com.example.hien_thi_danh_sach.repository;

import com.example.hien_thi_danh_sach.model.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepo implements IKhachHangRepo{
    private static List<KhachHang> list = new ArrayList<>();
    static {
        list.add(new KhachHang("Vũ","20/2/2000", "Da nang",""));
        list.add(new KhachHang("Thông","30/2/2003", "Hue",""));
        list.add(new KhachHang("Thư","10/1/2001", "Quang Tri", ""));
    }
    @Override
    public List<KhachHang> showList() {
        return list;
    }
}
