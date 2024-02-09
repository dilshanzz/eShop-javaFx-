package dto.tm;

import com.jfoenix.controls.JFXButton;
import dto.OrderDto;

public class OrderTm {

    private String orderId;
    private String itemName;
    private String description;
    private String category;
    private String date;
    private String status;
    private  String contact;
    private String Cname;
    private String email;

    private JFXButton btn;
    public OrderTm() {
    }

    public OrderTm(String orderId, String itemName, String description, String category, String date, String status, String contact, String Cname, String email, JFXButton btn) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.date = date;
        this.status = status;
        this.contact = contact;
        this. Cname = Cname;
        this.email = email;
        this.btn = btn;
    }

    public OrderTm(String orderId, String itemName, String description, String category, String date, String status, String contact, String cname, String email) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.date = date;
        this.status = status;
        this.contact = contact;
        Cname = cname;
        this.email = email;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String Cname) {
        Cname = Cname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
    }
}
