package cn.xlj.modules.orderdetail.service;

import cn.xlj.modules.orderdetail.entity.OrderDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-12 15:04:51
 */
public interface OrderDetailService {
	
	OrderDetailEntity queryObject(Integer id);
	
	List<OrderDetailEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderDetailEntity orderDetail);
	
	void update(OrderDetailEntity orderDetail);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
