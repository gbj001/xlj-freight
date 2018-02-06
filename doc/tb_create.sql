-- 运费表
CREATE TABLE `tb_freight` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `request_id` VARCHAR(20) NOT NULL COMMENT '请求ID',
  `customer_type` CHAR(2) COMMENT '客户类型',
  `warehouse_code` VARCHAR(10) COMMENT '发货仓编码',
  `warehouse_name` VARCHAR(50) COMMENT '发货仓名称',
  `to_province` VARCHAR(50) COMMENT '运输到达省份',
  `to_city` VARCHAR(50) COMMENT '运输到达城市',
  `to_area` VARCHAR(50) COMMENT '运输到达区县',
  `address` VARCHAR(50) COMMENT '运输到达详细地址',
  `expect_fee` DOUBLE(10,2) COMMENT '系统计算运费',
  `actual_fee` DOUBLE(10,2) COMMENT '实际运费',
  `create_user` VARCHAR(50) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `create_time` DATETIME COMMENT '创建时间',
  `update_user` VARCHAR(50) COMMENT '修改人',
  `update_time` DATETIME COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE `request_id_uq` (`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运费数据表';


-- 运费表明细
CREATE TABLE `tb_freight_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `freight_id` bigint NOT NULL COMMENT '运费表ID',
  `sku` VARCHAR(20) COMMENT '商品sku',
  `is_gift` SMALLINT(1) COMMENT '是否赠品' DEFAULT 0,
  `name` VARCHAR(50) COMMENT '商品名称',
  `unit_price` DOUBLE(10,2) COMMENT '商品单价',
  `number` INT(10) COMMENT '商品数量',
  `weight` INT(50) COMMENT '单个商品重量',
  `width` VARCHAR(50) COMMENT '商品宽度',
  `length` VARCHAR(50) COMMENT '商品长度',
  `height` VARCHAR(50) COMMENT '商品高度',
  `create_user` VARCHAR(50) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `create_time` DATETIME COMMENT '创建时间',
  `update_user` VARCHAR(50) COMMENT '修改人',
  `update_time` DATETIME COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运费数据明细表';




