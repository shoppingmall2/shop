package kibeom;

import user.UserRepository;
import util.SimpleInput;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        boolean back = true; // 반복문 탈출을 위한 논리값 변수
        while (back) {
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


    /*
    order() 주문하는 메서드
    코드가 긴 이유는 한개만 주문하는 경우와
    한번에 2개 이상 주문하는 경우로 분기가 나뉘어 길어짐
    한번에 2개 이상 주문하는 경우 입력값을 , 를 기준으로 배열에 담고
    그 배열의 인덱스로 item 의 price 에 접근.
    분기가 까다로워서 리팩터링 못하겠음
     */
        private static void order() {
        // 주문할 제품명을 입력 받음
        String itemName = null;
        try {
            itemName = SimpleInput.input("주문 하고 싶은 제품명을 입력해주세요. \n" + BLUE + "(여러 개일 경우 쉼표 ','로 구분)" + RESET + "\n>> ").trim();
        } catch (Exception e) {
            // 예상치 못한 입력 형식에 대한 안내
            System.out.println("입력 예시: crocs, poloCap");
        }

        // 입력값이 null 이라면 사용자가 원하지 않는 입력 형식이므로 안내 출력
        if (itemName == null) {
            System.out.println("입력 예시를 따라주세요.");
            return;
        }

        String[] orderList = null;

        // 장바구니 아이템 맵을 가져옴
        Map<String, Map<String, Object>> item = CartRepository.getItems();

        if (itemName.contains(",")) { // 2개 이상 주문하는 경우
            orderList = itemName.split(",");
            int sum = 0; // 주문 총액을 담을 변수
            for (int i = 0; i < orderList.length; i++) {
                // 주문한 상품명이 장바구니에 있는지 확인
                boolean found = false;
                for (String cartItem : item.keySet()) {
                    if (cartItem.trim().equals(orderList[i].trim())) {
                        found = true;
                        int price = (int) item.get(cartItem).get("price"); // 상품 가격 가져오기
                        sum += price;
                        break;
                    }
                }
                if (!found) {
                    // 장바구니에 없는 상품 알림
                    System.out.println(RED + orderList[i] + " 상품은 장바구니에 없습니다." + RESET);
                }
            }

            // 현재 사용자의 소지금 및 총 주문 가격 출력
            System.out.println("현재 소지 금액: " + UserRepository.getUser().getMoney());
            System.out.println("총 주문 가격: " + sum);

            // 주문 여부 확인
            String answer = SimpleInput.input("주문하시겠습니까? Y / N\n>> ").toUpperCase();
            switch (answer) {
                case "Y":
                    if (UserRepository.getUser().getMoney() >= sum) { // 잔액 확인
                        int currentMoney = UserRepository.getUser().getMoney() - sum; // 소지 금액에서 주문 총액 차감
                        UserRepository.getUser().setMoney(currentMoney);
                        // 주문한 제품 삭제
                        for (String orderItem : orderList) {
                            item.remove(orderItem.trim());
                        }
                        System.out.println("감사합니다. 주문이 완료 되었습니다.\n총 결제 금액: " + sum + "\n현재 소지 금액: " + currentMoney);
                        System.out.println("배송지 정보 : " + UserRepository.getUser().getAddress());
                        System.out.println("공휴일 제외, 영업일 기준 1 ~ 3 일 이내 배송됩니다.");
                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                    break;
                case "N":
                    System.out.println("주문이 취소되었습니다.");
                    break;
                default:
                    System.out.println("제대로 입력하세요.");
            }

        } else { // 한 개만 주문하는 경우
            System.out.println("현재 소지 금액: " + UserRepository.getUser().getMoney());
            int price = 0;
            try {
                price = (int) item.get(itemName).get("price");
            } catch (Exception e) {
                System.out.println("입력 예시: crocs, poloCap");
                return;
            }
            System.out.println("총 주문 가격: " + price);

            // 주문 여부 확인
            String answer = SimpleInput.input("주문하시겠습니까? Y / N\n>> ").toUpperCase();
            switch (answer) {
                case "Y":
                    if (UserRepository.getUser().getMoney() >= price) {  // 잔액 확인
                        int currentMoney = UserRepository.getUser().getMoney() - price; // 소지 금액에서 상품 가격 차감
                        UserRepository.getUser().setMoney(currentMoney);
                        item.remove(itemName); // 주문한 제품 삭제
                        System.out.println("감사합니다. 주문이 완료 되었습니다.\n총 결제 금액: " + price + "\n현재 소지 금액: " + currentMoney);
                        System.out.println("배송지 정보 : " + UserRepository.getUser().getAddress());
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
        }
    }

    // 한번에 두개 삭제 구현해야 함
    public static void deleteItem() {
        // 삭제할 제품명 입력 받음
        String itemNames = null;
        try {
            itemNames = SimpleInput.input("삭제 하고 싶은 제품명을 입력해주세요. \n" + BLUE + "(여러 개일 경우 쉼표 ','로 구분)" + RESET + "\n>> ").strip();
        } catch (Exception e) {
            System.out.println("입력 예시: crocs, poloCap");
        }

        String[] itemNameList = itemNames.split(","); // 입력값을 배열로 분할

        Map<String, Map<String, Object>> item = CartRepository.getItems();
        List<String> deletedItems = new ArrayList<>();

        for (String itemName : itemNameList) {
            itemName = itemName.strip();
            if (item.containsKey(itemName)) {
                System.out.println(itemName + "\n" + item.get(itemName));
                System.out.println("1. 삭제하기");
                System.out.println("2. 계속하기");
                String answer = SimpleInput.input(">> ");
                switch (answer) {
                    case "1":
                        item.remove(itemName); // 항목 삭제
                        deletedItems.add(itemName);
                        System.out.println(itemName + " 항목이 삭제되었습니다.");
                        break;
                    case "2":
                        System.out.println(itemName + " 항목을 삭제하지 않습니다.");
                        break;
                    default:
                        System.out.println("1 또는 2를 입력하세요.");
                }
            } else {
                System.out.println(itemName + " 항목이 존재하지 않습니다.");
            }
        }

        if (!deletedItems.isEmpty()) {
            System.out.println("삭제된 항목: " + deletedItems);
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
