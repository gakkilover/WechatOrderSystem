/*
Navicat MySQL Data Transfer

Source Server         : zwk
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : order_system

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-01-08 15:55:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attache_pic
-- ----------------------------
DROP TABLE IF EXISTS `attache_pic`;
CREATE TABLE `attache_pic` (
  `attache_id` bigint(30) NOT NULL,
  `attache_name` varchar(30) DEFAULT NULL,
  `attache_address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`attache_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attache_pic
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` bigint(30) NOT NULL,
  `user_id` bigint(30) DEFAULT NULL,
  `comment_discreption` varchar(100) DEFAULT NULL,
  `comment_date` datetime DEFAULT NULL,
  `comment_level` int(5) DEFAULT NULL,
  `status_cd` varchar(10) DEFAULT NULL,
  `food_id` bigint(30) DEFAULT NULL,
  `store_id` bigint(30) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for expenditure
-- ----------------------------
DROP TABLE IF EXISTS `expenditure`;
CREATE TABLE `expenditure` (
  `expenditure_id` bigint(100) NOT NULL,
  `order_number` varchar(32) DEFAULT NULL,
  `money` decimal(20,2) DEFAULT NULL,
  `payee` varchar(30) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `user_id` bigint(100) DEFAULT NULL,
  PRIMARY KEY (`expenditure_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expenditure
-- ----------------------------

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `food_id` bigint(100) NOT NULL,
  `food_name` varchar(100) DEFAULT NULL,
  `food_price` float DEFAULT NULL,
  `food_pic` varchar(100) DEFAULT NULL,
  `food_major` varchar(200) DEFAULT NULL,
  `food_minor` varchar(200) DEFAULT NULL,
  `food_hunsu` varchar(100) DEFAULT NULL,
  `food_method` longtext,
  `food_taste` varchar(100) DEFAULT NULL,
  `food_character` varchar(200) DEFAULT NULL,
  `food_sales` int(11) DEFAULT NULL,
  `food_state` char(1) DEFAULT NULL,
  `store_id` bigint(100) DEFAULT NULL,
  `food_detail` longtext,
  `genre_id` bigint(30) DEFAULT NULL,
  `food_num` bigint(30) DEFAULT NULL,
  PRIMARY KEY (`food_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('2', '红烧狮子头', '35.9', 'lion.jpg', null, null, null, null, null, null, '0', '\0', '1', '是真的狮子头', '3', '0');
INSERT INTO `food` VALUES ('3', '酸辣土豆丝', '12.9', 'photao.jpg', null, null, null, null, null, null, '0', '\0', '1', '爆炒土豆丝', '2', '0');
INSERT INTO `food` VALUES ('4', '小米粥', '6.9', 'xiaomi.jpg', null, null, null, null, null, null, '0', '\0', '1', '好喝', '5', '0');
INSERT INTO `food` VALUES ('5', '烤兄弟', '199.9', '912333d7ab45473e8c05d694d6a4c10b.jpg', null, null, null, null, null, null, '0', '\0', '1', '无', '3', '0');
INSERT INTO `food` VALUES ('6', '米饭', '2.5', '62433a14cd5d4bd789af8ffb510867ec.jpg', null, null, null, null, null, null, '0', '\0', '1', '管饱', '8', '0');
INSERT INTO `food` VALUES ('7', '鸡排', '9.99', 'c7b5f6769afa45c0a6e406bb451d17dd.jpg', null, null, null, null, null, null, '0', '\0', '1', '纯地沟油', '7', '0');
INSERT INTO `food` VALUES ('8', '番茄炒鸡蛋', '32.9', '514dcbeee8644816b163ea8b987f1ab6.jpg', null, null, null, null, null, null, '0', '\0', '1', '发热', '3', '0');

-- ----------------------------
-- Table structure for genre
-- ----------------------------
DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre` (
  `genre_id` bigint(30) NOT NULL AUTO_INCREMENT,
  `genre_name` varchar(50) DEFAULT NULL,
  `genre_state` varchar(10) DEFAULT NULL,
  `store_id` bigint(30) DEFAULT NULL,
  `genre_description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of genre
-- ----------------------------
INSERT INTO `genre` VALUES ('2', '凉菜', '1000', '1', '诸如小葱拌小葱');
INSERT INTO `genre` VALUES ('3', '热菜', '1000', '1', '非常热的');
INSERT INTO `genre` VALUES ('5', '粥', '1000', '1', '没错粥');
INSERT INTO `genre` VALUES ('6', '饮料', '1000', '1', '喝的甜水');
INSERT INTO `genre` VALUES ('7', '小食', '1000', '1', '哈哈哈哈');
INSERT INTO `genre` VALUES ('8', '主食', '1000', '1', '饱腹');

-- ----------------------------
-- Table structure for my_collect
-- ----------------------------
DROP TABLE IF EXISTS `my_collect`;
CREATE TABLE `my_collect` (
  `col_id` bigint(100) NOT NULL,
  `user_id` bigint(100) DEFAULT NULL,
  `food_id` bigint(100) DEFAULT NULL,
  `store_id` bigint(100) DEFAULT NULL,
  `col_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`col_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of my_collect
-- ----------------------------

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `order_id` bigint(100) NOT NULL AUTO_INCREMENT,
  `order_number` bigint(32) DEFAULT NULL,
  `user_id` bigint(100) DEFAULT NULL,
  `total_price` float(255,2) DEFAULT NULL,
  `status` varchar(30) DEFAULT '1101',
  `store_id` bigint(100) DEFAULT NULL,
  `store_name` varchar(50) DEFAULT NULL,
  `is_packed` varchar(1) DEFAULT '1',
  `pack_cost` float(10,2) DEFAULT NULL,
  `is_delivery` varchar(1) DEFAULT NULL,
  `delivery_mode` varchar(255) DEFAULT NULL,
  `delivery_cost` float(10,2) DEFAULT NULL,
  `pay_mode` varchar(255) DEFAULT NULL,
  `pay_type` varchar(20) DEFAULT NULL,
  `store_order_id` bigint(32) DEFAULT NULL,
  `table_number` varchar(100) DEFAULT NULL,
  `table_name` varchar(100) DEFAULT NULL,
  `order_description` varchar(255) DEFAULT NULL,
  `covers_number` bigint(30) DEFAULT NULL,
  `address_id` bigint(30) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('23', '2019010619550001', '1', '46.50', '1105', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('24', '2019010638320001', '1', '85.20', '1104', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('25', '2019010624030001', '1', '33.60', '1106', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('26', '2019010624230002', '1', '85.20', '1103', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('27', '2019010624400003', '1', '130.80', '1100', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('28', '2019010625020004', '1', '530.60', '1106', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('29', '2019010711510001', '1', '530.60', '1100', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('30', '2019010721530002', '1', '537.50', '1101', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('31', '2019010742100003', '1', '537.50', '1101', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('32', '2019010743580004', '1', '937.30', '1100', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('33', '2019010708260001', '1', '27.60', '1100', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('34', '2019010709130002', '1', '40.50', '1100', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('35', '2019010709480001', '1', '143.60', '1100', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('36', '2019010711020002', '1', '61.70', '1100', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('37', '2019010756030001', '1', '48.80', '1100', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('38', '2019010756350002', '1', '0.00', '1101', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');
INSERT INTO `orderinfo` VALUES ('39', '2019010829190001', '1', '320.50', '1101', '1', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '1');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_detail_id` bigint(100) NOT NULL AUTO_INCREMENT,
  `food_name` varchar(30) DEFAULT NULL,
  `food_id` bigint(100) DEFAULT NULL,
  `price` float(10,2) NOT NULL,
  `food_num` bigint(20) DEFAULT NULL,
  `food_price` float(10,2) DEFAULT NULL,
  `food_pic` varchar(50) DEFAULT NULL,
  `order_id` bigint(100) DEFAULT NULL,
  `order_number` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('42', '酸辣土豆丝', '3', '0.00', '2', '12.90', 'photao.jpg', '23', null);
INSERT INTO `order_detail` VALUES ('43', '小米粥', '4', '0.00', '3', '6.90', 'xiaomi.jpg', '23', null);
INSERT INTO `order_detail` VALUES ('44', '酸辣土豆丝', '3', '0.00', '5', '12.90', 'photao.jpg', '24', null);
INSERT INTO `order_detail` VALUES ('45', '小米粥', '4', '0.00', '3', '6.90', 'xiaomi.jpg', '24', null);
INSERT INTO `order_detail` VALUES ('46', '酸辣土豆丝', '3', '0.00', '1', '12.90', 'photao.jpg', '25', null);
INSERT INTO `order_detail` VALUES ('47', '小米粥', '4', '0.00', '3', '6.90', 'xiaomi.jpg', '25', null);
INSERT INTO `order_detail` VALUES ('48', '酸辣土豆丝', '3', '0.00', '5', '12.90', 'photao.jpg', '26', null);
INSERT INTO `order_detail` VALUES ('49', '小米粥', '4', '0.00', '3', '6.90', 'xiaomi.jpg', '26', null);
INSERT INTO `order_detail` VALUES ('50', '酸辣土豆丝', '3', '0.00', '8', '12.90', 'photao.jpg', '27', null);
INSERT INTO `order_detail` VALUES ('51', '小米粥', '4', '0.00', '4', '6.90', 'xiaomi.jpg', '27', null);
INSERT INTO `order_detail` VALUES ('52', '酸辣土豆丝', '3', '0.00', '8', '12.90', 'photao.jpg', '28', null);
INSERT INTO `order_detail` VALUES ('53', '小米粥', '4', '0.00', '4', '6.90', 'xiaomi.jpg', '28', null);
INSERT INTO `order_detail` VALUES ('54', '烤兄弟', '5', '0.00', '2', '199.90', '912333d7ab45473e8c05d694d6a4c10b.jpg', '28', null);
INSERT INTO `order_detail` VALUES ('55', '酸辣土豆丝', '3', '0.00', '8', '12.90', 'photao.jpg', '29', null);
INSERT INTO `order_detail` VALUES ('56', '小米粥', '4', '0.00', '4', '6.90', 'xiaomi.jpg', '29', null);
INSERT INTO `order_detail` VALUES ('57', '烤兄弟', '5', '0.00', '2', '199.90', '912333d7ab45473e8c05d694d6a4c10b.jpg', '29', null);
INSERT INTO `order_detail` VALUES ('58', '酸辣土豆丝', '3', '0.00', '8', '12.90', 'photao.jpg', '30', null);
INSERT INTO `order_detail` VALUES ('59', '小米粥', '4', '0.00', '5', '6.90', 'xiaomi.jpg', '30', null);
INSERT INTO `order_detail` VALUES ('60', '烤兄弟', '5', '0.00', '2', '199.90', '912333d7ab45473e8c05d694d6a4c10b.jpg', '30', null);
INSERT INTO `order_detail` VALUES ('61', '酸辣土豆丝', '3', '0.00', '8', '12.90', 'photao.jpg', '31', null);
INSERT INTO `order_detail` VALUES ('62', '小米粥', '4', '0.00', '5', '6.90', 'xiaomi.jpg', '31', null);
INSERT INTO `order_detail` VALUES ('63', '烤兄弟', '5', '0.00', '2', '199.90', '912333d7ab45473e8c05d694d6a4c10b.jpg', '31', null);
INSERT INTO `order_detail` VALUES ('64', '酸辣土豆丝', '3', '0.00', '8', '12.90', 'photao.jpg', '32', null);
INSERT INTO `order_detail` VALUES ('65', '小米粥', '4', '0.00', '5', '6.90', 'xiaomi.jpg', '32', null);
INSERT INTO `order_detail` VALUES ('66', '烤兄弟', '5', '0.00', '4', '199.90', '912333d7ab45473e8c05d694d6a4c10b.jpg', '32', null);
INSERT INTO `order_detail` VALUES ('67', '小米粥', '4', '0.00', '4', '6.90', 'xiaomi.jpg', '33', null);
INSERT INTO `order_detail` VALUES ('68', '小米粥', '4', '0.00', '4', '6.90', 'xiaomi.jpg', '34', null);
INSERT INTO `order_detail` VALUES ('69', '酸辣土豆丝', '3', '0.00', '1', '12.90', 'photao.jpg', '34', null);
INSERT INTO `order_detail` VALUES ('70', '红烧狮子头', '2', '0.00', '4', '35.90', 'lion.jpg', '35', null);
INSERT INTO `order_detail` VALUES ('71', '酸辣土豆丝', '3', '0.00', '2', '12.90', 'photao.jpg', '36', null);
INSERT INTO `order_detail` VALUES ('72', '红烧狮子头', '2', '0.00', '1', '35.90', 'lion.jpg', '36', null);
INSERT INTO `order_detail` VALUES ('73', '红烧狮子头', '2', '0.00', '1', '35.90', 'lion.jpg', '37', null);
INSERT INTO `order_detail` VALUES ('74', '酸辣土豆丝', '3', '0.00', '1', '12.90', 'photao.jpg', '37', null);
INSERT INTO `order_detail` VALUES ('75', '红烧狮子头', '2', '0.00', '3', '35.90', 'lion.jpg', '39', null);
INSERT INTO `order_detail` VALUES ('76', '酸辣土豆丝', '3', '0.00', '1', '12.90', 'photao.jpg', '39', null);
INSERT INTO `order_detail` VALUES ('77', '烤兄弟', '5', '0.00', '1', '199.90', '912333d7ab45473e8c05d694d6a4c10b.jpg', '39', null);

-- ----------------------------
-- Table structure for order_table
-- ----------------------------
DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table` (
  `table_id` bigint(10) NOT NULL,
  `table_number` bigint(10) DEFAULT NULL,
  `max_number` int(10) DEFAULT NULL,
  `second_code` varchar(30) DEFAULT NULL,
  `idle_state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_table
-- ----------------------------

-- ----------------------------
-- Table structure for receive_address
-- ----------------------------
DROP TABLE IF EXISTS `receive_address`;
CREATE TABLE `receive_address` (
  `address_id` bigint(100) NOT NULL,
  `receiver` varchar(30) DEFAULT NULL,
  `receiver_phone` char(11) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `county` varchar(50) DEFAULT NULL,
  `village` varchar(50) DEFAULT NULL,
  `community` varchar(50) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `complete_address` varchar(200) DEFAULT NULL,
  `user_id` bigint(100) DEFAULT NULL,
  `default_address` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of receive_address
-- ----------------------------
INSERT INTO `receive_address` VALUES ('1', 'limign', '179846816', '山东省', '烟台', '莱山区', null, null, '英魂大街', '烟台市芝罘区莱山区30号7路', '1', '1');
INSERT INTO `receive_address` VALUES ('2', 'Rock', '1564896578', '北京市', '北京市', '海淀区', null, null, '永泰庄', '北京市海淀区莱山区街道307号', '1', '1');
INSERT INTO `receive_address` VALUES ('3', 'limign', '179846816', '山东省', '烟台', '莱山区', null, null, '英魂大街', '烟台市芝罘区莱山区30号7路', '1', '1');
INSERT INTO `receive_address` VALUES ('4', 'limign', '179846816', '海南', '中南海', '莱山区', null, null, '英魂大街', '烟台市芝罘区莱山区30号7路', '1', '1');
INSERT INTO `receive_address` VALUES ('5', 'limign', '179846816', '山东省', '烟台', '莱山区', null, null, '英魂大街', '烟台市芝罘区莱山区30号7路', '1', '1');
INSERT INTO `receive_address` VALUES ('6', '汤姆克鲁斯', '17853533333', '北京市', '北京市', '东城区', null, null, null, '亚伯特', '1', '0');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `store_id` bigint(30) NOT NULL,
  `store_name` varchar(100) DEFAULT NULL,
  `store_pic` varchar(30) DEFAULT NULL,
  `store_background` varchar(30) DEFAULT NULL,
  `store_nickname` varchar(30) DEFAULT NULL,
  `store_summary` varchar(100) DEFAULT NULL,
  `store_corporation` varchar(30) DEFAULT NULL,
  `store_tel` varchar(30) DEFAULT NULL,
  `social_credit_code` varchar(50) DEFAULT NULL,
  `store_second_code` varchar(30) DEFAULT NULL,
  `store_state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', 'liming', 'gre', 'gre', 'gre', 'gre', 'gre', 'gre', 'greg', 'gre', 'hy');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(30) NOT NULL,
  `nick_name` varchar(30) DEFAULT NULL,
  `user_sex` varchar(10) DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL,
  `status_cd` varchar(10) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `user_password` varchar(100) DEFAULT NULL,
  `wechat_id` varchar(100) DEFAULT NULL,
  `user_pic` varchar(20) DEFAULT NULL,
  `pay_password` varchar(30) DEFAULT NULL,
  `user_salt` varchar(30) DEFAULT NULL,
  `user_tel` varchar(50) DEFAULT NULL,
  UNIQUE KEY `user_id` (`user_id`) USING HASH,
  UNIQUE KEY `nick_name` (`nick_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'kk', 'f', '2018-12-28', '北京市朝阳区大悦城', '1000', 'zwk1', '8178CA0AE397FD00484EC0BB921C5BE4', 'xkk', 'nici.jpg', '111111', '1478935', null);
INSERT INTO `user` VALUES ('2', 'test', 'w', '2018-12-28', '北京市朝阳区大悦城', '1000', 'zwk', '5A2E54EE57E5B7273B9A8FED78C1EBD8', 'xkk', 'nici.jpg', '111111', null, '17853538831');
INSERT INTO `user` VALUES ('3', '烟台', 'w', '2018-12-29', '北京市朝阳区大悦城', '1000', 'zwk', 'E017127705A2CA614C0C248C31B4784E', 'xkk', 'nici.jpg', '111111', null, '17853538168');
INSERT INTO `user` VALUES ('4', 'number', '男', '2019-01-07', '北京市朝阳区大悦城', '1000', 'zwk', 'F31813E2131200936CF54234DB95808D', 'xkk', 'nici.jpg', '111111', null, '17853538168');
