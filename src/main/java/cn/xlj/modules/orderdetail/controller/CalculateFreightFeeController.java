package cn.xlj.modules.orderdetail.controller;

import cn.xlj.common.utils.R;
import cn.xlj.modules.orderdetail.entity.FreightRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CalculateFreightFeeController {

    /**
     * 计算运费
     */
    @RequestMapping(value = "/calculate/freight", method = RequestMethod.POST)
    @ResponseBody
    public R calculateFreight(@RequestBody FreightRequest freightRequest){
        System.out.println("object:" + freightRequest.toString());
        //1、存储接受的数据（不做校验）

        //2、根据运费规则查找符合条件的运费

        //3、返回运费和相关状态

        Map map = new HashMap();

        map.put("code","0000");
        map.put("msg","success");
        map.put("fee","134.32");

        return R.ok(map);
    }
}
