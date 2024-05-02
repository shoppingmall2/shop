package jihye;

import java.util.Calendar;

public class Buy {

    // 구매한 목록을 위한 상품 정보 하나하나
    private String brand;  // 브랜드명
    private String productName;   // 상품명
    private int orderTotalValue;    // 가격
    private String address;      // 주소
    private String orderTime; // 주문시간

    public Buy(String brand, String productName, int orderTotalValue, String address) {
        this.brand = brand;
        this.productName = productName;
        this.orderTotalValue = orderTotalValue;
        this.address = address;
        this.orderTime = orderTime();
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public static String orderTime() {
        Calendar currentTime = Calendar.getInstance();
        int year = currentTime.get(Calendar.YEAR);
        int month = currentTime.get(Calendar.MONTH) + 1; // 월은 0부터 시작하므로 +1
        int day = currentTime.get(Calendar.DAY_OF_MONTH);
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);
        int second = currentTime.get(Calendar.SECOND);
        return "주문 시간: " + year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getOrderTotalValue() {
        return orderTotalValue;
    }

    public void setOrderTotalValue(int orderTotalValue) {
        this.orderTotalValue = orderTotalValue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "brand='" + brand + '\'' +
                ", productName='" + productName + '\'' +
                ", orderTotalValue=" + orderTotalValue +
                ", address='" + address + '\'' +
                '}';
    }
}