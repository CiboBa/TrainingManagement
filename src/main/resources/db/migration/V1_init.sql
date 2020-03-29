create table customer
(
    customer_id  int primary key auto_increment not null,
    first_name   varchar(15)                    not null,
    last_name    varchar(15)                    not null,
    email        varchar(50)                    not null,
    password     varchar(15)                    not null,
    phone_number varchar(9)                     not null,
    role         varchar(10),
    active       boolean
);

create table course
(
    course_id   int primary key auto_increment not null,
    course_name varchar(50)                    not null,
    start_Date  varchar(15),
    end_Date    varchar(15)
);

create table lecture
(
    lecture_id   int primary key auto_increment not null,
    lecture_name varchar(15)                    not null,
    date         varchar(15)
);