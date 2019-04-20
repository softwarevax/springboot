/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50550
Source Host           : 192.168.1.3:3306
Source Database       : social

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2019-04-16 00:24:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staff_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '员工编号',
  `staff_name` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '员工姓名',
  `staff_position` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '员工职位',
  `staff_suffer` tinyint(3) DEFAULT NULL COMMENT '员工的工作经验',
  `staff_company` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', '李四', '软件开发', '2', 'wit');
