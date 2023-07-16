create table product(
	id int(11) auto_increment primary key,
    name varchar(255) not null default '',
    price decimal(10,2) not null default 0.00,
    companyName varchar(60) not null default '',
    quantity int(5) not null default 0,
    deleteFlag tinyint(1) not null default 0
);

insert into product(name,price,companyName,quantity) values('HCL',120,'HCL Pharma',500),
('Methyl Benzine',80,'HCL Pharma',100);

create table orders(
	id int(11) auto_increment primary key,
    productId int(11),
    uid int(11),
    amount decimal(10,2) not null default 0.00,
    orderdDate datetime not null default now(),
    orderStatus tinyint(1) not null default 0,
    deliveredDate datetime,
	deleteFlag tinyint(1) not null default 0
);