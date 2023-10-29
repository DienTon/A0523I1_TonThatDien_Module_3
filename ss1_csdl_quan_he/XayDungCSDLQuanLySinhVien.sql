CREATE DATABASE students;
use students;

CREATE TABLE class (
    id INT PRIMARY KEY,
    nameClass VARCHAR(50)
);

CREATE TABLE teacher (
    id INT PRIMARY KEY,
    nameTeacher VARCHAR(50),
    age INT,
    country VARCHAR(50)
);

SELECT 
    *
FROM
    class;
insert into class(id,nameClass)
value(1,'A05'),(2,'A06'),(3,'A07');

SELECT 
    *
FROM
    teacher;
insert into teacher(id,nameTeacher,age,country)
value(1,'Nguyen Van A',30,'VN'),(2,'Nguyen Van B',44,'VN'),(3,'Nguyen Van C',55,'VN');
