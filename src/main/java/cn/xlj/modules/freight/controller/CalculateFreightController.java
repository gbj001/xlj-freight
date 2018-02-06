package cn.xlj.modules.freight.controller;

import cn.xlj.common.utils.R;
import cn.xlj.modules.freight.dto.FreightDto;
import cn.xlj.modules.freight.entity.FreightEntity;
import cn.xlj.modules.freight.service.FreightService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    @Autowired
    private FreightService freightService;

    /**
     * 计算运费
     */
    @RequestMapping(value = "/calculate/freight-fee", method = RequestMethod.POST)
    @ResponseBody
    public R calculateFreightFee(@RequestBody FreightDto freightDto){
        Map map = new HashMap();
        //1、接受数据插入运费表
        freightService.save(freightDto);

        //2、根据规则计算出运费更新运费表(暂时随机)
        double fee = freightService.calculateFee(100);


        //3、返回结果

        if(fee < 50){
            map.put("message", "无法计算出运费");
            map.put("successful", false);
            map.put("code", "400");
            map.put("freight_fee",null);
        }
        else{
            FreightEntity freightEntity = freightService.queryByRequestId(freightDto.getRequestId());
            freightEntity.setExpectFee(fee);
            freightService.update(freightEntity);
            map.put("message", "success");
            map.put("successful", true);
            map.put("code", "000");
            map.put("freight_fee",fee);
        }


        return R.ok(map);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("freight:info")
    public R info(@PathVariable("id") Long id) {
        FreightEntity freight = freightService.queryObject(id);

        return R.ok().put("freight", freight);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("freight:save")
    public R save(@RequestBody FreightEntity freight) {
        freightService.save(freight);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("freight:update")
    public R update(@RequestBody FreightEntity freight) {
        freightService.update(freight);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("freight:delete")
    public R delete(@RequestBody Long[] ids) {
        freightService.deleteBatch(ids);

        return R.ok();
    }

}
