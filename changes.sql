create table companyDetail(
	id int not null auto_increment primary key,
	companyName varchar(100) not null,
	tradeType enum('sale','purchase') not null,
	deleteFlag tinyint(1) not null default 0,
	Unique (companyName, tradeType)
);


create table product(
	id int(11) auto_increment primary key,
    name varchar(255) not null default '',
    price decimal(10,2) not null default 0.00,
    companyId int(11),
    shortDesc varchar(255) not null default '',
    longDesc text,
    image blob,
    deleteFlag tinyint(1) not null default 0,
    FOREIGN KEY (companyId) REFERENCES companyDetail(id)
);

create table stock(
	id int(11) auto_increment primary key,
	productId int(11),
	quantity int(5) not null default 0,
	deleteFlag tinyint(1) not null default 0,
    FOREIGN KEY (productId) REFERENCES product(id)
);

create table users(
	id int(11) auto_increment primary key,
	ulname varchar(30) not null default '',
	ufname varchar(30) not null,
	email varchar(100) not null,
	pwd varchar(20) not null,
	mobileNo varchar(20) not null,
	userType tinyint(1) not null default 0,
	deleteFlag tinyint(1) not null default 0
);

create table orders(
	id int(11) auto_increment primary key,
    productId int(11),
    uid int(11),
    amount decimal(10,2) not null default 0.00,
    orderdDate datetime not null default now(),
    orderStatus tinyint(1) not null default 0,
    deliveredDate datetime,
	deleteFlag tinyint(1) not null default 0,
    FOREIGN KEY (productId) REFERENCES product(id),
    FOREIGN KEY (uid) REFERENCES users(id)
);
