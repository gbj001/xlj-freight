package cn.xlj.modules.freight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.xlj.modules.freight.dao.FreightDao;
import cn.xlj.modules.freight.entity.FreightEntity;
import cn.xlj.modules.freight.service.FreightService;



@Service("freightService")
public class FreightServiceImpl implements FreightService {
	@Autowired
	private FreightDao freightDao;
	
	@Override
	public FreightEntity queryObject(Long id){
		return freightDao.queryObject(id);
	}
	
	@Override
	public List<FreightEntity> queryList(Map<String, Object> map){
		return freightDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return freightDao.queryTotal(map);
	}
	
	@Override
	public void save(FreightEntity freight){
		freightDao.save(freight);
	}

	@Override
	public void update(FreightEntity freight){
		freightDao.update(freight);
	}
	
	@Override
	public void delete(Long id){
		freightDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		freightDao.deleteBatch(ids);
	}
	
}
