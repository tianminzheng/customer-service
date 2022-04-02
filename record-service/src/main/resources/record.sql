DROP TABLE IF EXISTS `ticket_record`;

CREATE TABLE `ticket_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` varchar(100) DEFAULT NULL,
  `ticket_id` varchar(100) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `staff` varchar(100) DEFAULT NULL,
  `message_source` varchar(100) DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `ticket_record` VALUES ('1', 'record1', 'ticket1', 'account1', 'staff1', 'CUSTOMER', 'message1');
INSERT INTO `ticket_record` VALUES ('1', 'record2', 'ticket2', 'account2', 'staff2', 'STAFF', 'message2');
