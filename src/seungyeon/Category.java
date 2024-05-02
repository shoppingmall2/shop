package seungyeon;
//
import kibeom.CartRepository;
import user.UserLoginView;
//
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//
//public class category {
//        // ItemRepository 객체 생성
//    public static void openCate() {
//        ItemRepository itemRepository = new ItemRepository();
//
//        // Search 객체 생성
//        Search search = new Search(itemRepository);
//        // RankingRepository 객체 생성
//        RankingRepository rankingRepository = new RankingRepository(itemRepository);
//        // RankingView 객체 생성
//        RankingView rankingView = new RankingView();
//
////        // Cart 객체 생성
////        Cart cart = new Cart();
//
//        Scanner scanner = new Scanner(System.in);
//        String choice;
//
//        do {
//            System.out.println("1. 제품 검색하기");
//            System.out.println("2. 제품 랭킹 보기");
//            System.out.println("3. 뒤로가기\n");
//            System.out.print("메뉴를 선택하세요: ");
//            choice = scanner.nextLine();
//
//            switch (choice) {
//                case "1":
//                    // 아이템 검색하기
//                    searchItem(search, scanner);
//                    break;
//                case "2":
//                    // 상위 10개 아이템 랭킹 보기 - 입력할때마다 랜덤
//                    System.out.print("\n");
//                    displayTopRankings(rankingRepository, rankingView);
//                    break;
//                case "3":
//                    UserLoginView userLoginView = new UserLoginView();
//                    userLoginView.mainPage();
//                    break;
//                default:
//                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
//            }
//        } while (!choice.equals("3"));
//
//        scanner.close();
//    }
//    // 제품 검색 기능
//    public static void searchItem(Search search, Scanner scanner) {
//        String itemName;
//
//        do {
//            // 사용자로부터 검색할 상품의 이름을 입력 받음
//            System.out.print("\n검색 할 상품의 이름을 입력하세요.\n (exit 입력 시 검색 종료)\n\n>> ");
//            itemName = scanner.nextLine().trim();
//            System.out.print("\n");
//
//            // 만약 상품 이름이 "exit"이면 종료
//            if (itemName.equalsIgnoreCase("exit")) {
//                break;
//            }
//
//            // 검색한 상품 출력
//            boolean found = search.searchItemByName(itemName);
//
//
//            // 제품이 검색되었을 경우에만 메뉴 표시
//            if (found) {
//                System.out.println("\n1. 제품 장바구니에 넣기");
//                System.out.println("2. 재 검색하기");
//                System.out.println("3. 뒤로가기");
//                System.out.print("\n메뉴를 선택하세요: ");
//                String choice = scanner.nextLine();
//
//                switch (choice) {
//                    case "1":
//                        // 제품 장바구니에 넣기
//
////                        CartRepository.addItem(itemName);
//
//                        System.out.println("제품이 장바구니에 추가되었습니다.");
//
//                        break;
//                    case "2":
//                        // 재 검색하기 - do-while 루프를 다시 실행함
//                        break;
//                    case "3":
//                        // 뒤로가기
//                        return;
//                    default:
//                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
//                        break;
//                }
//            } else {
//                // 제품이 검색되지 않았을 때
//                System.out.println("검색한 제품을 찾을 수 없습니다.");
//            }
//
//        } while (true);
//    }
//
//    // 제품 랭킹 보기 메뉴 기능
//    public static void displayTopRankings(RankingRepository rankingRepository, RankingView rankingView) {
//        // 상위 10개 랭킹 출력 / 항상 랜덤
//        Map<String, Integer> topRankings = rankingRepository.getTopRankings(10);
//        rankingView.displayTopRankings(topRankings);
//    }
//}

import user.UserLoginView;

import java.util.Scanner;

import static kibeom.CartRepository.CartList;
import static kibeom.CartRepository.addNewItem;
import static seungyeon.ItemRepository.items;


public class Category {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    public static void openCate() {
        ItemRepository itemRepository = new ItemRepository();
        Search search = new Search(itemRepository);
        RankingRepository rankingRepository = new RankingRepository(itemRepository);
        RankingView rankingView = new RankingView();

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n============\uD83C\uDFF7\uFE0F제품 카테고리\uD83C\uDFF7\uFE0F============");
            System.out.println("1. 제품 검색하기");
            System.out.println("2. 제품 랭킹 보기");
            System.out.println("3. 뒤로가기");
            System.out.println("========================================");
            System.out.print(">> ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchItem(search, scanner);
                    break;
                case "2":
                    System.out.print("\n");
                    displayTopRankings(rankingRepository, rankingView);
                    break;
                case "3":
                    UserLoginView userLoginView = new UserLoginView();
                    userLoginView.mainPage();
                    break;
                default:
                    System.out.println(RED + "잘못된 메뉴 번호입니다. 다시 선택해주세요." + RESET);
            }
        } while (!choice.equals("3"));

        scanner.close();
    }

    public static void searchItem(Search search, Scanner scanner) {
        String itemName;

        do {
            System.out.print("\n검색 할 상품의 이름을 입력하세요.\n" + BLUE + "(exit 입력 시 검색 종료)" + RESET + "\n>> ");
            itemName = scanner.nextLine().trim();
            //System.out.print("\n");
            if (itemName.equalsIgnoreCase("exit")) {
                break;
            }
            boolean found = search.searchItemByName(itemName);

            if (found) {
                System.out.println("\n1. 제품 장바구니에 넣기");
                System.out.println("2. 재 검색하기");
                System.out.println("3. 뒤로가기");
                System.out.print(">> ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        Cart.addItem(itemName);
                        System.out.println("✨ 제품이 장바구니에 추가되었습니다.");
                        break;
                    case "2":
                        break;
                    case "3":
                        return;
                    default:
                        System.out.println(RED + "잘못된 메뉴 번호입니다. 다시 선택해주세요." + RESET);
                        break;
                }
            } else {
                System.out.println("⚠ 검색한 제품을 찾을 수 없습니다.");
            }
        } while (true);
    }
//
    public static void displayTopRankings(RankingRepository rankingRepository, RankingView rankingView) {
        List<Item> topRankings = rankingRepository.getTopRankings(10);
        rankingView.displayTopRankings((List<Item>) topRankings);
    }
}
