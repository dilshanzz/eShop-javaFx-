package entity;

import dto.PartDto;

import javax.persistence.*;
import java.util.List;


@Entity
public class Orders {

    @Id
    private String orderId;
    private String contact;
    private String Cname;
    private String email;
    private String itemName;
    private String description;
    private String category;
    private String date;
    private String status;

    public Orders(String orderId, String contact, String cname, String email, String itemName, String description, String category, String date, String status) {
        this.orderId = orderId;
        this.contact = contact;
        Cname = cname;
        this.email = email;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.date = date;
        this.status = status;

    }

    public Orders() {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

}