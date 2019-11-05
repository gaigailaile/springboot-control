/*
Navicat MySQL Data Transfer

Source Server         : aliyun-root
Source Server Version : 80013
Source Host           : 39.105.3.245:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-10-29 14:25:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用：1启用（默认），0禁用',
  `locked` tinyint(1) DEFAULT '0' COMMENT '是否锁定：1锁定，0未锁定（默认）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', '123', '1', '0');
INSERT INTO `user` VALUES ('2', 'admin', '123', '1', '0');
INSERT INTO `user` VALUES ('3', 'user', '123', '1', '0');
