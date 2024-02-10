package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UsedParts {
    @Id
    private String code;

    private int qty;
    private  double price;
    @ManyToOne
    @JoinColumn(name = "orderID")
    private OrderData orderData ;


    public UsedParts() {
    }

    public UsedParts(String code, int qty, double price) {
        this.code = code;
        this.qty = qty;
        this.price = price;
    }

    public UsedParts(String code, String name, int qty, double price, OrderData orderData) {
        this.code = code;
        this.qty = qty;
        this.price = price;
        this.orderData = orderData;
    }
}
