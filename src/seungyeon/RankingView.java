package seungyeon;

import java.util.Map;

public class RankingView {
    public void displayTopRankings(Map<String, Integer> topRankings) {
        System.out.println("Top 10 Rankings:");
        int rank = 1;
        for (String itemName : topRankings.keySet()) {
            int price = topRankings.get(itemName);
            System.out.println(rank + ". " + itemName + " - Price: " + price);
            rank++;
        }
        System.out.print("\n");
    }
}
