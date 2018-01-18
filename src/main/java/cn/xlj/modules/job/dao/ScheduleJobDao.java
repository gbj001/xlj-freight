package cn.xlj.modules.job.dao;

import cn.xlj.modules.job.entity.ScheduleJobEntity;
import cn.xlj.modules.sys.dao.BaseDao;

import java.util.Map;

/**
 * 定时任务
 * 
* @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2016年12月1日 下午10:29:57
 */
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
