package seungyeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


//
//public class RankingRepository {
//    private ItemRepository itemRepository;
//    private Map<String, Integer> rankings;
//
//    public RankingRepository(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//        rankings = new HashMap<>();
//        // 아이템 랭킹 초기화
//        initializeRankings();
//    }
//
//    private void initializeRankings() {
//        Map<String, Map<String, Object>> items = itemRepository.getItems();
//        for (String itemName : items.keySet()) {
//            Map<String, Object> itemDetails = items.get(itemName);
//            int price = (int) itemDetails.get("price");
//            rankings.put(itemName, price);
//        }
//    }
//
//    // 랜덤으로 상위 N개의 아이템을 가져오는 메서드
//    public Map<String, Integer> getTopRankings(int n) {
//        Map<String, Integer> topRankings = new HashMap<>();
//        List<String> itemNames = new ArrayList<>(rankings.keySet());
//        Random random = new Random();
//
//        for (int i = 0; i < n; i++) {
//            String itemName = itemNames.get(random.nextInt(itemNames.size()));
//            topRankings.put(itemName, rankings.get(itemName));
//        }
//
//        return topRankings;
//    }
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RankingRepository {
    private ItemRepository itemRepository;
    private List<Item> rankings;

    public RankingRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        rankings = new ArrayList<>();
        initializeRankings();
    }

    private void initializeRankings() {
        List<Item> items = itemRepository.getItems();
        for (Item item : items) {
            rankings.add(item);
        }
    }

    public List<Item> getTopRankings(int n) {
        List<Item> topRankings = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            Item item = rankings.get(random.nextInt(rankings.size()));
            topRankings.add(item);
        }

        return topRankings;
    }
}
