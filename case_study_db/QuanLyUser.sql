create database quan_ly_user;
USE quan_ly_user;

create table users(
id_user int not null auto_increment,
name_user varchar(45) not null,
email_user varchar(220) not null,
country_user varchar(100) not null,
primary key (id_user)
);

insert into users(name_user, email_user, country_user) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name_user, email_user, country_user) values('Kante','kante@che.uk','Kenia');