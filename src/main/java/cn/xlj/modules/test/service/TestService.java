package cn.xlj.modules.test.service;

import cn.xlj.modules.test.entity.TestEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-12 13:27:38
 */
public interface TestService {
	
	TestEntity queryObject(Integer id);
	
	List<TestEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TestEntity test);
	
	void update(TestEntity test);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
