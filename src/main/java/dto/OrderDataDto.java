package dto;

import entity.Orders;

public class OrderDataDto {
    private String code;
    private double partsPrice;
    private double sc;
    private double totalAmount;
    private Orders orderDto;


    public OrderDataDto() {
    }

    public OrderDataDto(String code, double partsPrice, double sc, double totalAmount) {
        this.code = code;
        this.partsPrice = partsPrice;
        this.sc = sc;
        this.totalAmount = totalAmount;
    }

    public OrderDataDto(String code, double partsPrice, double sc, double totalAmount, Orders orderDto) {
        this.code = code;
        this.partsPrice = partsPrice;
        this.sc = sc;
        this.totalAmount = totalAmount;
        this.orderDto = orderDto;
    }

    public Orders getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(Orders orderDto) {
        this.orderDto = orderDto;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPartsPrice() {
        return partsPrice;
    }

    public void setPartsPrice(double partsPrice) {
        this.partsPrice = partsPrice;
    }

    public double getSc() {
        return sc;
    }

    public void setSc(double sc) {
        this.sc = sc;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
