# Jcommerce

### MySQL Script
~~~ sql
create database if not exists jcommerce;
use jcommerce;
create table if not exists products (
	id int not null auto_increment primary key,
    description varchar(255),
    price double
);
~~~
