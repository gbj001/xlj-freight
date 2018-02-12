-- 基础运费表
CREATE TABLE `tb_freight_base_rule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_type` VARCHAR(1) NOT NULL COMMENT '客户类型',
  `warehouse_code` VARCHAR(20) NOT NULL COMMENT '发货仓编码',
  `to_province_id` VARCHAR(10) COMMENT '运输到达省份编码',
  `to_city_id` VARCHAR(10) COMMENT '运输到达城市编码',
  `to_area_id` VARCHAR(10) COMMENT '运输到达区县编码',
  `fee` VARCHAR(15) COMMENT '基础运费',
  `create_user` VARCHAR(50) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `create_time` DATETIME COMMENT '创建时间',
  `update_user` VARCHAR(50) COMMENT '修改人',
  `update_time` DATETIME COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础运费数据表';





