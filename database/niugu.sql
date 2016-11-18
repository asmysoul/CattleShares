/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.40 : Database - niugu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`niugu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `niugu`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `admin_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(20) NOT NULL COMMENT '用户名',
  `admin_password` varchar(64) NOT NULL COMMENT '密码',
  `admin_type` int(1) NOT NULL DEFAULT '0' COMMENT '管理员类型：0.客服，1.管理员',
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`admin_id`,`admin_username`,`admin_password`,`admin_type`) values (1,'admin','1111',1),(2,'kefu','123123',0);

/*Table structure for table `gold_record` */

DROP TABLE IF EXISTS `gold_record`;

CREATE TABLE `gold_record` (
  `grid_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grd_userid` bigint(20) NOT NULL COMMENT '账户id',
  `grd_username` varchar(20) NOT NULL COMMENT '账户名称',
  `grd_profittype` int(2) NOT NULL DEFAULT '0' COMMENT '收益类型：0.邀请，1：充值 2:支出',
  `grd_time` datetime NOT NULL COMMENT '时间',
  `grd_income` float DEFAULT NULL COMMENT '收入',
  `grd_pay` float DEFAULT NULL COMMENT '支出',
  `grd_spare` float NOT NULL COMMENT '余钱',
  `grd_remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`grid_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `gold_record` */

insert  into `gold_record`(`grid_id`,`grd_userid`,`grd_username`,`grd_profittype`,`grd_time`,`grd_income`,`grd_pay`,`grd_spare`,`grd_remark`) values (1,1,'aa',2,'2016-10-27 09:31:14',100,NULL,300,'备注'),(2,2,'aa1',2,'2016-10-27 09:36:49',100,NULL,200,'备注'),(3,3,'aa2',2,'2016-10-27 09:37:57',100,NULL,200,'备注'),(4,4,'aa3',2,'2016-11-01 09:38:46',NULL,20,60,'备注');

/*Table structure for table `invite` */

DROP TABLE IF EXISTS `invite`;

CREATE TABLE `invite` (
  `invi_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `invi_username` varchar(20) NOT NULL COMMENT '发起邀请用户',
  `invi_acceptuserId` bigint(2) NOT NULL COMMENT '接受邀请人id',
  `invi_acceptuser` varchar(20) NOT NULL COMMENT '接受邀请用户',
  `invi_acceptmobile` varchar(11) NOT NULL COMMENT '接受人电话',
  `invi_registtime` date NOT NULL COMMENT '接受人注册时间',
  `invi_userstate` varchar(20) NOT NULL COMMENT '邀请人用户状态',
  `invi_gold` int(4) NOT NULL COMMENT '邀请金币',
  `invi_mark` int(4) NOT NULL COMMENT '邀请积分',
  `invi_acceptuserstate` bigint(2) NOT NULL COMMENT '受邀请人状态:：0:未开通，1:已开通，2:已过期',
  `invi_recharge` date DEFAULT NULL COMMENT '充值时间',
  PRIMARY KEY (`invi_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `invite` */

insert  into `invite`(`invi_id`,`invi_username`,`invi_acceptuserId`,`invi_acceptuser`,`invi_acceptmobile`,`invi_registtime`,`invi_userstate`,`invi_gold`,`invi_mark`,`invi_acceptuserstate`,`invi_recharge`) values (1,'zhangsan',2,'maimai','2147483647','2016-10-25','0',10,10,0,NULL),(2,'maimai',3,'lisi','2147483647','2016-10-25','0',10,10,0,NULL);

/*Table structure for table `mark_recode` */

DROP TABLE IF EXISTS `mark_recode`;

CREATE TABLE `mark_recode` (
  `mrd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mrd_userid` bigint(20) NOT NULL COMMENT '账号id',
  `mrd_username` varchar(20) NOT NULL COMMENT '账号昵称',
  `mrd_profittype` int(2) NOT NULL DEFAULT '0' COMMENT '收支类型：0：邀请，1：充值 2:支出',
  `mrd_time` datetime NOT NULL COMMENT '时间',
  `mrd_income` float DEFAULT NULL COMMENT '收入',
  `mrd_pay` float DEFAULT NULL COMMENT '支出',
  `mrd_share` float NOT NULL COMMENT '余钱',
  `mrd_remark` varchar(100) NOT NULL COMMENT '备注',
  PRIMARY KEY (`mrd_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `mark_recode` */

insert  into `mark_recode`(`mrd_id`,`mrd_userid`,`mrd_username`,`mrd_profittype`,`mrd_time`,`mrd_income`,`mrd_pay`,`mrd_share`,`mrd_remark`) values (1,1,'aa',2,'2016-10-27 09:33:39',100,NULL,300,'备注'),(2,2,'aa2',2,'2016-10-27 09:37:11',100,NULL,300,'备注'),(3,3,'aa3',2,'2016-10-27 09:38:19',100,NULL,200,'备注'),(4,4,'aa4',2,'2016-10-27 09:39:20',NULL,20,60,'备注');

/*Table structure for table `optional_stock` */

DROP TABLE IF EXISTS `optional_stock`;

CREATE TABLE `optional_stock` (
  `os_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `os_stockcode` bigint(20) NOT NULL COMMENT '股票代码',
  `os_stockname` varchar(20) NOT NULL COMMENT '股票名称',
  `os_userId` bigint(20) NOT NULL COMMENT '记录哪个用户选择',
  PRIMARY KEY (`os_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `optional_stock` */

/*Table structure for table `problem` */

DROP TABLE IF EXISTS `problem`;

CREATE TABLE `problem` (
  `pro_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pro_userquestion` varchar(500) NOT NULL COMMENT '咨询问题内参',
  `pro_technick` varchar(20) NOT NULL COMMENT '老师昵称',
  `pro_answer` varchar(500) DEFAULT NULL COMMENT '回复内容',
  `pro_createtime` date NOT NULL COMMENT '创建时间',
  `pro_questiontime` datetime NOT NULL COMMENT '提问时间',
  `pro_answertime` datetime DEFAULT NULL COMMENT '回答时间',
  `user_id` bigint(20) NOT NULL COMMENT '提问用户名字',
  PRIMARY KEY (`pro_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `problem` */

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `pur_type` int(1) NOT NULL DEFAULT '0' COMMENT '0:普通用户，1：会员',
  `pur_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pur_stockcode` bigint(20) NOT NULL,
  `pur_stockname` varchar(20) CHARACTER SET utf8 NOT NULL,
  `pur_purchasetime` datetime NOT NULL,
  `pur_stockprice` double NOT NULL,
  `pur_technick` varchar(10) CHARACTER SET utf8 NOT NULL,
  `create_time` date NOT NULL,
  `pur_issellout` int(2) NOT NULL DEFAULT '0' COMMENT '0是未卖出 ， 1是卖出',
  PRIMARY KEY (`pur_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=ucs2;

/*Data for the table `purchase` */

insert  into `purchase`(`pur_type`,`pur_id`,`pur_stockcode`,`pur_stockname`,`pur_purchasetime`,`pur_stockprice`,`pur_technick`,`create_time`,`pur_issellout`) values (1,1,600887,'伊利股份','2016-11-07 15:15:23',10.55,'张老师','2016-11-07',1),(0,2,600887,'伊利股份','2016-11-07 16:16:43',10.55,'张老师','2016-11-07',0);

/*Table structure for table `reference` */

DROP TABLE IF EXISTS `reference`;

CREATE TABLE `reference` (
  `rer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '内参id',
  `rer_shareCode` bigint(20) NOT NULL COMMENT '股票代码',
  `rer_rerInfo` varchar(200) NOT NULL COMMENT '内参消息',
  `rer_pubtime` datetime NOT NULL COMMENT '发布时间',
  `rer_stockname` varchar(20) NOT NULL COMMENT '股票公司名称',
  PRIMARY KEY (`rer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `reference` */

insert  into `reference`(`rer_id`,`rer_shareCode`,`rer_rerInfo`,`rer_pubtime`,`rer_stockname`) values (7,600887,'噶十多个还是对方过后绝地反击','2016-11-11 11:25:10','伊利股份'),(8,600887,'12312321','2016-11-10 14:06:08','伊利股份'),(9,600887,'12312321','2016-11-18 14:06:09','伊利股份'),(10,600887,'123123','2016-11-18 14:06:19','伊利股份');

/*Table structure for table `reflect_recode` */

DROP TABLE IF EXISTS `reflect_recode`;

CREATE TABLE `reflect_recode` (
  `rrd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rrd_userid` bigint(20) NOT NULL COMMENT '体现用户账号id',
  `rrd_username` varchar(20) NOT NULL COMMENT '体现用户昵称',
  `rrd_serialnum` bigint(20) NOT NULL COMMENT '体现流水号',
  `rrd_price` float NOT NULL COMMENT '体现金额',
  `rrd_applytime` datetime NOT NULL COMMENT '申请时间',
  `rrd_state` int(2) NOT NULL DEFAULT '0' COMMENT '状态：0.未处理1，已处理',
  `rrd_managetime` datetime DEFAULT NULL COMMENT '处理时间',
  PRIMARY KEY (`rrd_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `reflect_recode` */

insert  into `reflect_recode`(`rrd_id`,`rrd_userid`,`rrd_username`,`rrd_serialnum`,`rrd_price`,`rrd_applytime`,`rrd_state`,`rrd_managetime`) values (1,2,'maimai',0,10,'2016-11-18 10:28:04',0,'2016-11-18 10:28:14'),(2,3,'lisi',0,10,'2016-10-01 10:28:07',0,'2016-10-01 10:28:16');

/*Table structure for table `sellout` */

DROP TABLE IF EXISTS `sellout`;

CREATE TABLE `sellout` (
  `sell_type` int(1) NOT NULL DEFAULT '0' COMMENT '0:普通用户，1：会员',
  `sell_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sell_stockname` varchar(20) NOT NULL,
  `sell_stockcode` bigint(20) NOT NULL COMMENT '股票代码',
  `sell_selltime` datetime NOT NULL COMMENT '卖出时间',
  `sell_sellprice` float NOT NULL COMMENT '卖出价格',
  `sell_technick` varchar(20) NOT NULL COMMENT '推荐老师',
  `pur_purtime` datetime NOT NULL COMMENT '买入时间',
  `pur_purprice` double NOT NULL COMMENT '买入价格',
  `create_time` date NOT NULL,
  PRIMARY KEY (`sell_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sellout` */

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tech_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tech_nick` varchar(10) NOT NULL COMMENT '昵称',
  `tech_head` varchar(300) DEFAULT NULL COMMENT '头像',
  `tech_title` varchar(20) DEFAULT NULL COMMENT '职称',
  `tech_label` varchar(10) DEFAULT NULL COMMENT '标签',
  `tech_intro` varchar(200) DEFAULT NULL COMMENT '简介',
  `tech_mechanism` varchar(20) DEFAULT NULL COMMENT '所属机构',
  `tch_certificate` varchar(10) DEFAULT NULL COMMENT '从业资格证',
  `tech_workage` int(2) DEFAULT NULL COMMENT '从业年限',
  `tech_specialty` varchar(30) DEFAULT NULL COMMENT '特长',
  PRIMARY KEY (`tech_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`tech_id`,`tech_nick`,`tech_head`,`tech_title`,`tech_label`,`tech_intro`,`tech_mechanism`,`tch_certificate`,`tech_workage`,`tech_specialty`) values (5,'张老师','http://jzniu-test.jzniu.cn/o_1b1qid4u210r41nup18l81n291reue.png','分析师','股神','简介','所属机构 ','分析师资格证',5,'特长'),(6,'测测老师','http://jzniu-test.jzniu.cn/o_1b1qi2uvjle6jpr1b2f5q9trde.png','分析师','股神','测测老师：简介：指导股票操作','证券中心','分析师',10,'股票指导');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `grade` int(2) NOT NULL DEFAULT '0' COMMENT '0:普通用户，1:会员用户，2:合作用户',
  `register_time` date NOT NULL,
  `end_vip_time` date DEFAULT NULL,
  `vip_status` int(2) NOT NULL DEFAULT '0' COMMENT '0:未开通，1:已开通，2:已过期',
  `phone` varchar(11) NOT NULL,
  `gold` int(11) NOT NULL DEFAULT '0',
  `mark` int(11) NOT NULL DEFAULT '100',
  `account_type` int(2) DEFAULT NULL COMMENT '0:财付通，1：支付宝 2：银行',
  `reflect_account` varchar(20) DEFAULT NULL COMMENT '体现账户',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`password`,`grade`,`register_time`,`end_vip_time`,`vip_status`,`phone`,`gold`,`mark`,`account_type`,`reflect_account`) values (2,'maimai','123123',0,'2016-10-25','2016-10-25',0,'2147483647',10,10,1,'624238241@qq.com'),(3,'lisi','123123',0,'2016-10-25','2016-10-25',0,'2147483647',0,11,11,'422149193@qq.com'),(5,'mmmmmm','111111',1,'2016-11-01','2016-11-01',0,'18060191114',0,100,NULL,NULL),(6,'corn12','123123',0,'2016-11-01','2016-11-01',0,'18650809183',0,100,NULL,NULL);

/*Table structure for table `vip_record` */

DROP TABLE IF EXISTS `vip_record`;

CREATE TABLE `vip_record` (
  `vrd_userid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `vrd_username` varchar(20) NOT NULL COMMENT '账户昵称',
  `vrd_rechargetime` date NOT NULL COMMENT '充值时间',
  `vrd_rechargeprice` int(11) NOT NULL COMMENT '充值金额',
  `vrd_remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`vrd_userid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `vip_record` */

insert  into `vip_record`(`vrd_userid`,`vrd_username`,`vrd_rechargetime`,`vrd_rechargeprice`,`vrd_remark`) values (2,'maimai','2016-11-18',10,'充值');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
