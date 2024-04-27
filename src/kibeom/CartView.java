package kibeom;

import user.UserRepository;
import util.SimpleInput;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

import static kibeom.CartRepository.getItems;
import static kibeom.CartRepository.item;



public class CartView {

    private static CartRepository cartRepo;
    public static final String RED = "\033[0;31m"; // 콘솔에 색깔 주기
    public static final String RESET = "\033[0m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    public CartView() {
        this.cartRepo = new CartRepository();

    }


    public static void showCartRepository() {

        while (true) {
            System.out.println("============ 장바구니 목록 =============");
            CartRepository.showCartRepository();
            System.out.println("1. 결제하기");
            System.out.println("2. 장바구니 물품 빼기");
            System.out.println("3. 뒤로 가기");
            String num = SimpleInput.input(">> ");


            switch (num) {
                case "1":
                    order();
                    break;
                case "2":
                    deleteItem();
                    break;
                case "3":
                    back = false;
                default:
                    System.out.println("1 ~ 3!");
            }
        }

    }
    private static void order() {
        String itemName = SimpleInput.input("주문 하고 싶은 제품명을 입력해주세요." + BLUE + "\n# 2개 이상 입력 시 쉼표 ', '로 구분해주세요.\n>> " + RESET).trim();
        String[] orderList = null;

        // 아이템 맵을 가져옴
        Map<String, Map<String, Object>> item = CartRepository.getItems();

        if (itemName.contains(",")) {
            orderList = itemName.split(",");
            int sum = 0;
            for (int i = 0; i < orderList.length; i++) {
                // 주문한 상품명이 장바구니에 있는지 확인
                boolean found = false;
                for (String cartItem : item.keySet()) {
                    if (cartItem.trim().equals(orderList[i].trim())) {
                        found = true;
                        int price = (int) item.get(cartItem).get("price");
                        sum += price;
                        break;
                    }
                }
                if (!found) {
                    System.out.println( RED + orderList[i] + " 상품은 장바구니에 없습니다." + RESET);
                }
            }

            System.out.println("현재 소지 금액: " + UserRepository.getUser().getMoney());
            System.out.println("총 주문 가격: " + sum);

            String answer = SimpleInput.input("주문하시겠습니까? Y / N\n>> ").toUpperCase();
            switch (answer) {
                case "Y":
                    if (UserRepository.getUser().getMoney() >= sum) {
                        int currentMoney = UserRepository.getUser().getMoney() - sum;
                        UserRepository.getUser().setMoney(currentMoney);
                        System.out.println("감사합니다. 주문이 완료 되었습니다.\n현재 소지 금액: " + currentMoney);
                        System.out.println("배송지 정보 : "  + UserRepository.getUser().getAddress());
                        System.out.println("공휴일 제외, 영업일 기준 1 ~ 3 일 이내 배송됩니다.");
                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                    break;
                case "N":
                    break;
                default:
                    System.out.println("제대로 입력하세요.");
            }
        } else {
            System.out.println("현재 소지 금액: " + UserRepository.getUser().getMoney());
            int price = (int) item.get(itemName).get("price");
            System.out.println("총 주문 가격: " + price);

            String answer = SimpleInput.input("주문하시겠습니까? Y / N\n>> ").toUpperCase();
            switch (answer) {
                case "Y":
                    if (UserRepository.getUser().getMoney() >= price) {
                        int currentMoney = UserRepository.getUser().getMoney() - price;
                        UserRepository.getUser().setMoney(currentMoney);
                        System.out.println("감사합니다. 주문이 완료 되었습니다.\n현재 소지 금액: " + currentMoney);
                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                    break;
                case "N":
                    break;
                default:
                    System.out.println("제대로 입력하세요.");
            }
        }
    }





    public static void deleteItem() {
//        String num = SimpleInput.input("삭제 하고 싶은 제품의 번호를 입력해주세요\n>> ");
        String itemName = SimpleInput.input("삭제 하고 싶은 제품명을 입력해주세요.\n>> ");

        // itemName 탐색

        if (item.containsKey(itemName)) {
            System.out.println(itemName + "\n" + getItems().get(itemName));
            System.out.println("1. 삭제하기");
            System.out.println("2. 취소하기");
            String answer = SimpleInput.input(">>\n ");
            if (answer.equals("1")) {
                item.remove(itemName);
                System.out.println(itemName + " 항목이 삭제되었습니다.");
            } else if (answer.equals("2")) {
                System.out.println("실행을 취소합니다.");
            } else {
                System.out.println("1 ~ 2");
            }
        } else {
            System.out.println(itemName + " 항목이 존재하지 않습니다.");
        }
    }
}
/*

    // 전체 도서 정보를 출력
    private void displayAllBooks() {
        System.out.println("\n=============== 전체 도서 목록 ================");
        Book[] informationList = repository.getAllBooksInfo();

        for (int i = 0; i < informationList.length; i++) {
            Book book = informationList[i];
            System.out.printf("%d. %s\n", i+1, book.info());
        }

 */
