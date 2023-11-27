package com.example.hien_thi_danh_sach.model;

public class KhachHang {
    private String tenKh,ngaySinh,diaChi,anh;

    public KhachHang(String tenKh, String ngaySinh, String diaChi, String anh) {
        this.tenKh = tenKh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.anh = anh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "tenKh='" + tenKh + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", anh='" + anh + '\'' +
                '}';
    }
}
