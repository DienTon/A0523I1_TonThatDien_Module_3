create database phones;
use phones;

create table category(
	id_category int primary key,
    name_category varchar(45)
);
create table phone(
	id_phone int primary key,
    name_phone varchar(45),
    price_phone double,
    id_category int,
    FOREIGN KEY (id_category)
        REFERENCES category (id_category)
);

insert into phone set id_phone = 2,name_phone = "leulisssss" , price_phone = 1000, id_category = 2;