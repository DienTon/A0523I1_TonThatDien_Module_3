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
SELECT p.id_phone,p.name_phone,p.price_phone,c.name_category  FROM phone as p join category as c on p.id_category = c.id_category;
 
insert into phone set id_phone = 2,name_phone = "leulisxssss" , price_phone = 1000, id_category = 2;

SELECT phone.id_phone,phone.name_phone, phone.price_phone, category.name_category
FROM phone
INNER JOIN category ON phone.id_category = category.id_category;