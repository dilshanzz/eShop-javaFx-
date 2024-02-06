package dto.tm;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemTm {
    private  String name;
    private String category;
    private int quantity;
    private String url;
    private JFXButton btn;
    public ItemTm(){}




    public ItemTm(String name, String category, int quantity,  JFXButton btn) {
        this.name = name;
        this.category = category;
        this. quantity = quantity;
        this.btn = btn;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQauantity(int quantity) {
        this.quantity = quantity;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
