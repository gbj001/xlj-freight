package cn.xlj.modules.orderdetail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.xlj.modules.orderdetail.dao.OrderDetailDao;
import cn.xlj.modules.orderdetail.entity.OrderDetailEntity;
import cn.xlj.modules.orderdetail.service.OrderDetailService;



@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Override
	public OrderDetailEntity queryObject(Integer id){
		return orderDetailDao.queryObject(id);
	}
	
	@Override
	public List<OrderDetailEntity> queryList(Map<String, Object> map){
		return orderDetailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderDetailDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderDetailEntity orderDetail){
		orderDetailDao.save(orderDetail);
	}
	
	@Override
	public void update(OrderDetailEntity orderDetail){
		orderDetailDao.update(orderDetail);
	}
	
	@Override
	public void delete(Integer id){
		orderDetailDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		orderDetailDao.deleteBatch(ids);
	}
	
}
