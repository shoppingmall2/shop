package jihye;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static kibeom.CartRepository.item;

// 상품 구매 목록 담는 레포지토리
public class DeliveryRepository {


    static Map<String, Map<String, Object>> item;
    static Map<String, Map<String, Object>> buyitem;

    public DeliveryRepository() {
        item = new HashMap<>();
        // 상품 초기화
        addItem("crocs", "SHOES", 40000, "unisex");
        addItem("t-shirt", "TOP", 20000, "male");
        addItem("nikeAirForce", "SHOES", 80000, "unisex");
        addItem("jean", "BOTTOM", 30000, "unisex");
        addItem("riderJacket", "TOP", 90000, "male");
        addItem("poloCap", "CAP", 60000, "unisex");

        buyitem = new HashMap<>();

    }


//    public HashMap buy(String temp) {
//        for (Map<String, Object> value : item.values()) {
//            if (value.equals(temp)) {
//                return (HashMap) value;
//            }
//        }
//        return null;
//    }
//    public static void getItem () {
//        for (String s : item.keySet()) {
//            System.out.println("s = " + s);
//        }
//    }

    public static final List<Buy> buyList = new ArrayList<>();

    static {
        buyList.add(new Buy("나이키", "air force", 150000, "서울시 마포구 염리동 35"));
        buyList.add(new Buy("에잇세컨즈", "푸바오 반팔티", 49000, "서울시 서대문구 연세로 50"));
    }

    public static void buyList(String brand, String productName, int orderTotalValue, String address) {
        
    }

    public static void showPurchaseList(String itemName) {
        System.out.println(itemName);
    }

    public void addItem(String itemName, String type, int price, String gender) {
        Map<String, Object> itemDetails = new HashMap<>();
        itemDetails.put("type", type);
        itemDetails.put("price", price);
        itemDetails.put("gender", gender);

        item.put(itemName, itemDetails);
    }


}