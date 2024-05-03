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
import static user.UserRepository.getUser;
import static user.UserRepository.loggedInUser;


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

            if (getUser().getCartList().isEmpty()) {
                System.out.println(BLUE + "장바구니가 비어있습니다." + RESET);
                System.out.println(BLUE + "ENTER"+ RESET +"를 누르시면 뒤로 갑니다.");
                SimpleInput.stopInput();
                back = false;
                userLoginView.mainPage();
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
            System.out.println();
        List<Cart> cartList = getUser().getCartList();
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
        String[] itemsToDelete = itemNames.split(",");
        List<Cart> cartList = getUser().getCartList();
        for (String itemName : itemsToDelete) {
            Cart item = CartRepository.isContains(itemName.trim());
            if (item != null) {
                cartList.remove(item);
                System.out.println("\n\uD83D\uDDD1️ " + item.getItemName() + " 상품을 장바구니에서 삭제했습니다.");
            } else {
                System.out.println("\n\uD83D\uDEAB " + itemName + " 상품은 장바구니에 없습니다.");

            }
                SimpleInput.stopInput();
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
        System.out.println("\uD83D\uDCB0 현재 소지 금액 : " + getUser().getMoney());

        boolean check = true;
        while (check) {
            String answer = SimpleInput.input("주문하시겠습니까? Y / N\n>> ").toUpperCase();
            switch (answer) {
                case "Y":
                    if (getUser().getMoney() >= totalOrderPrice) { // 유저 보유 금액 확인
                        int currentMoney = getUser().getMoney() - totalOrderPrice;
                        getUser().setMoney(currentMoney);
                        for (String singleItem : orderList) {
                            Cart orderItem = CartRepository.isContains(singleItem.trim());
                            getUser().getBuylist().add(new Buy(Objects.requireNonNull(orderItem).getBrand(), orderItem.getItemName(), orderItem.getPrice(), getUser().getAddress()));
                            getUser().getCartList().remove(orderItem);
                        }
                        System.out.println("\n\uD83D\uDE0A 감사합니다. 주문이 완료 되었습니다.\n\uD83D\uDCB5 총 주문 가격: " + totalOrderPrice + "\n\uD83D\uDCB0 현재 소지 금액: " + currentMoney);
                        System.out.println("\uD83C\uDFE0 배송지 주소 : " + getUser().getAddress());
                        System.out.println("공휴일 제외, 영업일 기준 1 ~ 3 일 이내 배송됩니다.");
                        SimpleInput.stopInput();
                        check = false;
                    } else {
                        System.out.println(" ❗ 잔액이 부족합니다.");
                        check = false;
                    }
                    break;
                case "N":
                    System.out.println(" ❗ 주문이 취소되었습니다.");
                    check = false;
                    break;
                default:
                    System.out.println(RED+" \"잘못된 입력입니다. 다시 선택해주세요.\"" + RESET);
            }
        }
    }
}

