package cn.xlj.modules.orderdetail.controller;

import java.util.List;
import java.util.Map;

import cn.xlj.common.annotation.SysLog;
import cn.xlj.common.utils.PageUtils;
import cn.xlj.common.utils.Query;
import cn.xlj.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xlj.modules.orderdetail.entity.OrderDetailEntity;
import cn.xlj.modules.orderdetail.service.OrderDetailService;


/**
 * 
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-12 15:04:51
 */
@RestController
@RequestMapping("orderdetail")
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("orderdetail:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OrderDetailEntity> orderDetailList = orderDetailService.queryList(query);
		int total = orderDetailService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(orderDetailList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("orderdetail:info")
	public R info(@PathVariable("id") Integer id){
		OrderDetailEntity orderDetail = orderDetailService.queryObject(id);
		
		return R.ok().put("orderDetail", orderDetail);
	}
	
	/**
	 * 保存
	 */
	@SysLog("保存测试订单")
	@RequestMapping("/save")
	@RequiresPermissions("orderdetail:save")
	public R save(@RequestBody OrderDetailEntity orderDetail){
		orderDetailService.save(orderDetail);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@SysLog("修改测试订单")
	@RequestMapping("/update")
	@RequiresPermissions("orderdetail:update")
	public R update(@RequestBody OrderDetailEntity orderDetail){
		orderDetailService.update(orderDetail);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除测试订单")
	@RequestMapping("/delete")
	@RequiresPermissions("orderdetail:delete")
	public R delete(@RequestBody Integer[] ids){
		orderDetailService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
