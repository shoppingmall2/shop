package jihye;

public class Buy {

    // 구매한 목록을 위한 상품 정보 하나하나
    private String itemName;  // 브랜드명
    private String type;   // 상품명
    private int price;    // 가격
    private String gender;      // 주소

    public Buy(String itemName, String type, int price, String gender) {
        this.itemName = itemName;
        this.type = type;
        this.price = price;
        this.gender = gender;
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

    @Override
    public String toString() {
        return "Buy{" +
                "itemName='" + itemName + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", gender='" + gender + '\'' +
                '}';
    }
}
