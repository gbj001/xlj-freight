package cn.xlj.modules.freight.dto;

import cn.xlj.modules.freight.entity.OrderDetailEntity;

import java.util.List;

public class OrderDto {

    private String requestId;
    private List<OrderDetailEntity> productItems;
    private String customerType;
    private String warehouseCode;
    private String warehouseName;
    private String toProvince;
    private String toCity;
    private String toArea;
    private String address;
    private boolean isSameCity;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<OrderDetailEntity> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<OrderDetailEntity> productItems) {
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

    public boolean isSameCity() {
        return isSameCity;
    }

    public void setSameCity(boolean sameCity) {
        isSameCity = sameCity;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "requestId='" + requestId + '\'' +
                ", productItems=" + productItems +
                ", customerType='" + customerType + '\'' +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", toProvince='" + toProvince + '\'' +
                ", toCity='" + toCity + '\'' +
                ", toArea='" + toArea + '\'' +
                ", address='" + address + '\'' +
                ", isSameCity=" + isSameCity +
                '}';
    }
}
