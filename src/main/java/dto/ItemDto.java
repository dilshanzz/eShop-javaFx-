package dto;

public class ItemDto {
    private  String name;
    private String category;
    private int quantity;

    public ItemDto(){}



    public ItemDto(String name, String category, int quantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQauantity(int quantity) {
        this.quantity = quantity;
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




}
