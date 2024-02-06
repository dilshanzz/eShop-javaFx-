package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UsedParts {
    @Id
    private String code;
    private String name;
    private int qty;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    public UsedParts() {
    }

    public UsedParts(String code, String name, int qty, double price, Orders order) {
        this.code = code;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.order = order;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
