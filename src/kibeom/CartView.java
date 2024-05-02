package kibeom;

import seungyeon.Search;
import jihye.Buy;

import jihye.BuyRepository;
import jihye.DeliveryRepository;
import jihye.DeliveryView;
import user.User;
import user.UserLoginView;
import user.UserRepository;
import util.SimpleInput;

import java.lang.reflect.Array;
import java.util.*;

import static jihye.DeliveryRepository.buyList;
import static kibeom.CartRepository.CartList;
import static kibeom.CartRepository.getCartList;


public class CartView {

    private Search search;
    private CartRepository cartRepository;

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
            System.out.println("\n=============장바구니 목록==============");

            if (CartList.isEmpty()) {
                System.out.println(BLUE + "장바구니가 비어있습니다." + RESET);
                System.out.println("========================================");
            } else {
                showCartRepo();

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
                    System.out.println(RED + "잘못된 메뉴 번호입니다. 다시 선택해주세요." + RESET);
            }
        }

    }

    private static void showCartRepo() {
            List<Cart> cartList = getCartList();
            System.out.println();
            for (Cart cart : cartList) {
                System.out.println("브랜드 : " + cart.getBrand() + "\n" +
                        "제품 명 : " + cart.getItemName() + "\n" +
                        "제품 분류 : " + cart.getType() + "\n" +
                        "제품 가격 : " + cart.getPrice() + "\n" +
                        "성별 : " + cart.getGender() + "\n");
            }
            System.out.println("======================================");
    }

    private static void deleteItem() {
        String itemNames = SimpleInput.input("삭제 하고 싶은 제품명을 입력해주세요. \n" + BLUE + "(여러 개일 경우 쉼표 ','로 구분)" + RESET + "\n>> ").strip();
        String[] itemsToDelete = itemNames.split(","); // 입력값이 두개 이상일때 사용됨

        for (String itemName : itemsToDelete) {
            CartRepository.deleteItem(itemName.trim()); // 공백 제거
            System.out.println(" 🗑️ " + itemName.trim() + "이(가) 삭제되었습니다.");
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
                kibeom.Cart orderItem = CartRepository.isContains(singleItem.trim());
                if (orderItem == null) {
                    System.out.println(" ❗ " + singleItem + " 상품은 장바구니에 없습니다.\n");
                    continue;
                }
                int price = orderItem.getPrice();
                totalOrderPrice += price;
                back = false;
            }
        }

        System.out.println("\n\uD83D\uDCB5 총 주문 가격: " + totalOrderPrice);
        System.out.println("\uD83D\uDCB0 현재 소지 금액 : " + UserRepository.getUser().getMoney());

        String answer = SimpleInput.input("주문하시겠습니까? Y / N\n>> ").toUpperCase();
        switch (answer) {
            case "Y":
                if (UserRepository.getUser().getMoney() >= totalOrderPrice) { // 유저 보유 금액 확인
                    int currentMoney = UserRepository.getUser().getMoney() - totalOrderPrice;
                    UserRepository.getUser().setMoney(currentMoney);
                    for (String singleItem : orderList) {
                        Cart orderItem = CartRepository.isContains(singleItem.trim());
                        buyList.add(new Buy(Objects.requireNonNull(orderItem).getBrand(), orderItem.getItemName(), orderItem.getPrice(),UserRepository.getUser().getAddress()));
                        CartList.remove(orderItem);
                    }
                    System.out.println("\n\uD83D\uDE0A 감사합니다. 주문이 완료 되었습니다.\n\uD83D\uDCB5 총 주문 가격: " + totalOrderPrice + "\n\uD83D\uDCB0 현재 소지 금액: " + currentMoney);
                    System.out.println("\uD83C\uDFE0 배송지 주소 : " + UserRepository.getUser().getAddress());
                    System.out.println("공휴일 제외, 영업일 기준 1 ~ 3 일 이내 배송됩니다.");
                    SimpleInput.stopInput();
                } else {
                    System.out.println(" ❗ 잔액이 부족합니다.");
                }
                break;
            case "N":
                System.out.println(" ❗ 주문이 취소되었습니다.");
                break;
            default:
                System.out.println("RED + \"잘못된 입력입니다. 다시 선택해주세요.\" + RESET");
        }
    }
}

