//package entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "orderdata")
//public class OrderData {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    private String code;
//
//
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Orders order;
//
//    public OrderData(String code, double partsPrice, double sc, double totalAmount, Orders orders) {
//    }
//
//    public OrderData(String code, double partsPrice, double sc, double totalAmount) {
//
//        this.code = code;
//        this.partsPrice = partsPrice;
//        this.sc = sc;
//        this.totalAmount = totalAmount;
//    }
//
//    public OrderData(String oId, String code, double partsPrice, double sc, double totalAmount, Orders order) {
//
//        this.code = code;
//        this.partsPrice = partsPrice;
//        this.sc = sc;
//        this.totalAmount = totalAmount;
//
//    }
//
//    public OrderData(Long id, String code, double partsPrice, double sc, double totalAmount, Orders order) {
//        this.id = id;
//        this.code = code;
//        this.partsPrice = partsPrice;
//        this.sc = sc;
//        this.totalAmount = totalAmount;
//        this.order = order;
//    }
//
//    public OrderData() {
//
//    }
//
//    public Orders getOrder() {
//        return order;
//    }
//
//    public void setOrder(Orders order) {
//        this.order = order;
//    }
//
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public double getPartsPrice() {
//        return partsPrice;
//    }
//
//    public void setPartsPrice(double partsPrice) {
//        this.partsPrice = partsPrice;
//    }
//
//    public double getSc() {
//        return sc;
//    }
//
//    public void setSc(double sc) {
//        this.sc = sc;
//    }
//
//    public double getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(double totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//}
