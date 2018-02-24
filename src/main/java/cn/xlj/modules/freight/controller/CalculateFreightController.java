package cn.xlj.modules.freight.controller;

import cn.xlj.common.annotation.SysLog;
import cn.xlj.common.utils.R;
import cn.xlj.modules.freight.dto.OrderDto;
import cn.xlj.modules.freight.entity.OrderEntity;
import cn.xlj.modules.freight.service.OrderService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * 运费计算接口
 *
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-24 15:44:20
 */
@RestController
public class CalculateFreightController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService freightService;

    /**
     * 计算运费
     */
    @RequestMapping(value = "/calculate/freight-fee", method = RequestMethod.POST)
    @ResponseBody
    public R calculateFreightFee(@RequestBody OrderDto orderDto) {
        logger.info(orderDto.toString());
        Map map = new HashMap();
        try {
            //1、接受数据插入运费表
            freightService.save(orderDto);

            //2、根据规则计算出运费更新运费表
            String fee = freightService.calculateFee(orderDto);
            if (StringUtils.isNotEmpty(fee)) {
                OrderEntity freightEntity = freightService.queryByRequestId(orderDto.getRequestId());
                freightEntity.setExpectFee(Double.parseDouble(fee));
                freightService.update(freightEntity);
                map.put("requestId", orderDto.getRequestId());
                map.put("message", "success");
                map.put("successful", true);
                map.put("code", "000");
                map.put("freight_fee", fee);
            } else {
                map.put("requestId", orderDto.getRequestId());
                map.put("message", "请人工计算运费");
                map.put("successful", true);
                map.put("code", "400");
                map.put("freight_fee", null);
            }
        }catch(Exception e){
            logger.error(e.getMessage());
            return R.error(500,"系统调用错误");
        }

        return R.ok(map);
    }

}
