/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : localhost:3306
 Source Schema         : house

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 17/10/2018 23:00:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for h_ajk_new
-- ----------------------------
DROP TABLE IF EXISTS `h_ajk_new`;
CREATE TABLE `h_ajk_new` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '编号',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '小区',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `price` float(18,2) DEFAULT NULL COMMENT '价格',
  `html` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'html地址',
  `day` date DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1082 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for h_ajk_old
-- ----------------------------
DROP TABLE IF EXISTS `h_ajk_old`;
CREATE TABLE `h_ajk_old` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '编号',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '小区',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `price` float(18,2) DEFAULT NULL COMMENT '价格',
  `html` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'html地址',
  `day` date DEFAULT NULL COMMENT '日期',
  `house_age` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '年代',
  `house_type` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '户型',
  `house_areas` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '面积',
  `house_orien` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '朝向',
  `house_floor` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '楼层',
  `house_pay` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '建议首付',
  `house_spruce` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '装修程度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6570 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
