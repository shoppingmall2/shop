package seungyeon;

import java.util.*;
//
//public class RankingView {
//    public void displayTopRankings(Map<String, Integer> topRankings) {
//        System.out.println("Top 10 Rankings:");
//        int rank = 1;
//        for (String itemName : topRankings.keySet()) {
//            int price = topRankings.get(itemName);
//            System.out.println(rank + ". " + itemName + " - Price: " + price);
//            rank++;
//        }
//        System.out.print("\n");
//    }
//}


public class RankingView {
    public void displayTopRankings(List<Item> topRankings) {
        Set<Item> top10Item = new HashSet<>(topRankings);

        List<Item> top10ItemList = new ArrayList<>(top10Item);

        int size = Math.min(top10ItemList.size(), 10);

        System.out.println("Top 10 Rankings:");

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            // 아이템 랜덤 선택
            int randomIndex = random.nextInt(top10ItemList.size());
            Item randomItem = top10ItemList.get(randomIndex);
            System.out.println((i + 1) + ". " + randomItem.getItemName() + " - Price: " + randomItem.getPrice());

            top10ItemList.remove(randomIndex);
        }
        System.out.println();

//        int rank = 1;
//        for (Item item : topRankings) {
//            System.out.println(rank + ". " + item.getItemName() + " - Price: " + item.getPrice());
//            rank++;
//
//        }

//        System.out.print("\n");
    }
}
