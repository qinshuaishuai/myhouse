/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : house

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 10/10/2018 14:57:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for h_new
-- ----------------------------
DROP TABLE IF EXISTS `h_ajk_new`;
CREATE TABLE `h_ajk_new` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '编号',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '小区',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `price` float(18,2) DEFAULT NULL COMMENT '价格',
  `html` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'html地址',
  `date` date DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;