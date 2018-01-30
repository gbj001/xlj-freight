package cn.xlj.modules.freight.dto;

import cn.xlj.modules.freight.entity.FreightDetailEntity;
import cn.xlj.modules.freight.entity.FreightEntity;

import java.util.List;

public class FreightDto {

    private String requestId;
    private List<FreightDetailEntity> productItems;
    private String fromProvince;
    private String fromCity;
    private String fromArea;
    private String toProvince;
    private String toCity;
    private String toArea;
    private String address;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<FreightDetailEntity> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<FreightDetailEntity> productItems) {
        this.productItems = productItems;
    }

    public String getFromProvince() {
        return fromProvince;
    }

    public void setFromProvince(String fromProvince) {
        this.fromProvince = fromProvince;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromArea() {
        return fromArea;
    }

    public void setFromArea(String fromArea) {
        this.fromArea = fromArea;
    }

    public String getToProvince() {
        return toProvince;
    }

    public void setToProvince(String toProvince) {
        this.toProvince = toProvince;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getToArea() {
        return toArea;
    }

    public void setToArea(String toArea) {
        this.toArea = toArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
