/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.15-log : Database - niugu
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

/*Table structure for table `gold_record` */

DROP TABLE IF EXISTS `gold_record`;

CREATE TABLE `gold_record` (
  `grd_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `grd_username` varchar(20) NOT NULL COMMENT '账户名称',
  `grd_profittype` int(2) NOT NULL DEFAULT '0' COMMENT '收益类型：0.邀请，1：充值',
  `grd_time` datetime NOT NULL COMMENT '时间',
  `grd_income` float NOT NULL COMMENT '收入',
  `grd_pay` float NOT NULL COMMENT '支出',
  `grd_spare` float NOT NULL COMMENT '余钱',
  `grd_remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`grd_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `gold_record` */

/*Table structure for table `invite` */

DROP TABLE IF EXISTS `invite`;

CREATE TABLE `invite` (
  `invi_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `invi_username` varchar(20) NOT NULL COMMENT '发起邀请用户',
  `invi_acceptuser` varchar(20) NOT NULL COMMENT '接受邀请用户',
  `invi_acceptmobile` varchar(11) NOT NULL COMMENT '接受人电话',
  `invi_registtime` date NOT NULL COMMENT '接受人注册时间',
  `invi_userstate` varchar(20) NOT NULL COMMENT '邀请人用户状态',
  `invi_gold` int(4) NOT NULL COMMENT '邀请金币',
  `invi_mark` int(4) NOT NULL COMMENT '邀请积分',
  PRIMARY KEY (`invi_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `invite` */

/*Table structure for table `mark_recode` */

DROP TABLE IF EXISTS `mark_recode`;

CREATE TABLE `mark_recode` (
  `mrd_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账号id',
  `mrd_username` varchar(20) NOT NULL COMMENT '账号昵称',
  `mrd_profittype` int(2) NOT NULL DEFAULT '0' COMMENT '收支类型：0：邀请，1：充值',
  `mrd_time` datetime NOT NULL COMMENT '时间',
  `mrd_income` float NOT NULL COMMENT '收入',
  `mrd_pay` float NOT NULL COMMENT '支出',
  `mrd_share` float NOT NULL COMMENT '余钱',
  `mrd_remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`mrd_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `mark_recode` */

/*Table structure for table `problem` */

DROP TABLE IF EXISTS `problem`;

CREATE TABLE `problem` (
  `pro_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pro_techid` bigint(10) NOT NULL COMMENT '询问老师id',
  `pro_userquestion` varchar(100) NOT NULL COMMENT '咨询问题内参',
  `pro_technick` varchar(20) NOT NULL COMMENT '老师昵称',
  `pro_answer` varchar(100) NOT NULL COMMENT '回复内容',
  `pro_createtime` date NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`pro_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `problem` */

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `pur_type` int(1) NOT NULL DEFAULT '0' COMMENT '0:普通用户，1：会员',
  `pur_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pur_stockcode` int(10) NOT NULL,
  `pur_stockname` varchar(20) CHARACTER SET utf8 NOT NULL,
  `pur_purchasetime` datetime NOT NULL,
  `pur_stockprice` float NOT NULL,
  `pur_technick` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`pur_id`)
) ENGINE=MyISAM DEFAULT CHARSET=ucs2;

/*Data for the table `purchase` */

/*Table structure for table `reflect_recode` */

DROP TABLE IF EXISTS `reflect_recode`;

CREATE TABLE `reflect_recode` (
  `rrd_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '体现用户账号id',
  `rrd_username` varchar(20) NOT NULL COMMENT '体现用户昵称',
  `rrd_serialnum` bigint(20) NOT NULL COMMENT '体现流水号',
  `rrd_price` float NOT NULL COMMENT '体现金额',
  `rrd_applytime` datetime NOT NULL COMMENT '申请时间',
  `rrd_state` int(2) NOT NULL COMMENT '状态：0.未处理1，已处理',
  `rrd_managetime` datetime NOT NULL COMMENT '处理时间',
  PRIMARY KEY (`rrd_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `reflect_recode` */

/*Table structure for table `sellout` */

DROP TABLE IF EXISTS `sellout`;

CREATE TABLE `sellout` (
  `sell_type` int(1) NOT NULL DEFAULT '0' COMMENT '0:普通用户，1：会员',
  `sell_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sell_stockcode` varchar(20) NOT NULL COMMENT '股票代码',
  `sell_selltime` date NOT NULL COMMENT '卖出时间',
  `sell_sellprice` float NOT NULL COMMENT '卖出价格',
  `sell_technick` varchar(20) NOT NULL COMMENT '推荐老师',
  `pur_purtime` date NOT NULL COMMENT '买入时间',
  `pur_purprice` float NOT NULL COMMENT '买入价格',
  PRIMARY KEY (`sell_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sellout` */

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tech_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tech_nick` varchar(10) NOT NULL COMMENT '昵称',
  `tech_head` varchar(50) DEFAULT NULL COMMENT '头像',
  `tech_title` varchar(20) DEFAULT NULL COMMENT '职称',
  `tech_label` varchar(10) DEFAULT NULL COMMENT '标签',
  `tech_intro` varchar(200) DEFAULT NULL COMMENT '简介',
  `tech_mechanism` varchar(20) DEFAULT NULL COMMENT '所属机构',
  `tch_certificate` varchar(10) DEFAULT NULL COMMENT '从业资格证',
  `tech_workage` int(2) DEFAULT NULL COMMENT '从业年限',
  `tech_specialty` varchar(30) DEFAULT NULL COMMENT '特长',
  PRIMARY KEY (`tech_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `grade` int(2) NOT NULL DEFAULT '0' COMMENT '0:普通用户，1:会员用户，2:合作用户',
  `register_time` date NOT NULL,
  `end_vip_time` date NOT NULL,
  `vip_status` int(2) DEFAULT '0' COMMENT '0:未开通，1:已开通，2:已过期',
  `phone` varchar(11) NOT NULL,
  `gold` int(11) DEFAULT '0',
  `mark` int(11) DEFAULT NULL,
  `account_type` int(2) DEFAULT NULL COMMENT '0:财付通，1：支付宝 2：银行',
  `reflect_account` varchar(20) DEFAULT NULL COMMENT '体现账户',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*Table structure for table `vip_record` */

DROP TABLE IF EXISTS `vip_record`;

CREATE TABLE `vip_record` (
  `vrd_userid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `vrd_username` varchar(20) NOT NULL COMMENT '账户昵称',
  `vrd_rechargetime` date NOT NULL COMMENT '充值时间',
  `vrd_rechargeprice` int(11) NOT NULL COMMENT '充值金额',
  `vrd_remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`vrd_userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `vip_record` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
