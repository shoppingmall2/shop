package seungyeon;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//public class ItemRepository {
//    private Map<String, Map<String, Object>> item;
//
//    public ItemRepository() {
//        item = new HashMap<>();
//        // 상품 초기화
//        addItem("crocs", "SHOES", 40000, "unisex");
//        addItem("t-shirt", "TOP", 20000, "male");
//        addItem("nikeAirForce", "SHOES", 80000, "unisex");
//        addItem("jean", "BOTTOM", 30000, "unisex");
//        addItem("riderJacket", "TOP", 90000, "male");
//        addItem("poloCap", "CAP", 60000, "unisex");
//        addItem("Zara Coat", "OUTERWEAR", 90000, "unisex");
//        addItem("Uniqlo Sweater", "TOP", 45000, "unisex");
//        addItem("Levi's Jeans", "BOTTOM", 35000, "unisex");
//        addItem("Gucci Scarf", "ACCESSORY", 15000, "unisex");
//        addItem("Louis Vuitton Belt", "ACCESSORY", 25000, "unisex");
//        addItem("Prada Wallet", "ACCESSORY", 35000, "unisex");
//        addItem("Adidas Hoodie", "TOP", 50000, "unisex");
//        addItem("Nike Sneakers", "SHOES", 60000, "unisex");
//        addItem("H&M Dress", "DRESS", 70000, "female");
//        addItem("Rolex Watch", "ACCESSORY", 30000, "unisex");
//        addItem("Balenciaga Sunglasses", "ACCESSORY", 20000, "unisex");
//        addItem("North Face Backpack", "BAG", 40000, "unisex");
//        addItem("Zara Coat", "OUTERWEAR", 90000, "unisex");
//        addItem("Uniqlo Sweater", "TOP", 45000, "unisex");
//        addItem("Levi's Jeans", "BOTTOM", 35000, "unisex");
//        addItem("Gucci Scarf", "ACCESSORY", 15000, "unisex");
//        addItem("Louis Vuitton Belt", "ACCESSORY", 25000, "unisex");
//        addItem("Prada Wallet", "ACCESSORY", 35000, "unisex");
//        addItem("Calvin Klein T-shirt", "TOP", 25000, "male");
//        addItem("Puma Joggers", "BOTTOM", 40000, "male");
//        addItem("Tommy Hilfiger Polo Shirt", "TOP", 45000, "male");
//        addItem("Under Armour Hoodie", "TOP", 55000, "male");
//        addItem("New Balance Running Shoes", "SHOES", 70000, "male");
//        addItem("Givenchy Hoodie", "TOP", 70000, "male");
//        addItem("Louis Vuitton Sneakers", "SHOES", 90000, "unisex");
//        addItem("Gucci Bag", "BAG", 180000, "female");
//        addItem("Givenchy Hoodie", "TOP", 130000, "male");
//        addItem("Chanel Bag", "BAG", 400000, "female");
//        addItem("Burberry Trench Coat", "OUTERWEAR", 300000, "unisex");
//        addItem("Hermes Scarf", "ACCESSORY", 150000, "unisex");
//        addItem("Louis Vuitton Sunglasses", "ACCESSORY", 180000, "unisex");
//        addItem("Gucci Dress", "DRESS", 300000, "female");
//        addItem("Armani Suit", "SUIT", 600000, "male");
//        addItem("Gucci Dress", "DRESS", 250000, "female");
//        addItem("Armani Suit", "SUIT", 500000, "male");
//// 나머지 상품들도 같은 방식으로 브랜드명과 함께 추가할 수 있습니다.
//
//    }
//
//    public void addItem(String itemName, String type, int price, String gender) {
//        Map<String, Object> itemDetails = new HashMap<>();
//        itemDetails.put("type", type);
//        itemDetails.put("price", price);
//        itemDetails.put("gender", gender);
//        item.put(itemName, itemDetails);
//    }
//
//
//
//
//
//    public Map<String, Map<String, Object>> getItems() {
//        return item;
//    }
//
//    public ItemRepository(Map<String, Map<String, Object>> item) {
//        this.item = item;
//    }
//
//    public Map<String, Map<String, Object>> getItem() {
//        return item;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ItemRepository that = (ItemRepository) o;
//        return Objects.equals(item, that.item);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(item);
//    }
//
//    @Override
//    public String toString() {
//        return "CartRepository{" +
//                "item=" + item +
//                '}';
//    }
//}

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    public static List<Item> items;

    public  ItemRepository() {
        items = new ArrayList<>();
        // 상품 초기화
        addItem(new Item("Nike", "AirForce", "SHOES", 39900, "unisex"));
        addItem(new Item("Adidas", "Superstar", "SHOES", 44900, "unisex"));
        addItem(new Item("Reebok", "Classic", "SHOES", 37900, "unisex"));
        addItem(new Item("Vans", "OldSkool", "SHOES", 32900, "unisex"));
        addItem(new Item("Converse", "ChuckTaylor", "SHOES", 39900, "unisex"));
        addItem(new Item("New Balance", "574", "SHOES", 39900, "unisex"));
        addItem(new Item("Puma", "Suede", "SHOES", 35900, "unisex"));
        addItem(new Item("Under Armour", "UA Charged Assert 8", "SHOES", 44900, "unisex"));
        addItem(new Item("Skechers", "Go Walk 5", "SHOES", 29900, "unisex"));
        addItem(new Item("Crocs", "Classic Clog", "SHOES", 29900, "unisex"));
        addItem(new Item("Levi's", "501", "BOTTOM", 69900, "unisex"));
        addItem(new Item("H&M", "Skinny Jeans", "BOTTOM", 32990, "female"));
        addItem(new Item("Zara", "Cargo Pants", "BOTTOM", 39900, "unisex"));
        addItem(new Item("Nike", "Tech Fleece Joggers", "BOTTOM", 44900, "male"));
        addItem(new Item("Forever 21", "Mini Skirt", "BOTTOM", 29900, "female"));
        addItem(new Item("Uniqlo", "Chino Shorts", "BOTTOM", 29900, "unisex"));
        addItem(new Item("H&M", "Hoodie", "TOP", 32990, "unisex"));
        addItem(new Item("Gap", "Polo Shirt", "TOP", 29900, "male"));
        addItem(new Item("Zara", "Blouse", "TOP", 29900, "female"));
        addItem(new Item("Nike", "Dry Fit T-shirt", "TOP", 32900, "unisex"));
        addItem(new Item("Adidas", "Track Jacket", "TOP", 39900, "unisex"));
        addItem(new Item("Polo Ralph Lauren", "Baseball Cap", "CAP", 29900, "unisex"));
        addItem(new Item("The North Face", "Beanie", "CAP", 29900, "unisex"));
        addItem(new Item("Gucci", "Bucket Hat", "CAP", 49900, "unisex"));
        addItem(new Item("Supreme", "Snapback", "CAP", 49900, "unisex"));
        addItem(new Item("Burberry", "Newsboy Cap", "CAP", 59900, "unisex"));
        addItem(new Item("Canada Goose", "Down Parka", "OUTERWEAR", 139900, "unisex"));
        addItem(new Item("Moncler", "Puffer Jacket", "OUTERWEAR", 169900, "unisex"));
        addItem(new Item("Patagonia", "Fleece Jacket", "OUTERWEAR", 99900, "unisex"));
        addItem(new Item("Arc'teryx", "Gore-Tex Shell", "OUTERWEAR", 299900, "unisex"));
        addItem(new Item("Columbia", "Rain Jacket", "OUTERWEAR", 79900, "unisex"));
        // 나머지 상품들 추가...
    }

    private static List<String> itemsInCart = new ArrayList<>();

    //오류나면삭제
    public static boolean addItemByIndex(int i) {
        return false;
    }


    public void addItem(Item item) {
        items.add(item);
    }

    public static List<Item> getItems() {
        return items;
    }

    public static void setItems(List<Item> items) {
        ItemRepository.items = items;
    }

}






// getter methods...


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
