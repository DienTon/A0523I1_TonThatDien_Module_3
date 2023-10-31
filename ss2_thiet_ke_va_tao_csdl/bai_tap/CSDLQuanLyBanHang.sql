create database ss2_bai2;
use ss2_bai2;

create table customer(
cID int auto_increment primary key,
cName varchar(55),
cAge int
);
create table `order`(
cID int,
oID int,
oDate date,
primary key(oID),
foreign key(cID) references customer(cID)
);
create table product(
pID int primary key,
pName varchar(55),
pPrice int
);
create table orderDetail(
pID int,
oID int,
odQTY int,
primary key(oID,pID),
foreign key(oID) references `order`(oID),
foreign key(pID) references product(pID)
);

