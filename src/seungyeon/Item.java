package seungyeon;

public class Item {

    private String brand;
    private String itemName;
    private String type;
    private int price;
    private String gender;

    public Item(String brand, String itemName, String type, int price, String gender) {
        this.brand = brand;
        this.itemName = itemName;
        this.type = type;
        this.price = price;
        this.gender = gender;
    }

    // Getter methods...


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getGender() {
        return gender;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", gender='" + gender + '\'' +
                '}';
    }
}

