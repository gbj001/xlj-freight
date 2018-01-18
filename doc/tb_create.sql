-- 测试用户
CREATE TABLE `tb_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '运费情况',
  `remark` varchar(100) COMMENT '备注',
  `create_time` datetime COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_time` datetime COMMENT '修改时间',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE INDEX (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试用户';

CREATE TABLE `tb_`