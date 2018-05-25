create database if not exists  utfpr_tests;

create table Pokemon (
    id int not null auto_increment,
    name varchar(45) not null,
    level int not null,
    hp int not null,
    agility int not null,
    attack int not null,
    defense int not null,
    specialAttack int not null,
    specialDefense int not null,
    primary key (id)
);