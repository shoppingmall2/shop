package seungyeon;

import java.util.Map;

public class Search {
    private ItemRepository itemRepository;

    public Search(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public boolean searchItemByName(String itemName) {
        Map<String, Map<String, Object>> items = itemRepository.getItems();
        boolean found = false; // 제품을 찾았는지 여부
        int count = 0; // 제품 번호


        for (String name : items.keySet()) {
            // 대소문자 구분 없이 검색하므로 모두 소문자로 변환하여 비교
            if (name.toLowerCase().contains(itemName.toLowerCase())) {
                found = true;
                count++;
                if (count > 1) {
                    // 첫 번째 제품 이후에는 빈 줄 추가
                    System.out.println();
                }
                Map<String, Object> itemDetails = items.get(name);
                System.out.println("Item " + count + ":");
                System.out.println("Name: " + name);
                System.out.println("Type: " + itemDetails.get("type"));
                System.out.println("Price: " + itemDetails.get("price"));
                System.out.println("Gender: " + itemDetails.get("gender"));
            }
        }

        if (!found) {
            System.out.println("입력한 제품을 찾을 수 없습니다.\n");
        }
        return found;
    }
}
