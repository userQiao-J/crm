-- 2020/05/30 用户表
CREATE TABLE `crm`.`crm_user`  (
  `User_ID_` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `User_Name_` varchar(255) NOT NULL COMMENT '用户姓名',
  `User_Ico_` varchar(255) NULL COMMENT '用户头像地址',
  `UserName_` varchar(30) NOT NULL COMMENT '用户名',
  `PassWord_` varchar(255) NOT NULL COMMENT '用户密码',
  `User_Phone_` varchar(20) NOT NULL COMMENT '手机号码',
  `User_Email_` varchar(255) NOT NULL COMMENT '电子邮箱',
  `User_Company_` varchar(255) NULL COMMENT '所属企业',
  PRIMARY KEY (`ID_`)
);

-- 2020/05/30 客户信息表
CREATE TABLE `crm`.`crm_customer`  (
  `Customer_ID_` int(0) NULL AUTO_INCREMENT COMMENT '客户ID',
  `Customer_Name_` varchar(255) NULL COMMENT '客户名称',
  `Customer_type_` varchar(255) NULL COMMENT '客户类型',
  `Customer_tel_` varchar(11) NULL COMMENT '联系电话',
  `Cooperation_sta_time_` datetime(0) NULL COMMENT '合作开始时间',
  `Cooperation_end_time_` datetime(0) NULL COMMENT '合作结束时间',
  `Customer_Address_` varchar(255) NULL COMMENT '地址',
  `Cooperation_state_` int(255) NULL COMMENT '合作状态:0:合作中   1:已终止  2：黑名单',
  `Remarks_` varchar(255) NULL COMMENT '备注',
  `Reception_staff_` int(0) NULL COMMENT '公司接待人员',
  `Product_` int(0) NULL COMMENT '供应产品',
  `Is_delete` int(0) NULL COMMENT '是否删除 0：正常  1：删除',
  PRIMARY KEY (`ID_`)
);

