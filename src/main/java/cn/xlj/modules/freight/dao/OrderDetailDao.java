package cn.xlj.modules.freight.dao;

import cn.xlj.modules.freight.entity.OrderDetailEntity;
import cn.xlj.modules.sys.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 运费数据明细表
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-24 15:44:20
 */
public interface OrderDetailDao extends BaseDao<OrderDetailEntity> {

    List<OrderDetailEntity> queryListByOrderId(Map<String, Object> map);

    int queryListCountByOrderId(Map<String, Object> map);
}