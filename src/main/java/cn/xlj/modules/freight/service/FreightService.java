package cn.xlj.modules.freight.service;

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
	
	List<FreightEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(FreightEntity freight);
	
	void update(FreightEntity freight);

	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
