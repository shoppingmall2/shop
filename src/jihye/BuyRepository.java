package jihye;

import java.util.ArrayList;
import java.util.List;

public class BuyRepository {

    static List<Buy> itemList = new ArrayList<>();

    // 상품 추가 메서드
    public static void addItem(String itemName, String type, int price, String gender) {
        Buy item = new Buy(itemName, type, price, gender);
        itemList.add(item);
    }

    // 모든 상품 정보 반환 메서드
    public static List<Buy> getAllItems() {
        return itemList;
    }

    // 상품 이름으로 상품 정보 찾기 메서드
    public static Buy getItemByName(String itemName) {
        for (Buy item : itemList) {
            if (item.getProductName().equals(itemName)) {
                return item;
            }
        }
        return null; // 해당 상품명을 가진 상품이 없을 경우 null 반환
    }
}
