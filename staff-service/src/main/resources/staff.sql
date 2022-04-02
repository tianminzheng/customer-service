DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(100) DEFAULT NULL,
  `staff_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `staff` VALUES ('1', 'staff1', 'staffname1', 'description1');
INSERT INTO `staff` VALUES ('2', 'staff2', 'staffname2', 'description2');