package jihye;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Buy {

    // 구매한 목록을 위한 상품 정보 하나하나
    private String brand;  // 브랜드명
    private String productName;   // 상품명
    private int orderTotalValue;    // 가격
    private String address;      // 주소
    private LocalDateTime orderTime; // 주문시간

    public Buy(String brand, String productName, int orderTotalValue, String address) {
        this.brand = brand;
        this.productName = productName;
        this.orderTotalValue = orderTotalValue;
        this.address = address;
        this.orderTime = LocalDateTime.now();
    }

    public String formatDate() {
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.orderTime.format(simpleDateFormat);
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Delivery isDeliveryStarted() {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(this.orderTime, currentTime);
        long secondsPassed = duration.getSeconds();
        if (secondsPassed > 0 && secondsPassed < 20 ) {
            return Delivery.ORDERED;
        } else if (secondsPassed >= 20 && secondsPassed < 30) {
            return Delivery.READY;
        } else if (secondsPassed >= 30 && secondsPassed < 40) {
            return  Delivery.DELIVERED;
        } else {
            return Delivery.CLEAR;
        }
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