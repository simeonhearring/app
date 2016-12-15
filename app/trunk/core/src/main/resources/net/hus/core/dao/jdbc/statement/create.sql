-- phpMyAdmin SQL Dump
-- version 4.0.10.7
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Dec 15, 2016 at 12:57 PM
-- Server version: 5.6.33
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `simeon_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `FIELD`
--

CREATE TABLE IF NOT EXISTS `FIELD` (
  `mId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mName` varchar(50) NOT NULL,
  `mType` varchar(50) NOT NULL,
  `mProperties` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`mId`),
  UNIQUE KEY `mName` (`mName`,`mType`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `FIELD_TABLE`
--

CREATE TABLE IF NOT EXISTS `FIELD_TABLE` (
  `mId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mTable` varchar(50) NOT NULL,
  `mFieldId` bigint(20) NOT NULL,
  `mDisplay` varchar(50) DEFAULT NULL,
  `mSort` int(11) DEFAULT NULL,
  PRIMARY KEY (`mId`),
  UNIQUE KEY `mGroup` (`mTable`,`mFieldId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

-- --------------------------------------------------------

--
-- Table structure for table `FIELD_VALUE`
--

CREATE TABLE IF NOT EXISTS `FIELD_VALUE` (
  `mId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mFieldId` bigint(20) NOT NULL,
  `mTable` varchar(50) NOT NULL,
  `mKey` varchar(1000) NOT NULL,
  `mPos` int(11) NOT NULL DEFAULT '0',
  `mValue` varchar(4000) NOT NULL,
  `mValueId` bigint(20) DEFAULT NULL,
  `mAsOf` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`mId`),
  KEY `mKey` (`mKey`(333)),
  KEY `mTable` (`mTable`),
  KEY `mPos` (`mPos`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

-- --------------------------------------------------------

--
-- Table structure for table `LOOKUP`
--

CREATE TABLE IF NOT EXISTS `LOOKUP` (
  `mId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mGroup` varchar(50) NOT NULL,
  `mName` varchar(100) NOT NULL,
  `mDisplay` varchar(200) NOT NULL,
  `mAbbreviation` varchar(200) DEFAULT NULL,
  `mDescription` varchar(1000) DEFAULT NULL,
  `mSort` int(11) NOT NULL,
  `mAltId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`mId`),
  UNIQUE KEY `mGroupName` (`mGroup`,`mName`),
  KEY `mGroup` (`mGroup`),
  KEY `mAltId` (`mAltId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=110 ;

-- --------------------------------------------------------

--
-- Table structure for table `LOOKUP_XL`
--

CREATE TABLE IF NOT EXISTS `LOOKUP_XL` (
  `mId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mGroup` varchar(50) NOT NULL,
  `mName` varchar(100) NOT NULL,
  `mDisplay` varchar(200) DEFAULT NULL,
  `mXL` longtext NOT NULL,
  PRIMARY KEY (`mId`),
  UNIQUE KEY `mGroupName` (`mGroup`,`mName`),
  KEY `mGroup` (`mGroup`),
  KEY `mName` (`mName`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;
