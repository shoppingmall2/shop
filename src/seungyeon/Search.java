package seungyeon;
//
//import kibeom.CartRepository;
//
//import java.util.Map;
//
//public class Search {
//    private ItemRepository itemRepository;
//    private CartRepository cartRepository;
//
//    public Search(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//        this.cartRepository = cartRepository;
//    }
//
//    public boolean searchItemByName(String itemName) {
//        Map<String, Map<String, Object>> items = itemRepository.getItems();
//        boolean found = false; // 제품을 찾았는지 여부
//        int count = 0; // 제품 번호
//
//
//        for (String name : items.keySet()) {
//            // 대소문자 구분 없이 검색하므로 모두 소문자로 변환하여 비교
//            if (name.toLowerCase().contains(itemName.toLowerCase())) {
//                found = true;
//                count++;
//                if (count > 1) {
//                    // 첫 번째 제품 이후에는 빈 줄 추가
//                    System.out.println();
//                }
//                Map<String, Object> itemDetails = items.get(name);
////                System.out.println("Item.java " + count + ":");
//                System.out.println(count+". " + name);
//                System.out.println("상품 가격: " +  itemDetails.get("price")+ "원");
//                System.out.println("상품 분류: " + itemDetails.get("type"));
//                System.out.println("성별: " + itemDetails.get("gender"));
//            }
//        }
//
////        if (!found) {
////            System.out.println("입력한 제품을 찾을 수 없습니다.\n");
////        }
//        return found;
//
//
//
//
//    }
//}

import java.util.List;

import static seungyeon.ItemRepository.items;

public class Search {
    private ItemRepository itemRepository;

    public Search(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public boolean searchItemByName(String itemName) {
//        List<Item> items = ItemRepository.getItems();
        boolean found = false;
        int count = 0;

        for (Item item : items) {
            if (item.getItemName().toLowerCase().contains(itemName.toLowerCase())) {
                found = true;
                count++;
                if (count > 1) {
                    System.out.println();
                }
                System.out.println(count + ". " + item.getItemName());
                System.out.println("상품 가격: " + item.getPrice() + "원");
                System.out.println("상품 분류: " + item.getType());
                System.out.println("성별: " + item.getGender());
            }
        }

        return found;
    }
}

