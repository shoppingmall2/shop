package seungyeon;

import java.util.Map;
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

import java.util.List;

public class RankingView {
    public void displayTopRankings(List<Item> topRankings) {
        System.out.println("     \uD83C\uDFC6 Top 10 Rankings \uD83C\uDFC6");
        int rank = 1;
        for (Item item : topRankings) {
            System.out.println(rank + ". " + "제품명: " + item.getItemName() + " - 가격: " + item.getPrice());
            rank++;
        }
        //System.out.print("\n");
    }
}
