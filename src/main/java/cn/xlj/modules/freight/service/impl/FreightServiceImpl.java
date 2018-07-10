package cn.xlj.modules.freight.service.impl;

import cn.xlj.modules.freight.dao.AreasDao;
import cn.xlj.modules.freight.dao.OrderDao;
import cn.xlj.modules.freight.dao.OrderDetailDao;
import cn.xlj.modules.freight.dto.OrderDto;
import cn.xlj.modules.freight.entity.CustomerAreasEntity;
import cn.xlj.modules.freight.entity.OrderDetailEntity;
import cn.xlj.modules.freight.entity.OrderEntity;
import cn.xlj.modules.freight.service.OrderService;
import cn.xlj.modules.sys.dao.SysConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Service("freightService")
public class FreightServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private SysConfigDao sysConfigDao;

    @Autowired
    private AreasDao areasDao;

    @Override
    public OrderEntity queryObject(Long id) {
        return orderDao.queryObject(id);
    }

    @Override
    public OrderEntity queryByRequestId(String requestId) {
        return orderDao.queryByRequestId(requestId);
    }

    @Override
    public List<OrderEntity> queryList(Map<String, Object> map) {
        return orderDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return orderDao.queryTotal(map);
    }

    @Override
    @Transactional
    public void save(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity(orderDto);
        Map<String, Object> map = new HashMap<>();
        map.put("provinceId",orderDto.getToProvince());
        map.put("cityId",orderDto.getToCity());
        map.put("areaId",orderDto.getToArea());
        CustomerAreasEntity customerAreasEntity = areasDao.queryNameById(map);
        orderEntity.setToProvince(customerAreasEntity.getProvinceName());
        orderEntity.setToCity(customerAreasEntity.getCityName());
        orderEntity.setToArea(customerAreasEntity.getAreaName());
        orderDao.save(orderEntity);

        List<OrderDetailEntity> orderDetailEntities = orderDto.getProductItems();
        for (OrderDetailEntity orderDetailEntity : orderDetailEntities) {
            orderDetailEntity.setOrderId(orderEntity.getId());
            orderDetailDao.save(orderDetailEntity);
        }
    }

    @Override
    public void save(OrderEntity orderEntity) {
        orderDao.save(orderEntity);
    }

    @Override
    public void update(OrderEntity orderEntity) {
        orderDao.update(orderEntity);
    }

    @Override
    public void delete(Long id) {
        orderDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        orderDao.deleteBatch(ids);
    }

    @Override
    public String calculateFee(OrderDto orderDto) {
        //-1 代表无法计算运费
        String noFee = "-1";
        String fee = "-1";
        ////大客户、散户、电商（）
        //if (orderDto != null && orderDto.getCustomerType().equals("1")) {
        //    //是否同城订单
        //    if (orderDto.isSameCity()) {
        //        //按照订购箱数计费
        //        fee = calculateTotalNumber(orderDto.getProductItems()) >= Integer.parseInt(sysConfigDao.queryByKey("MINNUMBER").getValue()) ? "0" : "90";
        //    } else {
        //        //外阜订单按照金额计费
        //        fee = calculateTotalOrderAmount(orderDto.getProductItems()) > Integer.parseInt(sysConfigDao.queryByKey("MINORDERAMOUNT").getValue()) ? "0" : noFee;
        //    }
        //}

        //分销客户
        if (orderDto != null) {
            //是否同城订单
            if (orderDto.isSameCity()) {
                //按照订购箱数计算
                if (calculateTotalNumber(orderDto.getProductItems()) < 5) {
                    fee = "90";
                } else if (calculateTotalNumber(orderDto.getProductItems()) >= 5 && calculateTotalWeight(orderDto.getProductItems()) < 1 * 1000) {
                    fee = "60";
                } else if (calculateTotalWeight(orderDto.getProductItems()) >= 1 * 1000) {
                    fee = "0";
                } else {
                    fee = noFee;
                }
            } else {
                //北京市外阜
                if(orderDto.getToProvince().equals("110000")){
                    fee = calculateTotalWeight(orderDto.getProductItems()) < 2 * 1000 ? "110" : "0";
                }
                else{
                    //外阜订单按订单重量计费
                    fee = calculateTotalWeight(orderDto.getProductItems()) >= 2 * 1000 ? "0" : noFee;
                }

            }
        }

        return fee;
    }

    @Override
    public List<OrderDetailEntity> queryListByOrderId(Map<String, Object> map){
        return orderDetailDao.queryListByOrderId(map);
    }

    @Override
    public int queryListCountByOrderId(Map<String, Object> map) {
        return orderDetailDao.queryListCountByOrderId(map);
    }

    private int calculateTotalNumber(List<OrderDetailEntity> orderDetailEntityList) {
        int totalNumber = 0;
        for (OrderDetailEntity orderDetailEntity : orderDetailEntityList) {
            if (!orderDetailEntity.getGift()) {
                if(this.materialMap().containsKey(orderDetailEntity.getSku())){
                    //根据转换率转换成箱
                    String changeRate = this.materialMap().get(orderDetailEntity.getSku());
                    double molecular = Double.parseDouble(changeRate.substring(0, changeRate.indexOf("/")));
                    double denominator = Double.parseDouble(changeRate.substring(changeRate.indexOf("/") + 1, changeRate.length()));
                    totalNumber += (orderDetailEntity.getNumber() * molecular / denominator);
                }
                else{
                    totalNumber += orderDetailEntity.getNumber();
                }
            }
        }
        return totalNumber;
    }

    private double calculateTotalOrderAmount(List<OrderDetailEntity> orderDetailEntityList) {
        double totalOrderAmount = 0.0;
        for (OrderDetailEntity orderDetailEntity : orderDetailEntityList) {
            if (!orderDetailEntity.getGift()) {
                totalOrderAmount += orderDetailEntity.getUnitPrice() * orderDetailEntity.getNumber();
            }
        }
        return totalOrderAmount;
    }

    private double calculateTotalWeight(List<OrderDetailEntity> orderDetailEntityList) {
        double totalWeight = 0.0;
        for (OrderDetailEntity orderDetailEntity : orderDetailEntityList) {
            if (!orderDetailEntity.getGift()) {
                BigDecimal weight = new BigDecimal(orderDetailEntity.getWeight());
                BigDecimal number = new BigDecimal(orderDetailEntity.getNumber());
                totalWeight += (weight.multiply(number).setScale(4,BigDecimal.ROUND_UP)).doubleValue();
            }
        }
        return totalWeight;
    }

    private Map<String, String> materialMap(){
        Map materialMap = new HashMap();
        materialMap.put("W000116","1/60");
        materialMap.put("20500007","1/30");
        materialMap.put("20500007","1/30");
        materialMap.put("11900005","1/20");
        materialMap.put("20500004","1/20");
        materialMap.put("20500008","1/20");
        materialMap.put("20500201","1/20");
        materialMap.put("20500207","1/20");
        materialMap.put("20500208","1/20");
        materialMap.put("10400009","1/12");
        materialMap.put("10400010","1/12");
        materialMap.put("10100384","1/20");
        materialMap.put("10100385","1/20");
        materialMap.put("10100382","1/20");
        materialMap.put("10100376","1/8");
        materialMap.put("10100345","1/50");
        materialMap.put("10100346","1/50");
        return materialMap;
    }

}
