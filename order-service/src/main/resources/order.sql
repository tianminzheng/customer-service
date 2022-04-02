DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `goods`;
DROP TABLE IF EXISTS `order_goods`;

create table `order` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`order_number` varchar(100) not null,
	`account` varchar(50) not null,
	`delivery_address` varchar(100) not null,
	PRIMARY KEY (`id`)
);

create table `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(100) not null,
  `goods_name` varchar(50) not null,
  `price` double not null,
	PRIMARY KEY (`id`)
);

create table `order_goods` (
	`order_id` bigint(20) not null,
	`goods_id` bigint(20) not null,
	foreign key(`order_id`) references `order`(`id`),	
	foreign key(`goods_id`) references `goods`(`id`)
);


insert into `order` VALUES ('1', 'orderNumber1', 'account1', 'deliveryAddress1');
insert into `goods` VALUES ('1', 'goodsCode1', 'goodsName1', '100');
insert into `order_goods` VALUES ('1', '1');