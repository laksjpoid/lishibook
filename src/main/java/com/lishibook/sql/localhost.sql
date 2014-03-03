-- phpMyAdmin SQL Dump
-- version 4.0.5
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 03 月 03 日 12:56
-- 服务器版本: 5.5.27
-- PHP 版本: 5.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `django_test`
--
--
-- 数据库: `lishi`
--

-- --------------------------------------------------------

--
-- 表的结构 `pictures`
--

CREATE TABLE IF NOT EXISTS `pictures` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rid` int(10) unsigned NOT NULL,
  `uid` int(10) unsigned NOT NULL,
  `filename` varchar(100) NOT NULL,
  `path` varchar(255) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `views` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `resource`
--

CREATE TABLE IF NOT EXISTS `resource` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(160) NOT NULL,
  `description` varchar(400) DEFAULT NULL,
  `content` text NOT NULL,
  `creatorid` int(10) unsigned NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lasteditid` int(10) unsigned NOT NULL,
  `lastedittime` timestamp NULL DEFAULT NULL,
  `views` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `resource_focosgroup`
--

CREATE TABLE IF NOT EXISTS `resource_focosgroup` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rid` int(10) unsigned NOT NULL,
  `name` varchar(160) NOT NULL,
  `desc` varchar(400) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `resource_focus`
--

CREATE TABLE IF NOT EXISTS `resource_focus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromrid` int(10) unsigned NOT NULL,
  `torid` int(10) unsigned NOT NULL,
  `groupid` int(10) unsigned DEFAULT NULL,
  `desc` varchar(400) NOT NULL COMMENT 'relationship description',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `resource_topic`
--

CREATE TABLE IF NOT EXISTS `resource_topic` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rid` int(10) unsigned NOT NULL,
  `title` varchar(160) NOT NULL,
  `content` text NOT NULL,
  `authorid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastedit` timestamp NULL DEFAULT NULL,
  `views` int(10) unsigned NOT NULL DEFAULT '0',
  `replys` int(10) unsigned NOT NULL DEFAULT '0',
  `like` int(10) unsigned NOT NULL DEFAULT '0',
  `hate` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `resource_topic_reply`
--

CREATE TABLE IF NOT EXISTS `resource_topic_reply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tid` int(10) unsigned NOT NULL,
  `content` text NOT NULL,
  `authorid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL COMMENT '姓名',
  `password` char(32) NOT NULL,
  `gender` int(11) DEFAULT '0' COMMENT '0未知1男2女',
  `birthday` int(11) DEFAULT NULL,
  `iconid` int(11) DEFAULT NULL,
  `regip` varchar(15) DEFAULT NULL,
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastip` varchar(15) DEFAULT NULL,
  `lasttime` timestamp NULL DEFAULT NULL,
  `truename` varchar(50) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `admin` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '1-管理员',
  `topics` int(10) unsigned NOT NULL DEFAULT '0',
  `collection` int(10) unsigned NOT NULL DEFAULT '0',
  `focususers` int(11) NOT NULL DEFAULT '0',
  `befocused` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '被关注次数',
  `checkup` int(11) NOT NULL DEFAULT '0' COMMENT '1-已审核 0-未审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user_collections`
--

CREATE TABLE IF NOT EXISTS `user_collections` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(10) unsigned NOT NULL,
  `rid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user_link`
--

CREATE TABLE IF NOT EXISTS `user_link` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fromuid` int(10) unsigned NOT NULL,
  `touid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;
--
-- 数据库: `lishibook`
--

-- --------------------------------------------------------

--
-- 表的结构 `album_picture`
--

CREATE TABLE IF NOT EXISTS `album_picture` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `resourcealbumid` int(10) unsigned DEFAULT NULL,
  `useralbumid` int(10) unsigned DEFAULT NULL,
  `visible` int(3) unsigned NOT NULL DEFAULT '1',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `filename` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `filetype` char(50) NOT NULL,
  `filesize` int(11) NOT NULL DEFAULT '0',
  `path` varchar(255) DEFAULT NULL,
  `downloads` int(10) unsigned NOT NULL DEFAULT '0',
  `uid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `album_picture`
--

INSERT INTO `album_picture` (`id`, `resourcealbumid`, `useralbumid`, `visible`, `time`, `filename`, `description`, `filetype`, `filesize`, `path`, `downloads`, `uid`) VALUES
(1, 0, 0, 1, '2014-01-19 09:03:09', 'abc.jpeg', 'my description', 'jpeg', 789, 'hh', 0, 1),
(2, NULL, NULL, 1, '2014-01-19 09:03:13', 'abc.jpeg', 'my first picture', 'jpeg', 789, 'hh', 0, 1),
(3, 0, 0, 1, '2014-01-19 09:36:31', 'helloworld', NULL, 'jpeg', 0, NULL, 0, 0),
(4, 0, 0, 1, '2014-01-20 10:43:32', 'helloworld', NULL, 'jpeg', 0, NULL, 0, 0),
(5, NULL, NULL, 1, '2014-01-20 13:40:39', 'helloworld', NULL, 'jpeg', 0, NULL, 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `album_resource`
--

CREATE TABLE IF NOT EXISTS `album_resource` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `resourceid` int(10) unsigned NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `views` int(10) unsigned NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastedit` timestamp NULL DEFAULT NULL,
  `lastupload` timestamp NULL DEFAULT NULL,
  `creatorid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `album_user`
--

CREATE TABLE IF NOT EXISTS `album_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(10) unsigned NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `views` int(10) unsigned NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastedit` timestamp NULL DEFAULT NULL,
  `lastupload` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `resource`
--

CREATE TABLE IF NOT EXISTS `resource` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL DEFAULT '',
  `content` mediumtext NOT NULL,
  `authorid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastedit` timestamp NULL DEFAULT NULL,
  `lasteditorid` int(10) unsigned NOT NULL,
  `views` int(10) unsigned NOT NULL DEFAULT '0',
  `editions` int(10) unsigned NOT NULL DEFAULT '1',
  `visible` int(1) NOT NULL DEFAULT '1',
  `locked` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `resource`
--

INSERT INTO `resource` (`id`, `name`, `description`, `content`, `authorid`, `time`, `lastedit`, `lasteditorid`, `views`, `editions`, `visible`, `locked`) VALUES
(1, '第一个资源', '这是我的第一个资源', '在刚开始学习Mybatis注解的时候，总是遇到错误Type interface com.souvi.ibatis.xxxMapper is  not known to the MapperRegistry，在网上搜索相关的解决方案时，得到的答案都不怎么详细，但知道了Mybatis注解一定要注册自己写的接口类，不然就会老报开头提到的这个错误。经过一段时间的学习后，想在这里和大家分享一下mybatis注解的使用，以基础数据的增、删、改、查为例。', 1, '2014-01-22 10:58:07', NULL, 1, 0, 1, 1, 0),
(2, '第一个资源', '这是我的第一个资源', '在刚开始学习Mybatis注解的时候，总是遇到错误Type interface com.souvi.ibatis.xxxMapper is  not known to the MapperRegistry，在网上搜索相关的解决方案时，得到的答案都不怎么详细，但知道了Mybatis注解一定要注册自己写的接口类，不然就会老报开头提到的这个错误。经过一段时间的学习后，想在这里和大家分享一下mybatis注解的使用，以基础数据的增、删、改、查为例。', 1, '2014-01-22 10:58:14', NULL, 1, 0, 1, 1, 0);

-- --------------------------------------------------------

--
-- 表的结构 `resource_edition`
--

CREATE TABLE IF NOT EXISTS `resource_edition` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `resourceid` int(10) unsigned NOT NULL,
  `authorid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ip` varchar(40) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL DEFAULT '',
  `content` mediumint(9) NOT NULL,
  `reason` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `resource_relation`
--

CREATE TABLE IF NOT EXISTS `resource_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromrid` int(11) NOT NULL,
  `torid` int(11) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `resource_topic`
--

CREATE TABLE IF NOT EXISTS `resource_topic` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `resourceid` int(10) unsigned NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` mediumint(9) NOT NULL,
  `authorid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastedit` int(11) DEFAULT NULL,
  `views` int(11) NOT NULL DEFAULT '0',
  `replys` int(11) NOT NULL DEFAULT '0',
  `visible` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `resource_topic_reply`
--

CREATE TABLE IF NOT EXISTS `resource_topic_reply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `topicid` int(10) unsigned NOT NULL,
  `content` text NOT NULL,
  `authorid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `visible` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` char(32) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `gender` int(4) DEFAULT NULL COMMENT '1 男 2 女 0 未知 3 其他',
  `birthday` date DEFAULT NULL,
  `iconid` int(10) unsigned DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `regip` varchar(40) DEFAULT NULL,
  `regtime` timestamp NULL DEFAULT NULL,
  `lastip` varchar(40) DEFAULT NULL,
  `lasttime` timestamp NULL DEFAULT NULL,
  `truename` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `isadmin` int(4) DEFAULT '0',
  `creates` int(10) unsigned NOT NULL DEFAULT '0',
  `focus` int(10) unsigned NOT NULL DEFAULT '0',
  `views` int(10) unsigned NOT NULL DEFAULT '0',
  `checkup` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`,`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user_focus_resource`
--

CREATE TABLE IF NOT EXISTS `user_focus_resource` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `resourceid` int(10) unsigned NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user_link`
--

CREATE TABLE IF NOT EXISTS `user_link` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fromuid` int(10) unsigned NOT NULL,
  `touid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user_link_request`
--

CREATE TABLE IF NOT EXISTS `user_link_request` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fromuid` int(10) unsigned NOT NULL,
  `touid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(4) NOT NULL DEFAULT '0' COMMENT '0 已请求 1 已接受 2 已拒绝 3 已忽略',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user_topic`
--

CREATE TABLE IF NOT EXISTS `user_topic` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(10) unsigned NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` mediumint(9) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastedit` timestamp NULL DEFAULT NULL,
  `views` int(10) unsigned NOT NULL DEFAULT '0',
  `replys` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(3) unsigned NOT NULL DEFAULT '0' COMMENT '0 公开 1.保密 2.好友可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user_topic_reply`
--

CREATE TABLE IF NOT EXISTS `user_topic_reply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `topicid` int(10) unsigned NOT NULL,
  `content` text NOT NULL,
  `authorid` int(10) unsigned NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `visible` int(3) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;
--
-- 数据库: `snake`
--

-- --------------------------------------------------------

--
-- 表的结构 `snake_object_object_link`
--

CREATE TABLE IF NOT EXISTS `snake_object_object_link` (
  `id` bigint(20) NOT NULL,
  `from_object_id` bigint(20) NOT NULL,
  `to_object_id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `creation_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `snake_object_role_link`
--

CREATE TABLE IF NOT EXISTS `snake_object_role_link` (
  `id` bigint(20) NOT NULL,
  `object_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `creation_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `snake_objects`
--

CREATE TABLE IF NOT EXISTS `snake_objects` (
  `id` bigint(20) NOT NULL,
  `name` varchar(256) CHARACTER SET latin1 NOT NULL,
  `description` text CHARACTER SET latin1 NOT NULL,
  `creation_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `snake_roles`
--

CREATE TABLE IF NOT EXISTS `snake_roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(256) CHARACTER SET latin1 NOT NULL,
  `description` text CHARACTER SET latin1 NOT NULL,
  `creation_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
-- 数据库: `test`
--

-- --------------------------------------------------------

--
-- 表的结构 `snake_subjects`
--

CREATE TABLE IF NOT EXISTS `snake_subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `basic_contents` text,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `snake_subjects_links`
--

CREATE TABLE IF NOT EXISTS `snake_subjects_links` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_subject_id` int(11) DEFAULT NULL,
  `to_subject_id` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `from_subject_id` (`from_subject_id`),
  KEY `to_subject_id` (`to_subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `snake_types`
--

CREATE TABLE IF NOT EXISTS `snake_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- 限制导出的表
--

--
-- 限制表 `snake_subjects`
--
ALTER TABLE `snake_subjects`
  ADD CONSTRAINT `snake_subjects_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `snake_types` (`id`);

--
-- 限制表 `snake_subjects_links`
--
ALTER TABLE `snake_subjects_links`
  ADD CONSTRAINT `snake_subjects_links_ibfk_1` FOREIGN KEY (`from_subject_id`) REFERENCES `snake_subjects` (`id`),
  ADD CONSTRAINT `snake_subjects_links_ibfk_2` FOREIGN KEY (`to_subject_id`) REFERENCES `snake_subjects` (`id`);
--
-- 数据库: `testdb`
--

-- --------------------------------------------------------

--
-- 表的结构 `article`
--

CREATE TABLE IF NOT EXISTS `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `article`
--

INSERT INTO `article` (`id`, `userid`, `title`, `content`) VALUES
(1, 1, 'test_title', 'test_content'),
(2, 1, 'test_title_2', 'test_content_2'),
(3, 1, 'test_title_3', 'test_content_3'),
(4, 1, 'test_title_4', 'test_content_4');

-- --------------------------------------------------------

--
-- 表的结构 `goods`
--

CREATE TABLE IF NOT EXISTS `goods` (
  `goodsId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `price` double(10,2) NOT NULL,
  `goodName` varchar(20) NOT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- 转存表中的数据 `goods`
--

INSERT INTO `goods` (`goodsId`, `price`, `goodName`) VALUES
(2, 36.20, '面包'),
(7, 5200.00, 'thinkpad笔记本'),
(8, 5200.00, 'thinkpad笔记本'),
(13, 5200.00, 'thinkpad???'),
(14, 5200.00, 'thinkpad???'),
(15, 5200.00, 'thinkpad???'),
(16, 5200.00, 'thinkpad???'),
(17, 5200.00, 'thinkpad???');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `userAge` int(11) DEFAULT NULL,
  `userAddress` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `userName`, `userAge`, `userAddress`) VALUES
(1, 'summer', 100, 'shanghai,pudong');
--
-- 数据库: `webdb`
--

-- --------------------------------------------------------

--
-- 表的结构 `t_message`
--

CREATE TABLE IF NOT EXISTS `t_message` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `t_message`
--

INSERT INTO `t_message` (`id`, `name`) VALUES
(5, 'this name');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
