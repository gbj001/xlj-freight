package cn.xlj.modules.freight.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.xlj.common.utils.PageUtils;
import cn.xlj.common.utils.Query;
import cn.xlj.common.utils.R;
import cn.xlj.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xlj.modules.freight.entity.FreightEntity;
import cn.xlj.modules.freight.service.FreightService;


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
	private FreightService freightService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("freight:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<FreightEntity> freightList = freightService.queryList(query);
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
		FreightEntity freight = freightService.queryObject(id);
		
		return R.ok().put("freight", freight);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("freight:save")
	public R save(@RequestBody FreightEntity freight){
		freightService.save(freight);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("freight:update")
	public R update(@RequestBody FreightEntity freight){
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
	
}
