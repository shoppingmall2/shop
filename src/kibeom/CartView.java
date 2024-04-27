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

    public CartView() {
        this.cartRepo = new CartRepository();

    }


    public static void showCartRepository() {

        while (true) {
            System.out.println("============ 장바구니 목록 =============");
            CartRepository.showCartRepository();
        System.out.println("1. 결제하기");
        System.out.println("2. 장바구니 물품 빼기");
        String num = SimpleInput.input("\n>> ");


            switch (num) {
                case "1":
                    order();
                    break;
                case "2":
                    deleteItem();
                    break;
                default:
                    System.out.println("1 ~ 2!");
            }
        }

    }
    private static void order() {
        String itemName = SimpleInput.input("주문 하고 싶은 제품명을 입력해주세요.\n# 2개 이상 입력 시 쉼표 ', '로 구분해주세요.\n>> ").trim();
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
                    System.out.println(orderList[i] + " 상품은 장바구니에 없습니다.");
                }
            }

            System.out.println("현재 소지 금액: " + UserRepository.getUser().getMoney());
            System.out.println("총 주문 가격: " + sum);
        } else {
            System.out.println("현재 소지 금액: " + UserRepository.getUser().getMoney());
            System.out.println("총 주문 가격: " + item.get(itemName).get("price"));
        }
        String answer = SimpleInput.input("주문하시겠습니까? Y / N\n>> ").toUpperCase();
        switch (answer) {
            case "Y":
//                UserRepository.getUser().setMoney();
                System.out.println("감사합니다. 주문이 완료 되었습니다.\n현재 소지 금액: ");
                break;
            case "N":
                break;
            default:
                System.out.println("제대로 입력하세요.");
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
