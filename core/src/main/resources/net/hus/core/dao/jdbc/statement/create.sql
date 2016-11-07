CREATE TABLE IF NOT EXISTS `FIELD` (
  `mId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mName` varchar(50) NOT NULL,
  `mType` varchar(50) NOT NULL,
  `mProperties` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`mId`),
  UNIQUE KEY `mName` (`mName`,`mType`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `FIELD_GROUP` (
  `mId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mGroup` varchar(50) NOT NULL,
  `mFieldId` bigint(20) NOT NULL,
  `mDisplay` varchar(50) DEFAULT NULL,
  `mSort` int(11) DEFAULT NULL,
  PRIMARY KEY (`mId`),
  UNIQUE KEY `mGroup` (`mGroup`,`mFieldId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `FIELD_VALUE` (
  `mId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mTable` varchar(50) NOT NULL,
  `mKey` varchar(1000) NOT NULL,
  `mValue` varchar(4000) NOT NULL,
  `mFieldId` bigint(20) NOT NULL,
  `mAsOf` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`mId`),
  KEY `mKey` (`mKey`(333)),
  KEY `mTable` (`mTable`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `LOOKUP` (
  `mId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mGroup` varchar(50) NOT NULL,
  `mName` varchar(100) NOT NULL,
  `mAbbreviation` varchar(20) NOT NULL,
  `mDescription` varchar(1000) DEFAULT NULL,
  `mSort` int(11) NOT NULL,
  `mAltId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`mId`),
  UNIQUE KEY `mGroupName` (`mGroup`,`mName`),
  KEY `mGroup` (`mGroup`),
  KEY `mAltId` (`mAltId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `LOOKUP_XL` (
  `mId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mGroup` varchar(50) NOT NULL,
  `mName` varchar(100) NOT NULL,
  `mXL` longtext NOT NULL,
  PRIMARY KEY (`mId`),
  UNIQUE KEY `mGroupName` (`mGroup`,`mName`),
  KEY `mGroup` (`mGroup`),
  KEY `mName` (`mName`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;
