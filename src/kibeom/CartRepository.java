package kibeom;
import util.SimpleInput;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CartRepository {
    // 장바구니 물품 관리
    static Map<String, Map<String, Object>> item;

    public CartRepository() {
        item = new HashMap<>();
        // 상품 초기화
        addItem("crocs", "SHOES", 40000, "unisex");
        addItem("t-shirt", "TOP", 20000, "male");
        addItem("nikeAirForce", "SHOES", 80000, "unisex");
        addItem("jean", "BOTTOM", 30000, "unisex");
        addItem("riderJacket", "TOP", 90000, "male");
        addItem("poloCap", "CAP", 60000, "unisex");
    }


    public void addItem(String itemName, String type, int price, String gender) {
        Map<String, Object> itemDetails = new HashMap<>();
        itemDetails.put("type", type);
        itemDetails.put("price", price);
        itemDetails.put("gender", gender);

        item.put(itemName, itemDetails);
    }


    public static void showCartRepository() {
        int num = 1;
        for (String s : item.keySet()) {
            System.out.println(num++ + ". " +  s);
            System.out.println(item.get(s));
        }
    }

    public static Map<String, Map<String, Object>> getItems() {
        return item;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartRepository that = (CartRepository) o;
        return Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(item);
    }

    @Override
    public String toString() {
        return "CartRepository" +
                "item=" + item
                ;
    }
}

/*
        ========= 값에 접근하는 법 =========
        public static void main(String[] args) {

        CartRepository cartRepository = new CartRepository();

        // 장바구니에 담긴 상품 출력
        Map<String, Map<String, Object>> items = cartRepository.getItems();
        for (String s : items.keySet()) {
            System.out.println(items.get(s).get("price"));
        }
    }
 */