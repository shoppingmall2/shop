package kibeom;

import jihye.Buy;

import user.User;
import user.UserLoginView;
import user.UserRepository;
import util.SimpleInput;

import java.lang.reflect.Array;
import java.util.*;

import static jihye.DeliveryRepository.buyList;
import static kibeom.CartRepository.CartList;



public class CartView {
    static UserLoginView userLoginView = new UserLoginView();
    private static CartRepository cartRepo;
    public static final String RED = "\033[0;31m"; // 콘솔에 색깔 주기
    public static final String RESET = "\033[0m";
    public static final String BLUE = "\033[0;34m";



    public CartView() {
        this.cartRepo = new CartRepository();
    }


    public static void showCartRepository() {
        boolean back = true; // 반복문 탈출을 위한 논리값 변수
        while (back) {
            System.out.println("============ 장바구니 목록 =============");

            if (CartList.isEmpty()) {
                System.out.println(BLUE+"장바구니가 비어있습니다."+RESET);
            } else {
                CartRepository.showCartRepository();

            }
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
                    userLoginView.mainPage();
                    back = false;
                    break;
                default:
                    System.out.println("1 ~ 3!");
            }
        }

    }

    private static void deleteItem() {
        String itemNames = SimpleInput.input("삭제 하고 싶은 제품명을 입력해주세요. \n" + BLUE + "(여러 개일 경우 쉼표 ','로 구분)" + RESET + "\n>> ").strip();
        String[] itemsToDelete = itemNames.split(","); // 입력값이 두개 이상일때 사용됨

        for (String itemName : itemsToDelete) {
            CartRepository.deleteItem(itemName.trim()); // 공백 제거
            System.out.println(itemName.trim() + "이(가) 삭제되었습니다.");
        }
    }

    private static void order() {

        String[] orderList = null;
        int totalOrderPrice = 0;
        boolean back = true;
        while (back) {
            String itemName = SimpleInput.input("주문 하고 싶은 제품명을 입력해주세요. \n" + BLUE + "(여러 개일 경우 쉼표 ','로 구분)" + RESET + "\n>> ").trim();

            orderList = itemName.split(","); // 입력값 2개 이상일때.
            totalOrderPrice = 0;

            for (String singleItem : orderList) {
                Cart orderItem = CartRepository.isContains(singleItem.trim());
                if (orderItem == null) {
                    System.out.println(RED +singleItem  +" 상품은 장바구니에 없습니다."+RESET);
                    continue;
                }
                int price = orderItem.getPrice();
                totalOrderPrice += price;
                back = false;
            }
        }

        System.out.println("총 주문 가격: " + totalOrderPrice);
        System.out.println("현재 소지 금액 : " + UserRepository.getUser().getMoney());

        String answer = SimpleInput.input("주문하시겠습니까? Y / N\n>> ").toUpperCase();
        switch (answer) {
            case "Y":
                if (UserRepository.getUser().getMoney() >= totalOrderPrice) { // 유저 보유 금액 확인
                    int currentMoney = UserRepository.getUser().getMoney() - totalOrderPrice;
                    UserRepository.getUser().setMoney(currentMoney);
                    for (String singleItem : orderList) {
                        Cart orderItem = CartRepository.isContains(singleItem.trim());
                        buyList.add(new Buy(orderItem.getBrand(), orderItem.getItemName(), orderItem.getPrice(),UserRepository.getUser().getAddress()));
                        CartList.remove(orderItem);
                    }
                    System.out.println("감사합니다. 주문이 완료 되었습니다.\n총 결제 금액: " + totalOrderPrice + "\n현재 소지 금액: " + currentMoney);
                    System.out.println("배송지 정보 : " + UserRepository.getUser().getAddress());
                    System.out.println("공휴일 제외, 영업일 기준 1 ~ 3 일 이내 배송됩니다.");
                    SimpleInput.stopInput();
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
    }

}


