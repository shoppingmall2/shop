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
    private List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
        // 상품 초기화
        addItem(new Item("crocs", "SHOES", 40000, "unisex"));
        addItem(new Item("nikeAirForce", "SHOES", 80000, "unisex"));
        addItem(new Item("jean", "BOTTOM", 30000, "unisex"));
        addItem(new Item("riderJacket", "TOP", 90000, "male"));
        addItem(new Item("poloCap", "CAP", 60000, "unisex"));
        addItem(new Item("Zara Coat", "OUTERWEAR", 90000, "unisex"));
        addItem(new Item("Uniqlo Sweater", "TOP", 45000, "unisex"));
        addItem(new Item("Levi's Jeans", "BOTTOM", 35000, "unisex"));
        addItem(new Item("Gucci Scarf", "ACCESSORY", 15000, "unisex"));
        addItem(new Item("Louis Vuitton Belt", "ACCESSORY", 25000, "unisex"));
        addItem(new Item("Prada Wallet", "ACCESSORY", 35000, "unisex"));
        addItem(new Item("Adidas Hoodie", "TOP", 50000, "unisex"));
        addItem(new Item("Nike Sneakers", "SHOES", 60000, "unisex"));
        addItem(new Item("H&M Dress", "DRESS", 70000, "female"));
        addItem(new Item("Rolex Watch", "ACCESSORY", 30000, "unisex"));
        addItem(new Item("Balenciaga Sunglasses", "ACCESSORY", 20000, "unisex"));
        addItem(new Item("North Face Backpack", "BAG", 40000, "unisex"));
        addItem(new Item("Zara Coat", "OUTERWEAR", 90000, "unisex"));
        addItem(new Item("Uniqlo Sweater", "TOP", 45000, "unisex"));
        addItem(new Item("Levi's Jeans", "BOTTOM", 35000, "unisex"));
        addItem(new Item("Gucci Scarf", "ACCESSORY", 15000, "unisex"));
        addItem(new Item("Louis Vuitton Belt", "ACCESSORY", 25000, "unisex"));
        addItem(new Item("Prada Wallet", "ACCESSORY", 35000, "unisex"));
        addItem(new Item("Calvin Klein T-shirt", "TOP", 25000, "male"));
        addItem(new Item("Puma Joggers", "BOTTOM", 40000, "male"));
        addItem(new Item("Tommy Hilfiger Polo Shirt", "TOP", 45000, "male"));
        addItem(new Item("Under Armour Hoodie", "TOP", 55000, "male"));
        addItem(new Item("New Balance Running Shoes", "SHOES", 70000, "male"));
        addItem(new Item("Givenchy Hoodie", "TOP", 70000, "male"));
        addItem(new Item("Louis Vuitton Sneakers", "SHOES", 90000, "unisex"));
        addItem(new Item("Gucci Bag", "BAG", 180000, "female"));
        addItem(new Item("Givenchy Hoodie", "TOP", 130000, "male"));
        addItem(new Item("Chanel Bag", "BAG", 400000, "female"));
        addItem(new Item("Burberry Trench Coat", "OUTERWEAR", 300000, "unisex"));
        addItem(new Item("crocs", "SHOES", 40000, "unisex"));

        // 나머지 상품들 추가...
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
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
