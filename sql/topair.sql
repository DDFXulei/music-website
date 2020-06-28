
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `birthday` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8




product_id:
	1: 吸附式干燥机
	2: 冷冻式干燥机
	4: 管道过滤器
	8: 制氮机
	16: 工艺气体干燥
	32: 其他辅助产品

   insert into `PRODUCT_TYPE` values (0,'全部类别',current_timestamp(),current_timestamp());
   insert into `PRODUCT_TYPE` values (1,'吸附式干燥机',current_timestamp(),current_timestamp());
   insert into `PRODUCT_TYPE` values (2,'冷冻式干燥机',current_timestamp(),current_timestamp());
   insert into `PRODUCT_TYPE` values (4,'管道过滤器',current_timestamp(),current_timestamp());
   insert into `PRODUCT_TYPE` values (8,'制氮机',current_timestamp(),current_timestamp());
   insert into `PRODUCT_TYPE` values (16,'工艺气体干燥',current_timestamp(),current_timestamp());
   insert into `PRODUCT_TYPE` values (32,'其他辅助设备',current_timestamp(),current_timestamp());
   insert into `PRODUCT_TYPE` values (1024,'others',current_timestamp(),current_timestamp());
   insert into `PRODUCT_TYPE` values (1025,'others',current_timestamp(),current_timestamp());

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(10) unsigned NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `product_intro` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '发行时间',
  `update_time` datetime NOT NULL,
  `product_pic` varchar(255) DEFAULT NULL,
  `product_lyric` text,
  `product_url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;


insert into `product_main` 
values(1,1,"变压吸附制氮机 PPNG","TopAir PPNG150-800 HE系列制氮机可以提供大气量制氮解决方案，处理气量段范围广、性能卓越。","/img/productPic/1.jpg",current_timestamp(),current_timestamp(),"","","");


insert into `product_main` 
values(2,2,"冷冻式干燥机AD2（风冷）","TopAir AD215～1000A冷冻式干燥机，通过强制冷却降低压缩空气中水份含量，来保护用户的压缩空气系统。最低可达到压力露点3C。","/img/productPic/21.jpg",current_timestamp(),current_timestamp(),"","","");

insert into `product_main` 
values(3,4,"过滤器PF","TopAir 法兰式过滤器，含有高强度高效率的过滤筒，过滤芯放置在耐压16barg的铸铝外壳内，进出口使用法兰连接。外壳内外表面做电泳防腐处理，外表面为环氧树脂喷漆，外壳使用寿命20年。法兰式过滤器，标配压差指示，手动排污阀，可选配机械式浮动排水阀，滤芯更换十分简单。","/img/productPic/21.jpg",current_timestamp(),current_timestamp(),"","","");


insert into `product_main` 
values(4,16,"天然气行业PNG","TopAir 天然气行业应用","/img/productPic/F.jpg",current_timestamp(),current_timestamp(),"","","");

insert into `product_main` 
values(5,8,"变压吸附制氮机 PPNG","TopAir PPNG150-800 HE系列制氮机可以提供大气量制氮解决方案，处理气量段范围广、性能卓越。","/img/productPic/F.jpg",current_timestamp(),current_timestamp(),"","","");


insert into `product_main` 
values(6,1,"压缩热吸附式干燥机PHC(E)","TopAir配置高品质部件的PHC(e)压缩热吸附式干燥机，可提供洁净和干燥的空气，从而延长您设备的使用寿命，全程保护您的产品。压缩热吸附式干燥机使用压缩机高温气体，脱附干燥剂中的水分。","/img/productPic/101.jpg",current_timestamp(),current_timestamp(),"","","");






insert into `product_app_env`
values(1,1,"/img/productPic/productEnv/env1.jpg","工具器械",current_timestamp(),current_timestamp());

insert into `product_app_env`
values(2,1,"/img/productPic/productEnv/env2.jpg","控制系统",current_timestamp(),current_timestamp());

insert into `product_app_env`
values(3,1,"/img/productPic/productEnv/env3.jpg","喷涂工具",current_timestamp(),current_timestamp());

insert into `product_app_env`
values(4,1,"/img/productPic/productEnv/env4.jpg","注射成功",current_timestamp(),current_timestamp());

insert into `product_app_env`
values(5,1,"/img/productPic/productEnv/env5.jpg","汽车商店",current_timestamp(),current_timestamp());

insert into `product_app_env`
values(6,1,"/img/productPic/productEnv/env6.jpg","轮胎气压",current_timestamp(),current_timestamp());


alter table product_app_env add column 


	1: 吸附式干燥机
	2: 冷冻式干燥机
	4: 管道过滤器
	8: 制氮机
	16: 工艺气体干燥
	32: 其他辅助产品
insert into `PRODUCT_TYPE` values (1,'吸附式干燥机',current_timestamp(),current_timestamp());
insert into `PRODUCT_TYPE` values (2,'冷冻式干燥机',current_timestamp(),current_timestamp());
insert into `PRODUCT_TYPE` values (4,'管道过滤器',current_timestamp(),current_timestamp());
insert into `PRODUCT_TYPE` values (8,'制氮机',current_timestamp(),current_timestamp());
insert into `PRODUCT_TYPE` values (16,'工艺气体干燥',current_timestamp(),current_timestamp());
insert into `PRODUCT_TYPE` values (32,'其他辅助产品',current_timestamp(),current_timestamp());







drop table if exists PRODUCT_APP_ENV;

drop table if exists PRODUCT_DETAIL_INFO;

drop table if exists PRODUCT_FEATURE_ADVANCE;

drop table if exists PRODUCT_MAIN;

drop table if exists PRODUCT_TYPE;

drop table if exists TRAFFIC_STATISTICS;

/*==============================================================*/
/* Table: PRODUCT_APP_ENV                                       */
/*==============================================================*/
create table PRODUCT_APP_ENV
(
   ID                   bigint not null AUTO_INCREMENT,
   PRODUCT_ID           bigint,
   APP_ENV              varchar(255),
   CREATE_TIME          datetime,
   UPDATE_TIME          datetime,
   primary key (ID)
);ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: PRODUCT_DETAIL_INFO                                   */
/*==============================================================*/
create table PRODUCT_DETAIL_INFO
(
   ID                   bigint not null AUTO_INCREMENT,
   PRODUCT_ID           bigint,
   PARAM_ID             bigint,
   PARAM_NAME           varchar(50),
   PARAM_VALUE          varchar(50),
   CREATE_TIME          datetime,
   UPDATE_TIME          datetime,
   primary key (ID)
);ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: PRODUCT_FEATURE_ADVANCE                               */
/*==============================================================*/
create table PRODUCT_FEATURE_ADVANCE
(
   ID                   bigint not null AUTO_INCREMENT,
   PRODUCT_ID           bigint,
   TITLE                varchar(50),
   DETAIL               varchar(255),
   CREATE_TIME          datetime,
   UPDATE_TIME          datetime,
   primary key (ID)
);ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: PRODUCT_MAIN                                          */
/*==============================================================*/
create table PRODUCT_MAIN
(
   PRODUCT_ID           bigint not null AUTO_INCREMENT,
   PRODUCT_TYPE         int,
   PRODUCT_NAME         varchar(50),
   PRODUCT_TITLE        varchar(255),
   PRODUCT_PIC          varchar(255),
   CREATE_TIME          datetime,
   UPDATE_TIME          datetime,
   PRODUCT_INTRO        text,
   PRODUCT_FEATURE_ID   varchar(255),
   PRODUCT_PARAM        varchar(255),
   primary key (PRODUCT_ID)
);ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: PRODUCT_TYPE                                          */
/*==============================================================*/
drop table PRODUCT_TYPE
create table PRODUCT_TYPE
(
   PRODUCT_TYPE_ID      bigint not null AUTO_INCREMENT,
   PRODUCT_TYPE_NAME    varchar(50),
   CREATE_TIME          datetime,
   UPDATE_TIME          datetime,
   primary key (PRODUCT_TYPE_ID)
);ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: TRAFFIC_STATISTICS                                    */
/*==============================================================*/
create table TRAFFIC_STATISTICS
(
   ID                   bigint not null AUTO_INCREMENT,
   ENTITY_ID            bigint,
   ENTITY_NAME          varchar(50),
   BROWSE_TIME          datetime,
   BROWSE_IP            varchar(100),
   primary key (ID)
);ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

alter table PRODUCT_APP_ENV add constraint FK_Reference_3 foreign key (PRODUCT_ID)
      references PRODUCT_MAIN (PRODUCT_ID) on delete restrict on update restrict;

alter table PRODUCT_DETAIL_INFO add constraint FK_Reference_1 foreign key (PRODUCT_ID)
      references PRODUCT_MAIN (PRODUCT_ID) on delete restrict on update restrict;

alter table PRODUCT_FEATURE_ADVANCE add constraint FK_Reference_2 foreign key (PRODUCT_ID)
      references PRODUCT_MAIN (PRODUCT_ID) on delete restrict on update restrict;

alter table PRODUCT_TYPE add constraint FK_Reference_4 foreign key (PRODUCT_ID)
      references PRODUCT_MAIN (PRODUCT_ID) on delete restrict on update restrict;


