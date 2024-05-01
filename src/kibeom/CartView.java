package kibeom;

import jihye.Buy;
<<<<<<< HEAD
import static jihye.DeliveryRepository.buyList;

import jihye.BuyRepository;
import jihye.DeliveryRepository;
import jihye.DeliveryView;
=======

>>>>>>> e27756bca7ef7d92e8c6c56027e87a16fd77bcde
import user.User;
import user.UserLoginView;
import user.UserRepository;
import util.SimpleInput;

import java.lang.reflect.Array;
import java.util.*;
<<<<<<< HEAD
=======

import static jihye.DeliveryRepository.buyList;
import static kibeom.CartRepository.CartList;
>>>>>>> e27756bca7ef7d92e8c6c56027e87a16fd77bcde



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

<<<<<<< HEAD
    /*
    order() 주문하는 메서드
    코드가 긴 이유는 한개만 주문하는 경우와
    한번에 2개 이상 주문하는 경우로 분기가 나뉘어 길어짐
    한번에 2개 이상 주문하는 경우 입력값을 , 를 기준으로 배열에 담고
    그 배열의 인덱스로 item 의 price 에 접근.
    분기가 까다로워서 리팩터링 못하겠음
     */   public static String itemName = null;
    private static void order() {
        // 주문할 제품명을 입력 받음
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
        Map<String, Map<String, Object>> item = getItems();

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
                        item.remove(itemName); // 주문한 제품 삭제

                        // 주문한 상품 정보를 DeliveryView 클래스로 전달
                        // null 지옥에서 빠지기 위한 3.
                        //DeliveryView.addPurchasedItem(itemName);
                        DeliveryView.addPurchasedItem(itemName);

                        // 주문한 제품 삭제
//                        for (String orderItem : orderList) {
//                            item.remove(orderItem.trim());
//                        }
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
                        //DeliveryRepository deliveryRepository = new DeliveryRepository();
                        //HashMap buy = deliveryRepository.buy(itemName);
                        //System.out.println("buy = " + buy);

                        //DeliveryRepository.showPurchaseList(itemName);
                        // 주문한 상품 정보를 DeliveryView 클래스로 전달
                        // null 지옥에서 빠지기 위한 4.
                        DeliveryView.addPurchasedItem(itemName);

                        //buyList.add(new Buy(itemName, (String) item.get(itemName).get("gender"), (Integer) item.get(itemName).get("price"), (String) item.get(itemName).get("type")));
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
=======
        for (String itemName : itemsToDelete) {
            CartRepository.deleteItem(itemName.trim()); // 공백 제거
            System.out.println(itemName.trim() + "이(가) 삭제되었습니다.");
>>>>>>> e27756bca7ef7d92e8c6c56027e87a16fd77bcde
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


