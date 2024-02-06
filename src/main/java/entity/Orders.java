package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {



    private  String contact;
    private String Cname;
    private String email;
    private String itemName;
    private String description;
    private String category;
    @Id
    private String orderId;
    private String date;
    private String status;
    private double partsPrice;
    private double sc;
    private double totalAmount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsedParts> usedParts = new ArrayList<>();

    public Orders() {
    }

    public Orders(String contact, String cname, String email, String itemName, String description, String category, String orderId, String date, String status, double partsPrice, double sc, double totalAmount, List<UsedParts> usedParts) {
        this.contact = contact;
        Cname = cname;
        this.email = email;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.orderId = orderId;
        this.date = date;
        this.status = status;
        this.partsPrice = partsPrice;
        this.sc = sc;
        this.totalAmount = totalAmount;
    }

    public Orders(String contact, String cname, String email, String itemName, String description, String category, String orderId, String date, String status, double partsPrice, double sc, double totalAmount) {
        this.contact = contact;
        Cname = cname;
        this.email = email;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.orderId = orderId;
        this.date = date;
        this.status = status;
        this.partsPrice = partsPrice;
        this.sc = sc;
        this.totalAmount = totalAmount;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<UsedParts> getUsedParts() {
        return usedParts;
    }

    public void setUsedParts(List<UsedParts> usedParts) {
        this.usedParts = usedParts;
    }
}
