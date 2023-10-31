create database ss2_ba1;
use ss2_ba1;

create table PHIEUXUAT(
SoPX int primary key,
NgayXuat date
);

create table VATTU(
MaVTU int primary key,
TenVTU varchar(50)
);

create table PHIEUNHAP(
SoPN int primary key,
NhapNgay date
);
create table DONDH(
SoDH int primary key,
NgayDH date
);

create table NHACC(
MaNCC int primary key,
TenNCC varchar(50),
DiaChi varchar(50),
SDT int 
);

create table chi_tiet_phieu_xuat(
DGXuat int,
SLXuat int,
SoPX int,
MaVTU int,
primary key(SoPX,MaVTU),
foreign key(SoPX) references PHIEUXUAT(SoPX),
foreign key(MaVTU) references VATTU(MaVTU)
);

create table chi_tiet_phieu_nhap(
DGNhap int,
SLNhap int,
SoPN int,
MaVTU int,
primary key(SoPN,MaVTU),
foreign key(SoPN) references PHIEUNHAP(SoPN),
foreign key(MaVTU) references VATTU(MaVTU)
);

create table chi_tiet_don_dat_hang(
MaVTU int,
SoDH int,
primary key(MaVTU,SoDH),
foreign key(MaVTU) references VATTU(MaVTU),
foreign key(SoDH) references DONDH(SoDH)
);

create table cung_cap(
MaNCC int,
SoDH int,
primary key(MaNCC,SoDH),
foreign key(MaNCC) references NHACC(MaNCC),
foreign key(SoDH) references DONDH(SoDH)
);
