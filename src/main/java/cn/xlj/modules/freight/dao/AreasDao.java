package cn.xlj.modules.freight.dao;

import cn.xlj.modules.freight.entity.CustomerAreasEntity;
import cn.xlj.modules.sys.dao.BaseDao;
import org.springframework.data.repository.query.Param;

import java.util.Map;

/**
 * 行政区域县区信息表
 * 
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-02-07 15:43:40
 */
public interface AreasDao {

    CustomerAreasEntity queryNameById(Map<String, Object> map);
	
}
