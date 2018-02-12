package cn.xlj.modules.freight.service;

import cn.xlj.modules.freight.dto.OrderDto;
import cn.xlj.modules.freight.entity.OrderDetailEntity;
import cn.xlj.modules.freight.entity.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 运费数据表
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-24 15:44:20
 */
public interface OrderService {
	
	OrderEntity queryObject(Long id);

	OrderEntity queryByRequestId(String requestId);
	
	List<OrderEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderDto orderDto);

	void save(OrderEntity orderEntity);

	void update(OrderEntity orderEntity);

	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	String calculateFee(OrderDto orderDto);

	List<OrderDetailEntity> queryListByOrderId(Map<String, Object> map);

	int queryListCountByOrderId(Map<String, Object> map);

}
