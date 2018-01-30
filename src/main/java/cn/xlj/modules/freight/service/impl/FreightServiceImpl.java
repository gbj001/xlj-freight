package cn.xlj.modules.freight.service.impl;

import cn.xlj.modules.freight.dao.FreightDetailDao;
import cn.xlj.modules.freight.dto.FreightDto;
import cn.xlj.modules.freight.entity.FreightDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cn.xlj.modules.freight.dao.FreightDao;
import cn.xlj.modules.freight.entity.FreightEntity;
import cn.xlj.modules.freight.service.FreightService;
import org.springframework.transaction.annotation.Transactional;


@Service("freightService")
public class FreightServiceImpl implements FreightService {
	@Autowired
	private FreightDao freightDao;

	@Autowired
	private FreightDetailDao freightDetailDao;
	
	@Override
	public FreightEntity queryObject(Long id){
		return freightDao.queryObject(id);
	}


	@Override
	public FreightEntity queryByRequestId(String requestId){
		return freightDao.queryByRequestId(requestId);
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
	@Transactional
	public void save(FreightDto freightDto){
		FreightEntity freightEntity = new FreightEntity(freightDto);
		freightDao.save(freightEntity);

		List<FreightDetailEntity> freightDetailEntities = freightDto.getProductItems();
		for(FreightDetailEntity freightDetailEntity:freightDetailEntities){
			freightDetailEntity.setFreightId(freightEntity.getId());
			freightDetailDao.save(freightDetailEntity);
		}

	}

	@Override
	public void save(FreightEntity freightEntity){
		freightDao.save(freightEntity);
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


	@Override
	public double calculateFee(Integer weight){
		Random ran1 = new Random();
		return Double.parseDouble(String.valueOf(ran1.nextInt(weight)));
	}
	
}
