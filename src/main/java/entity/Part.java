package entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity

public class Part {
    @Id
    private String code;
    private String name;
    private double price;

    public Part() {
    }

    public Part(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Part(String code) {
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


}


