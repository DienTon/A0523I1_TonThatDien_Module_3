create database quan_li_diem_thi;
use quan_li_diem_thi;

create table hoc_sinh(
maHs varchar(20) primary key,
tenHs varchar(50),
ngaySinh datetime,
lop varchar(20),
gT varchar(10)
);

create table mon_hoc(
maMh varchar(20) primary key,
tenMh varchar(50)
);
CREATE TABLE BangDiem(
    MaHS VARCHAR(20),
    MaMH VARCHAR(20),
    DiemThi INT,
    NgayKT DATETIME,
    PRIMARY KEY (maHs, maMH),
    FOREIGN KEY (maHs) REFERENCES hoc_sinh(maHs),
    FOREIGN KEY (maMH) REFERENCES mon_hoc(maMh)
);
CREATE TABLE GiaoVien(
    MaGV VARCHAR(20) PRIMARY KEY,
    TenGV VARCHAR(20),
    SDT VARCHAR(10)
);

ALTER TABLE mon_hoc ADD MaGV VARCHAR(20);
ALTER TABLE mon_hoc ADD CONSTRAINT FK_MaGV FOREIGN KEY (MaGV) REFERENCES GiaoVien(MaGV);
