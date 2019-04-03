/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : springboot_vue

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-04-01 17:49:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for persons
-- ----------------------------
DROP TABLE IF EXISTS `persons`;
CREATE TABLE `persons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `zone` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of persons
-- ----------------------------
INSERT INTO `persons` VALUES ('1', '2019-03-27 15:04:55', 'gubaoer@hotmail.com', '8613000001111', 'male', 'gubaoer', 0x486F6E674B6F75204469737472696374);
INSERT INTO `persons` VALUES ('2', '2019-03-27 15:04:55', 'boyle.gu@hotmail.com', '8613000001112', 'male', 'baoer.gu', 0x4A696E67416E204469737472696374);
INSERT INTO `persons` VALUES ('3', '2019-03-27 15:04:55', 'yoyo.wu@gmail.com', '8613000001113', 'female', 'yoyo.wu', 0x4A696E67416E204469737472696374);
INSERT INTO `persons` VALUES ('4', '2019-03-27 15:04:55', 'stacy.gao@126.com', '8613000001114', 'female', 'stacy.gao', 0x4D696E48616E67204469737472696374);
INSERT INTO `persons` VALUES ('5', '2019-03-27 15:04:55', 'yomiko.zhu@qq.com', '8613000001115', 'female', 'yomiko.zhu', 0x5075446F6E67204469737472696374);
INSERT INTO `persons` VALUES ('6', '2019-03-27 15:04:55', 'hong.zhu@163.com', '8613000001116', 'male', 'hong.zhu', 0x59616E675075204469737472696374);
INSERT INTO `persons` VALUES ('7', '2019-03-27 15:04:55', 'leon.lai@qq.com', '8613000001117', 'male', 'leon.lai', 0x4A696E5368616E204469737472696374);
INSERT INTO `persons` VALUES ('8', '2019-03-27 15:04:55', 'mark.lei@sohu.com', '8613000001118', 'male', 'mark.lei', 0x4875616E675075204469737472696374);
INSERT INTO `persons` VALUES ('9', '2019-03-27 15:04:55', 'wen.liu@360.com', '8613000001119', 'male', 'wen.liu', 0x43686F6E674D696E67204469737472696374);
INSERT INTO `persons` VALUES ('10', '2019-03-27 15:04:55', 'cai.lu@baidu.com', '8613000001120', 'female', 'cai.lu', 0x42616F5368616E204469737472696374);
INSERT INTO `persons` VALUES ('11', '2019-03-27 15:04:55', 'alex.li@icee.com', '8613000001121', 'male', 'alex.li', 0x4368616E674E696E67204469737472696374);
INSERT INTO `persons` VALUES ('12', '2019-03-27 15:04:55', 'sofia.xu@qq.com', '8613000001122', 'female', 'sofia.xu', 0x5A6861426569204469737472696374);
INSERT INTO `persons` VALUES ('13', '2019-03-27 15:04:55', 'cora.zhang@qq.com', '8613000001123', 'female', 'cora.zhang', 0x5875487569204469737472696374);
INSERT INTO `persons` VALUES ('14', '2019-03-27 15:04:55', 'tom.gao@hotmail.com', '8613000001124', 'female', 'tom.gao', 0x4875616E675075204469737472696374);

-- ----------------------------
-- Table structure for tb_token
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) NOT NULL COMMENT 'tb_user_id',
  `token` varchar(255) DEFAULT NULL COMMENT 'token',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `expire_date` datetime DEFAULT NULL COMMENT '过期时间（一个月）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_token
-- ----------------------------
INSERT INTO `tb_token` VALUES ('1', '2', '8aa58f2e-1159-4f91-84da-6ed2d1dba59f', '2019-03-29 17:25:21', '2019-04-29 17:25:21');
INSERT INTO `tb_token` VALUES ('2', '2', '0b1ced2b-8010-49ad-adb4-b3aedd9c837c', '2019-03-29 17:26:19', '2019-04-29 17:26:19');
INSERT INTO `tb_token` VALUES ('3', '2', '37b1f490-3fed-498f-a7f3-a21cf6461026', '2019-03-29 17:35:14', '2019-04-29 17:35:14');
INSERT INTO `tb_token` VALUES ('4', '2', '6ff4db20-f2fb-44f7-a5c5-e78f64ea20e9', '2019-03-29 17:36:32', '2019-04-29 17:36:32');
INSERT INTO `tb_token` VALUES ('5', '2', '56d8f9b2-abec-416f-9e26-bf71be1d2b85', '2019-03-29 17:59:07', '2019-04-29 17:59:07');
INSERT INTO `tb_token` VALUES ('6', '3', '37eb7cce-b40e-418e-8646-b4544acd7bd7', '2019-03-29 18:25:48', '2019-04-29 18:25:48');
INSERT INTO `tb_token` VALUES ('7', '3', '4fab9523-ee84-4c14-86ce-783ce34c5bbd', '2019-03-29 18:26:28', '2019-04-29 18:26:28');
INSERT INTO `tb_token` VALUES ('8', '3', '18a14238-11e3-4f1f-b832-8a0bc8768972', '2019-03-29 18:26:33', '2019-04-29 18:26:33');
INSERT INTO `tb_token` VALUES ('9', '3', '5cc4f1dd-44ea-4b07-bed2-48d441392f9f', '2019-03-29 18:26:54', '2019-04-29 18:26:54');
INSERT INTO `tb_token` VALUES ('10', '3', 'aced9907-50eb-4024-9ac8-0bda31fc37d7', '2019-03-29 18:34:01', '2019-04-29 18:34:01');
INSERT INTO `tb_token` VALUES ('11', '3', '4287af6e-e77f-4b6f-bc54-ef1589e60884', '2019-03-29 18:34:51', '2019-04-29 18:34:51');
INSERT INTO `tb_token` VALUES ('12', '3', '3d0ffadb-ae84-4899-8af6-80ca4a0e7972', '2019-03-29 18:36:40', '2019-04-29 18:36:40');
INSERT INTO `tb_token` VALUES ('13', '3', 'c22d5b1f-e12f-46b0-a280-f24aed3cab5a', '2019-03-29 18:36:41', '2019-04-29 18:36:41');
INSERT INTO `tb_token` VALUES ('14', '3', 'b240977d-106e-4a3f-9ddf-72f8e1f5a7cb', '2019-03-29 18:36:42', '2019-04-29 18:36:42');
INSERT INTO `tb_token` VALUES ('15', '3', '9f847814-1033-418a-a082-e432ee5e4304', '2019-03-29 18:36:42', '2019-04-29 18:36:42');
INSERT INTO `tb_token` VALUES ('16', '3', '44457b42-f923-4b2b-ab33-fd335f983686', '2019-03-29 18:36:47', '2019-04-29 18:36:47');
INSERT INTO `tb_token` VALUES ('17', '3', 'd63228a2-9681-4ad1-8f59-e3128c8fa4b3', '2019-03-29 18:36:47', '2019-04-29 18:36:47');
INSERT INTO `tb_token` VALUES ('18', '3', '4fa389b6-0400-4602-af38-54307bff005f', '2019-03-29 18:37:08', '2019-04-29 18:37:08');
INSERT INTO `tb_token` VALUES ('19', '3', 'dd4554ac-9668-4eee-8599-9e1aabbf82ec', '2019-03-29 18:37:13', '2019-04-29 18:37:13');
INSERT INTO `tb_token` VALUES ('20', '3', '602c6727-e4ce-4b53-b184-1b241786cbdb', '2019-03-29 18:37:34', '2019-04-29 18:37:34');
INSERT INTO `tb_token` VALUES ('21', '3', 'd61d6b92-e674-4f26-8f39-aa69be29b767', '2019-03-29 18:37:55', '2019-04-29 18:37:55');
INSERT INTO `tb_token` VALUES ('22', '3', '3bdeea34-6a6b-47f9-adc8-30c2fc89acb0', '2019-03-29 18:37:56', '2019-04-29 18:37:56');
INSERT INTO `tb_token` VALUES ('23', '3', '371e30f1-038b-4e55-8cb9-782668d0f473', '2019-03-29 18:37:56', '2019-04-29 18:37:56');
INSERT INTO `tb_token` VALUES ('24', '3', 'eaab2c22-78ae-481c-90a6-61030a96b31a', '2019-03-29 18:37:57', '2019-04-29 18:37:57');
INSERT INTO `tb_token` VALUES ('25', '3', 'b8306bb9-22d9-49e1-8eec-b9bc7805b4fa', '2019-03-29 18:37:59', '2019-04-29 18:37:59');
INSERT INTO `tb_token` VALUES ('26', '3', 'e916f547-c191-482c-a6c9-719d11aebf4d', '2019-03-29 18:38:07', '2019-04-29 18:38:07');
INSERT INTO `tb_token` VALUES ('27', '3', '4f08e43e-6392-4b59-ad01-2bcfbaa28378', '2019-03-29 18:42:27', '2019-04-29 18:42:27');
INSERT INTO `tb_token` VALUES ('28', '3', '8d2844e0-dd45-4537-8ae7-41d041aa0002', '2019-03-29 18:43:10', '2019-04-29 18:43:10');
INSERT INTO `tb_token` VALUES ('29', '3', '079cfa68-5b53-4a5b-a8d2-5bd02b4a5723', '2019-03-29 18:43:31', '2019-04-29 18:43:31');
INSERT INTO `tb_token` VALUES ('30', '3', 'd7bbdefd-94b7-462f-a28d-82f99be6e803', '2019-03-29 18:43:32', '2019-04-29 18:43:32');
INSERT INTO `tb_token` VALUES ('31', '3', '23eafb8d-6682-460c-8df1-52a0659b1825', '2019-03-29 18:44:49', '2019-04-29 18:44:49');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT 'md5加密后的密码',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('2', 'dev', '2cb919284dc284f4994fcd064ef0542b', '2019-03-29 17:25:21', '2019-03-29 17:25:21');
INSERT INTO `tb_user` VALUES ('3', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '2019-03-29 18:25:48', '2019-03-29 18:25:48');
