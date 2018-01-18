package cn.xlj.modules.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.xlj.modules.test.dao.TestDao;
import cn.xlj.modules.test.entity.TestEntity;
import cn.xlj.modules.test.service.TestService;



@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao testDao;
	
	@Override
	public TestEntity queryObject(Integer id){
		return testDao.queryObject(id);
	}
	
	@Override
	public List<TestEntity> queryList(Map<String, Object> map){
		return testDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return testDao.queryTotal(map);
	}
	
	@Override
	public void save(TestEntity test){
		testDao.save(test);
	}
	
	@Override
	public void update(TestEntity test){
		testDao.update(test);
	}
	
	@Override
	public void delete(Integer id){
		testDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		testDao.deleteBatch(ids);
	}
	
}
