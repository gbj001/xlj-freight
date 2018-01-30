package cn.xlj.modules.freight.service;

import cn.xlj.modules.freight.dto.FreightDto;
import cn.xlj.modules.freight.entity.FreightEntity;

import java.util.List;
import java.util.Map;

/**
 * 运费数据表
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-24 15:44:20
 */
public interface FreightService {
	
	FreightEntity queryObject(Long id);

	FreightEntity queryByRequestId(String requestId);
	
	List<FreightEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(FreightDto freightDto);

	void save(FreightEntity freightEntity);

	void update(FreightEntity freight);

	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	double calculateFee(Integer weight);



}
