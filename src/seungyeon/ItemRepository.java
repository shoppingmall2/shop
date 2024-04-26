package seungyeon;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository {
    private Map<String, Map<String, Object>> item;

    public ItemRepository() {
        item = new HashMap<>();
        // 상품 초기화
        addItem("crocs", "SHOES", 40000, "unisex");
        addItem("t-shirt", "TOP", 20000, "male");
        addItem("nikeAirForce", "SHOES", 80000, "unisex");
        addItem("jean", "BOTTOM", 30000, "unisex");
        addItem("riderJacket", "TOP", 90000, "male");
        addItem("poloCap", "cap", 60000, "unisex");
    }

    public void addItem(String itemName, String type, int price, String gender) {
        Map<String, Object> itemDetails = new HashMap<>();
        itemDetails.put("type", type);
        itemDetails.put("price", price);
        itemDetails.put("gender", gender);
        item.put(itemName, itemDetails);
    }

    public Map<String, Map<String, Object>> getItems() {
        return item;
    }

    public ItemRepository(Map<String, Map<String, Object>> item) {
        this.item = item;
    }

    public Map<String, Map<String, Object>> getItem() {
        return item;
    }

    public void setItem(Map<String, Map<String, Object>> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "CartRepository{" +
                "item=" + item +
                '}';
    }

}