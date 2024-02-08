package dto;

public class OrderDataDto {
    private String code;
    private double partsPrice;
    private double sc;
    private double totalAmount;





    public OrderDataDto(String code, double partsPrice, double sc, double totalAmount) {
        this.code = code;
        this.partsPrice = partsPrice;
        this.sc = sc;
        this.totalAmount = totalAmount;
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
