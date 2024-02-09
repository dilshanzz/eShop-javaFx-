package entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "orderdata")
public class OrderData {
    @Id
    private String orderId;
    private double totalAmount;
    private double serviceCharge;
    private double partsPrice;

    @OneToMany(mappedBy = "orderData", cascade = CascadeType.ALL)
    private List<UsedParts> partList;
    public OrderData(String orderId, double partsPrice, double serviceCharge, double charge) {
    }

    public OrderData(String orderId, double totalAmount, double serviceCharge, double partsPrice, List<UsedParts> partList) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.serviceCharge = serviceCharge;
        this.partsPrice = partsPrice;
        this.partList = partList;
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

    public List<UsedParts> getPartList() {
        return partList;
    }

    public void setPartList(List<UsedParts> partList) {
        this.partList = partList;
    }
}
