package dto;

import java.util.List;

public class OrderDataDto {
    private String orderId;
    private double totalAmount;
    private double serviceCharge;
    private double partsPrice;
    private List<UsedPartsDto> list ;

    public OrderDataDto(String orderId, double totalAmount, double serviceCharge, double partsPrice) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.serviceCharge = serviceCharge;
        this.partsPrice = partsPrice;
        this.list = list;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getPartsPrice() {
        return partsPrice;
    }

    public void setPartsPrice(double partsPrice) {
        this.partsPrice = partsPrice;
    }

    public List<UsedPartsDto> getList() {
        return list;
    }

    public void setList(List<UsedPartsDto> list) {
        this.list = list;
    }
}
