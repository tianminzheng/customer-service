DROP TABLE IF EXISTS `customer_ticket`;
DROP TABLE IF EXISTS `message`;

CREATE TABLE `customer_ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ticket_id` varchar(100) not null,
  `status` varchar(20) not null,  
  `score` int(10) not null,
  `consultation_id` varchar(100) not null,
  `account` varchar(50) not null,
  `inquire` varchar(200) not null,
  `order_number` varchar(100) not null,
  `delivery_address` varchar(100) not null,
  `goods` varchar(200) DEFAULT NULL,
  `staff_id` varchar(100) DEFAULT NULL,
  `staff_name` varchar(100) DEFAULT NULL,
  `staff_description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ticket_id` varchar(100) not null,
  `account` varchar(50) not null,
  `staff` varchar(100) DEFAULT NULL,  
  `message_source` varchar(20) not null,
  `message` varchar(200) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


