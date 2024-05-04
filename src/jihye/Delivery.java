package jihye;

public enum Delivery {
    ORDERED("주문 확인 중", "✅"), READY("물품 출고 중", "\uD83D\uDCE6"), DELIVERED("배송 중", "\uD83D\uDE9A"),
    CLEAR("배송 완료", "\uD83D\uDCE6");

    private String description;
    private String timeToSetup;


    Delivery(String description, String  timeToSetup) {
        this.description = description;
        this.timeToSetup = timeToSetup;
    }

    public String  getTimeToSetup() {
        return timeToSetup;
    }

    public String getDescription() {
        return description;
    }
}
