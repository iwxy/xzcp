/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : xzc

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-12-04 13:12:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(20) NOT NULL,
  `class_name` varchar(255) NOT NULL,
  `class_teacher` int(20) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('0', '无班级', '0');
INSERT INTO `class` VALUES ('1547', '15软件工程1班', '16478802');
INSERT INTO `class` VALUES ('1647', '16软件工程1班', '16478802');
INSERT INTO `class` VALUES ('1747', '17软件工程2班', '16478803');

-- ----------------------------
-- Table structure for credit
-- ----------------------------
DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit` (
  `credit_id` int(20) NOT NULL,
  `credit_studentid` int(20) NOT NULL,
  `credit_discribe` varchar(255) DEFAULT NULL,
  `credit_term` char(20) NOT NULL,
  `credit_type` char(20) NOT NULL,
  PRIMARY KEY (`credit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of credit
-- ----------------------------
INSERT INTO `credit` VALUES ('1', '16478004', '在本学期中表现良好', '第一学年', '优秀');

-- ----------------------------
-- Table structure for identity
-- ----------------------------
DROP TABLE IF EXISTS `identity`;
CREATE TABLE `identity` (
  `identity_id` int(11) NOT NULL,
  `identity_name` varchar(255) NOT NULL,
  PRIMARY KEY (`identity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of identity
-- ----------------------------
INSERT INTO `identity` VALUES ('1', '书记');
INSERT INTO `identity` VALUES ('2', '班主任');
INSERT INTO `identity` VALUES ('3', '学生');
INSERT INTO `identity` VALUES ('4', '班长');
INSERT INTO `identity` VALUES ('5', '副班长');
INSERT INTO `identity` VALUES ('6', '劳动委员');
INSERT INTO `identity` VALUES ('7', '寝工委员');
INSERT INTO `identity` VALUES ('8', '团支书');
INSERT INTO `identity` VALUES ('9', '宣传委员');
INSERT INTO `identity` VALUES ('10', '心理委员');
INSERT INTO `identity` VALUES ('11', '体育委员');
INSERT INTO `identity` VALUES ('12', '组织委员');
INSERT INTO `identity` VALUES ('13', '文艺委员');
INSERT INTO `identity` VALUES ('14', '寝室长');
INSERT INTO `identity` VALUES ('15', '学习委员');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` int(11) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_discribe` varchar(255) DEFAULT NULL,
  `item_committeeid` int(20) DEFAULT NULL,
  `item_score` double NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '上课迟到', '白天和晚自习一样', '5', '-0.5');
INSERT INTO `item` VALUES ('2', '上课早退', '白天和晚自习一样', '5', '-0.5');
INSERT INTO `item` VALUES ('3', '白天旷课', '旷课扣分', '5', '-2');
INSERT INTO `item` VALUES ('4', '晚自习旷课', '旷课扣分', '5', '-2');
INSERT INTO `item` VALUES ('5', '教室卫生得好', '值日人员加分', '6', '2');
INSERT INTO `item` VALUES ('6', '教师卫生得差', '值日人员减分', '6', '-5');
INSERT INTO `item` VALUES ('7', '教师打扫人员不负责', '值日人员减分', '6', '-2');
INSERT INTO `item` VALUES ('8', '校检查寝室卫生得好', '校检查得好，全寝人员加分', '7', '2');
INSERT INTO `item` VALUES ('9', '校检查寝室卫生得差', '校检查得差，全寝人员扣分', '7', '-5');
INSERT INTO `item` VALUES ('10', '校检查未叠被子', '校检查', '7', '-2');
INSERT INTO `item` VALUES ('11', '院检查得好', '得好的寝室全寝加分', '7', '1');
INSERT INTO `item` VALUES ('12', '院检查得差', '得好的寝室全寝扣分', '7', '-3');
INSERT INTO `item` VALUES ('13', '晚归', '系或校检查到晚归扣分', '7', '-5');
INSERT INTO `item` VALUES ('14', '在外租房', '无故在外租房扣分', '7', '-12');
INSERT INTO `item` VALUES ('15', '大功率', '校检查和院检查都算', '7', '-5');
INSERT INTO `item` VALUES ('16', '不配合干部工作', '提醒后仍然不改', '7', '-5');
INSERT INTO `item` VALUES ('17', '寝室被评为差寝或通报批评', '找该寝室的班长或寝工委员扣分', '7', '-3');
INSERT INTO `item` VALUES ('18', '积极完成团委线上工作', '积极配合者加分', '8', '0.2');
INSERT INTO `item` VALUES ('19', '不积极完成团委线上工作', '不积极配合着扣分', '8', '-0.5');
INSERT INTO `item` VALUES ('20', '参加学校各项团学活动', '按要求完成者加分', '8', '2');
INSERT INTO `item` VALUES ('21', '团学全体活动缺勤', '缺勤者扣分', '8', '-1');
INSERT INTO `item` VALUES ('22', '完成文学稿', '按要求完成文学稿加分', '9', '1');
INSERT INTO `item` VALUES ('23', '未完成文学稿', '不交文学稿扣分', '9', '-1');
INSERT INTO `item` VALUES ('24', '完成心理稿', '按要求完成心理稿', '10', '1');
INSERT INTO `item` VALUES ('25', '未完成心理稿', '不交心理稿扣分', '10', '-1');
INSERT INTO `item` VALUES ('26', '参加阳光体育活动', '按时、按要求参加阳光体育活动加分', '11', '0.2');
INSERT INTO `item` VALUES ('27', '未参加阳光体育活动', '缺勤阳光体育活动扣分', '11', '-0.5');
INSERT INTO `item` VALUES ('28', '参加升旗仪式', '按时、按要求参加', '5', '2');
INSERT INTO `item` VALUES ('29', '未参加升旗仪式', '不参加者扣分', '5', '-5');
INSERT INTO `item` VALUES ('30', '参加学院各类学术讲座', '积极参加者加分', '4', '0.5');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` int(30) NOT NULL,
  `record_committeeid` int(20) NOT NULL,
  `record_studentid` int(20) NOT NULL,
  `record_itemid` int(11) NOT NULL,
  `record_times` int(11) NOT NULL,
  `record_discribe` varchar(255) DEFAULT NULL,
  `record_date` date NOT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1678001', '16478004', '3', '1', '白天旷课', '2019-11-04');
INSERT INTO `record` VALUES ('2', '16478001', '16478004', '1', '2', '一二节上课迟到', '2019-11-27');
INSERT INTO `record` VALUES ('3', '16478001', '16478004', '2', '1', '三四节课早退', '2019-11-21');
INSERT INTO `record` VALUES ('4', '16478001', '16478004', '4', '1', '无', '2019-10-29');
INSERT INTO `record` VALUES ('5', '16478001', '16478002', '3', '2', '故意旷课', '2019-11-22');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(20) NOT NULL,
  `score_studentid` int(20) NOT NULL,
  `score_score` double(11,1) NOT NULL,
  `score_date` date NOT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '16478004', '-3.5', '2019-11-01');
INSERT INTO `score` VALUES ('2', '16478004', '-2.0', '2019-10-01');
INSERT INTO `score` VALUES ('3', '16478002', '-4.0', '2019-11-01');

-- ----------------------------
-- Table structure for termscore
-- ----------------------------
DROP TABLE IF EXISTS `termscore`;
CREATE TABLE `termscore` (
  `termscore_id` int(20) NOT NULL,
  `termscore_studentid` int(20) DEFAULT NULL,
  `termscore_score` double(11,1) DEFAULT NULL,
  `tremscore_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`termscore_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of termscore
-- ----------------------------
INSERT INTO `termscore` VALUES ('1', '16478004', '44.5', '2019-2020第一学期');
INSERT INTO `termscore` VALUES ('2', '16478004', '53.5', '2018-2019第二学期');
INSERT INTO `termscore` VALUES ('3', '16478002', '46.0', '2019-2020第一学期');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_sex` varchar(2) DEFAULT NULL,
  `user_classid` int(20) NOT NULL,
  `user_identity` int(11) DEFAULT NULL,
  `user_dormitory` varchar(50) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17478011 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('15478001', '翁梦倩', '123456', '女', '1547', '3', '13-103', '18352468953', '北京市,北京市,朝阳区,萍乡学院');
INSERT INTO `user` VALUES ('15478002', '丁要男', '123456', '男', '1547', '2', '6-501', '18356478501', '北京市,北京市,朝阳区,萍乡学院');
INSERT INTO `user` VALUES ('16478001', '金咏琪', '123456', '女', '1647', '5', '13-204', '18360457805', '北京市,北京市,朝阳区,萍乡学院');
INSERT INTO `user` VALUES ('16478002', '陈洪特', '123456', '男', '1647', '6', '12-210', '16548752460', '北京市,北京市,朝阳区,萍乡学院');
INSERT INTO `user` VALUES ('16478004', '王欣妍', '123456', '女', '1647', '3', '13-203', '18279994742', '河北省,唐山市,路北区,萍乡学院');
INSERT INTO `user` VALUES ('16478801', '彭书记', '123456', '男', '0', '1', '0', '13780563245', '山西省,长治市,屯留县,萍乡学院');
INSERT INTO `user` VALUES ('16478802', '彭新平', '123456', '男', '0', '2', '0', '13654206359', '北京市,北京市,朝阳区,萍乡学院');
INSERT INTO `user` VALUES ('16478803', '罗晓娟', '123456', '女', '0', '2', '0', '18352469235', '北京市,北京市,朝阳区,萍乡学院');
INSERT INTO `user` VALUES ('17478006', '许佳琪', '123456', '女', '1747', '4', '13-208', '15632847853', '北京市,北京市,朝阳区,萍乡学院');
INSERT INTO `user` VALUES ('17478010', '叶伟伟', '123456', '男', '1747', '8', '7-305', '18365420867', '北京市,北京市,朝阳区,萍乡学院');
