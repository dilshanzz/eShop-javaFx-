package dto.tm;

import com.jfoenix.controls.JFXButton;

import javax.persistence.Entity;
import javax.persistence.Id;


public class PartTm {

    private String code;
    private String name;
    private double price;

    private JFXButton btn;

    public PartTm() {
    }

    public PartTm(String code, String name, double price,JFXButton btn) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.btn = btn;
    }

    public PartTm(String code) {
        this.code = code;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
    }
}
