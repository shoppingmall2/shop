package jihye;

import java.util.ArrayList;
import java.util.List;

// 상품 구매 목록 담는 레포지토리
public class DeliveryRepository {

    public static final List<Buy> buyList = new ArrayList<>();

    static {
        buyList.add(new Buy("나이키", "에어포스", 150000, "서울시 마포구"));
        buyList.add(new Buy("에잇세컨즈", "푸바오 반팔티", 49000, "서울시 서대문구"));
        buyList.add(new Buy("LAP", "실버 숄더백", 99000, "고양시 덕양구"));
    }

    public static void buyList(String brand, String productName, int orderTotalValue, String address) {

    }
}
