/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50550
Source Host           : 192.168.1.3:3306
Source Database       : school

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2019-04-16 00:23:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `stu_name` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `stu_sex` tinyint(1) DEFAULT '0' COMMENT '性别',
  `stu_age` int(3) DEFAULT NULL COMMENT '年龄',
  `stu_habit` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '爱好',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1305120202', '张三', '0', '18', '编程');
