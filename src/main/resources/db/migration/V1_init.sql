# create database calendar;
create table customer
(
    customer_id  int primary key auto_increment not null,
    first_name   varchar(15)                    not null,
    last_name    varchar(15)                    not null,
    email        varchar(50)                    not null,
    password     varchar(15)                    not null,
    phone_number varchar(9)                     not null,
    role         varchar(10)                    ,
    active       boolean
);