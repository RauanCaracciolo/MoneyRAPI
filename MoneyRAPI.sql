create database if not exists moneyapi;
use moneyapi;
create table transactions(
	id serial,
	value_ double,
    description_ varchar(100),
    type_ varchar(100), 
    category varchar(100),
    date_ Date,
    primary key(id)
    );
    
select * from transactions;
