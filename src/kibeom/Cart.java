package kibeom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cart {

    private String brand;
    private String itemName;
    private String type;
    private int price;
    private String gender;



    public Cart(String brand, String itemName, String type, int price, String gender) {
        this.brand = brand;
        this.itemName = itemName;
        this.type = type;
        this.price = price;
        this.gender = gender;

    }



    public Cart() {
    }


    @Override
    public String toString() {
        return "Cart{" +
                "brand='" + brand + '\'' +
                ", itemName='" + itemName + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
