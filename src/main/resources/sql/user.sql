/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-26 10:04:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'ofh', '2018-06-25 17:19:53');
INSERT INTO `user` VALUES ('2', 'hahaha', '2018-06-20 17:20:06');
INSERT INTO `user` VALUES ('3', 'adsdwsf', '2018-06-06 17:20:12');
INSERT INTO `user` VALUES ('4', 'vevvdsvds', '2018-10-01 00:00:00');
INSERT INTO `user` VALUES ('5', '欧富华', '2018-10-01 00:00:00');
INSERT INTO `user` VALUES ('6', '欧富华', '2018-10-01 00:00:00');
INSERT INTO `user` VALUES ('7', '欧富华', null);
