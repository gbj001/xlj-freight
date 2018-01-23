package cn.xlj.modules.orderdetail.entity;

public class FreightRequest {

    private String requestId;
    private String beginArea;
    private String endArea;
    private String shopWeight;
    private String shopLength;
    private String shopWidth;
    private String shopHight;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBeginArea() {
        return beginArea;
    }

    public void setBeginArea(String beginArea) {
        this.beginArea = beginArea;
    }

    public String getEndArea() {
        return endArea;
    }

    public void setEndArea(String endArea) {
        this.endArea = endArea;
    }

    public String getShopWeight() {
        return shopWeight;
    }

    public void setShopWeight(String shopWeight) {
        this.shopWeight = shopWeight;
    }

    public String getShopLength() {
        return shopLength;
    }

    public void setShopLength(String shopLength) {
        this.shopLength = shopLength;
    }

    public String getShopWidth() {
        return shopWidth;
    }

    public void setShopWidth(String shopWidth) {
        this.shopWidth = shopWidth;
    }

    public String getShopHight() {
        return shopHight;
    }

    public void setShopHight(String shopHight) {
        this.shopHight = shopHight;
    }

    @Override
    public String toString() {
        return "FerightRequest{" +
                "requestId='" + requestId + '\'' +
                ", beginArea='" + beginArea + '\'' +
                ", endArea='" + endArea + '\'' +
                ", shopWeight='" + shopWeight + '\'' +
                ", shopLength='" + shopLength + '\'' +
                ", shopWidth='" + shopWidth + '\'' +
                ", shopHight='" + shopHight + '\'' +
                '}';
    }
}
