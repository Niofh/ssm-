/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-08-03 00:20:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(255) DEFAULT NULL COMMENT '学生名称',
  `age` int(5) DEFAULT NULL COMMENT '学生年龄',
  `gender` int(5) DEFAULT NULL COMMENT '学生性别 0是男，1是女',
  `adress` varchar(255) DEFAULT NULL COMMENT '学生地址',
  `create_user` int(11) DEFAULT NULL COMMENT '创建者',
  `update_user` int(11) DEFAULT NULL COMMENT '修改者',
  `del` smallint(1) DEFAULT '0' COMMENT '0没删除，1已删除',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', 'SADFASF', '18', '1', 'SDFSDFDFWF', null, null, '0', '2018-08-03 00:16:36', '2018-08-03 00:16:36');
