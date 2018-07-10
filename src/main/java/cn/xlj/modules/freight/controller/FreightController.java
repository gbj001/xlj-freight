package cn.xlj.modules.freight.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xlj.common.utils.PageUtils;
import cn.xlj.common.utils.Query;
import cn.xlj.common.utils.R;
import cn.xlj.modules.freight.entity.OrderDetailEntity;
import cn.xlj.modules.sys.entity.SysUserEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import cn.xlj.modules.freight.entity.OrderEntity;
import cn.xlj.modules.freight.service.OrderService;


/**
 * 运费数据表
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-24 15:44:20
 */
@RestController
@RequestMapping("freight")
public class FreightController {
	@Autowired
	private OrderService freightService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("freight:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		PageHelper.startPage(2,3);
		List<OrderEntity> freightList = freightService.queryList(query);
		PageInfo<OrderEntity> pageInfo = new PageInfo<>(freightList);

		int total = freightService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(freightList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("freight:info")
	public R info(@PathVariable("id") Long id){
		OrderEntity freight = freightService.queryObject(id);
		
		return R.ok().put("freight", freight);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("freight:save")
	public R save(@RequestBody OrderEntity freight){
		freightService.save(freight);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("freight:update")
	public R update(@RequestBody OrderEntity freight){
		String username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();
		freight.setUpdateUser(username);
		freight.setUpdateTime(new Date());
		freightService.update(freight);
		
		return R.ok();
	}

	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("freight:delete")
	public R delete(@RequestBody Long[] ids){
		freightService.deleteBatch(ids);
		
		return R.ok();
	}

	@RequestMapping("/list/detail/{orderId}")
	public R orderDetailList(@PathVariable String orderId){
		//查询订单详情列表数据
		Map params  = new HashMap();
		params.put("order_id",orderId);
		params.put("page",1);
		params.put("limit",10);
		params.put("sidx","");
		params.put("order","asc");
		Query query = new Query(params);
		List<OrderDetailEntity> orderEntityList = freightService.queryListByOrderId(query);
		int totalCount = freightService.queryListCountByOrderId(query);

		PageUtils pageUtil = new PageUtils(orderEntityList, totalCount, query.getLimit(), query.getPage());
        //
		////查询列表数据
		//Map
        //

        //
		//List<OrderEntity> freightList = freightService.queryList(query);
		//int total = freightService.queryTotal(query);

		//PageUtils pageUtil = new PageUtils(freightList, total, query.getLimit(), query.getPage());

		return R.ok().put("pagedetail", pageUtil);
	}

}
