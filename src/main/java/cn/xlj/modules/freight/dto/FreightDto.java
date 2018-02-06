package cn.xlj.modules.freight.dto;

import cn.xlj.modules.freight.entity.FreightDetailEntity;
import cn.xlj.modules.freight.entity.FreightEntity;

import java.util.List;

public class FreightDto {

    private String requestId;
    private List<FreightDetailEntity> productItems;
    private String customerType;
    private String warehouseCode;
    private String warehouseName;
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

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
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
