package jihye;

import kibeom.Cart;
import user.User;

import java.util.ArrayList;
import java.util.List;

import static user.UserRepository.getUser;

public class BuyRepository {

    static List<Buy> itemList = new ArrayList<>();

    // 상품 추가 메서드
    public static void addItem(String itemName, String type, int price, String gender) {
        Buy item = new Buy(itemName, type, price, gender);
        itemList.add(item);
    }
    public static void addCartList(Buy buy) {
        getUser().getBuylist().add(buy); // 해당 사용자의 장바구니에 상품 추가
    }
    // 모든 상품 정보 반환 메서드
    public static List<Buy> getAllItems() {
        return itemList;
    }

    public static void addBuy(Buy buy) {
        itemList.add(buy);
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
