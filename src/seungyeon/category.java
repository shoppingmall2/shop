package seungyeon;

import user.UserLoginView;

import java.util.Map;
import java.util.Scanner;

public class category {
        // ItemRepository 객체 생성
    public static void openCate() {
        ItemRepository itemRepository = new ItemRepository();
        // Search 객체 생성
        Search search = new Search(itemRepository);
        // RankingRepository 객체 생성
        RankingRepository rankingRepository = new RankingRepository(itemRepository);
        // RankingView 객체 생성
        RankingView rankingView = new RankingView();

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("1. 제품 검색하기");
            System.out.println("2. 제품 랭킹 보기");
            System.out.println("3. 뒤로가기\n");
            System.out.print("메뉴를 선택하세요: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // 아이템 검색하기
                    searchItem(search, scanner);
                    break;
                case "2":
                    // 상위 10개 아이템 랭킹 보기 - 입력할때마다 랜덤
                    System.out.print("\n");
                    displayTopRankings(rankingRepository, rankingView);
                    break;
                case "3":
                    UserLoginView userLoginView = new UserLoginView();
                    userLoginView.mainPage();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        } while (!choice.equals("3"));

        scanner.close();
    }
    // 제품 검색 기능
    public static void searchItem(Search search, Scanner scanner) {
        String itemName;

        do {
            // 사용자로부터 검색할 상품의 이름을 입력 받음
            System.out.print("\n검색 할 상품의 이름을 입력하세요.\n (exit 입력 시 검색 종료)\n\n>> ");
            itemName = scanner.nextLine();
            System.out.print("\n");

            // 만약 상품 이름이 "exit"이면 종료
            if (itemName.equalsIgnoreCase("exit")) {
                break;
            }

            // 검색한 상품 출력
            search.searchItemByName(itemName);
        } while (true);
    }

    // 제품 랭킹 보기 메뉴 기능
    public static void displayTopRankings(RankingRepository rankingRepository, RankingView rankingView) {
        // 상위 10개 랭킹 출력 / 항상 랜덤
        Map<String, Integer> topRankings = rankingRepository.getTopRankings(10);
        rankingView.displayTopRankings(topRankings);
    }
}
