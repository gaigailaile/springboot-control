/*
Navicat MySQL Data Transfer

Source Server         : aliyun-root
Source Server Version : 80013
Source Host           : 39.105.3.245:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-10-29 14:25:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '1', '2');
INSERT INTO `user_role` VALUES ('3', '2', '2');
INSERT INTO `user_role` VALUES ('4', '3', '3');
