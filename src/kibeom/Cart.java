package kibeom;

public class Cart {

    private String itemName;
    private String type;
    private int price;
    private String gender;


    public Cart(String itemName, String type, int price, String gender) {
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
                "itemName='" + itemName + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", gender='" + gender + '\'' +
                '}';
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
