package jihye;

import user.UserLoginView;

import java.util.*;

import static jihye.BuyRepository.itemList;
import static jihye.DeliveryRepository.item;
import static kibeom.CartView.itemName;


public class DeliveryView {
    private static Scanner scanner = new Scanner(System.in);

    // 배송조회 시작 화면 메서드
    public static void deliveryMenu() {
        while (true) {
            System.out.println("=======================배송조회=========================");
            System.out.println("1. 구매 목록 보기");
            System.out.println("2. 뒤로 가기");

            String menuNum = input(">> ");
            UserLoginView userLoginView = new UserLoginView();

            switch (menuNum) {
                case "1":
                    showPurchaseList();
                    break;
                case "2":
                    userLoginView.mainPage();
                    return;
                default:
                    System.out.println("\n잘못된 메뉴 번호입니다. 제대로 입력해주세요.");
                    break;
            }
        }
    }

    // null 지옥에서 빠지기 위한 2.
    private static List<String> purchasedItems = new ArrayList<>(); // 주문한 상품을 저장할 리스트

    public static void addPurchasedItem(String itemName) {
        if (!purchasedItems.contains(itemName)) {
            purchasedItems.add(itemName);
        } //purchasedItems.add(itemName);
    }

//    public static List<Buy> getPurchasedItems() {
//        return purchasedItems;
//    }

    // 1. 구매 목록 보기 기능 메서드
    public static void showPurchaseList() {
        System.out.println("\n========================구매 목록=============================");
        //List<Buy> purchasedItems = getPurchasedItems();
        // 구매한 상품 정보를 BuyRepository에서 가져와서 출력
        //List<String> purchasedItems = BuyRepository.addItem(item);
        //for (String itemName : purchasedItems) {
            //Buy item = BuyRepository.getItemByName(itemName);
            //if (item != null) {
//            System.out.println("주문하신 상품명: " + item.getItemName());
//            System.out.println("상품 분류: " + item.getType());
//            System.out.println("상품 가격: " + item.getPrice());
//            System.out.println("상품 성별: " + item.getGender());
//
            //System.out.println("주문하신 상품명 : " + itemName);
            //System.out.println("=============================================================");
            //}
//        } else {
//                System.out.println("해당 상품의 정보를 찾을 수 없습니다.");
//            }


        //DeliveryRepository deliveryRepository = new DeliveryRepository();
        //deliveryRepository.showPurchaseList();

        // DeliveryRepository 클래스에 임시로 넣어둔 리스트 반복해서 가져오기
//        for (Buy buy : DeliveryRepository.buyList) {
//            System.out.println("브랜드: " + buy.getItemName() + ", 상품명: " + buy.getType()
//                    + ", 상품 금액 : " + buy.getPrice() + ", 배송지 주소 : " + UserRepository.getUser().getAddress());
//        }

        // null 지옥에서 빠지기 위한 1.
        for (String itemName : purchasedItems) {
            System.out.println("주문하신 상품명 : " + itemName);
        }
//        for (Buy itemName : itemList) {
//            System.out.println("주문하신 상품 = " + itemName);
//        }

        System.out.println("=============================================================");
        System.out.println("\n1. 구매 상품 배송 현황 확인하기");
        String menuNum2 = input(">> ");
        switch (menuNum2) {
            case "1":
                deliveryStatus();
                break;
            default:
                System.out.println("\n잘못된 메뉴 번호입니다. 제대로 입력해주세요.");
                break;

        }
    }


    // 구매 상품 배송 현황 확인하는 기능 메서드
    private static void deliveryStatus() {
        System.out.println("\n==========================배송 현황==========================");

//        String[] steps = {">> 주문 확인 중 \uD83D\uDED2", " → 배송 준비 중 \uD83D\uDCE6", " → 배송 중 \uD83D\uDE9A", " → 배송 완료 \u2705"}; // 모든 단계를 정의
//
//        StringBuilder currentSteps = new StringBuilder(); // 현재까지의 단계를 저장할 문자열
//
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            int currentStepIndex = 0; // 현재 진행 중인 단계 인덱스로 가져오기
//
//            @Override
//            public void run() {
//                // 현재 단계 추가
//                currentSteps.append(steps[currentStepIndex]);
//
//                // 현재까지의 단계 출력
//                System.out.print("\r" + currentSteps.toString());
//                System.out.flush(); // 출력을 강제로 갱신
//
//                // 다음 단계 인덱스로 이동
//                currentStepIndex++;
//
//                // 모든 단계가 출력되었다면 타이머 종료
//                if (currentStepIndex == steps.length) {
//                    timer.cancel();
//                    System.out.println(); // 줄 바꿈 추가
//
//                    //selectMenu();
//                }
//            }
//        }, 0, 5000); // 처음 실행 후 3초마다 단계 진행되도록
//
//        System.out.println("  \u2705 배송 현황 확인 완료시 아래 원하시는 메뉴를 입력하세요.\n   \uD83E\uDC7B \uD83E\uDC7B \uD83E\uDC7B \uD83E\uDC7B \uD83E\uDC7B \uD83E\uDC7B \n1. 구매 목록 재확인 하기 \n2. 카테고리 페이지로 가기\n");
//        // 사용자 입력 대기
//        String input;
//        do {
//            input = input(">> ").trim(); // 사용자 입력 받고 앞뒤 공백 제거
//            if (!input.isEmpty()) { // 입력이 비어있지 않으면
//                if (input.equals("1")) {
//                    timer.cancel(); // 타이머 취소하여 단계 출력 멈춤
//                    showPurchaseList(); // 구매 목록 재확인 메서드 호출
//                    return; // 무한 루프 탈출
//                } else if (input.equals("2")) {
//                    timer.cancel(); // 타이머 취소하여 단계 출력 멈춤
//                    UserLoginView userLoginView = new UserLoginView();
//                    userLoginView.mainPage(); // 다른 클래스의 mainPage() 메서드로 가야 함
//                    return; // 무한 루프 탈출
//                } else {
//                    System.out.println("잘못된 메뉴 번호입니다. 다시 제대로 입력해주세요.");
//                }
//            }
//        } while (input.isEmpty()); // 입력이 비어있으면 계속해서 입력 대기
//
//    }
        //List<Buy> purchasedItems = DeliveryRepository.getPurchasedItems();

        for (Buy item : purchasedItems) {
            System.out.println("상품명: " + item.getItemName());
            DeliveryStatus status = DeliveryManager.getDeliveryStatus(item.getItemName());
            System.out.println("배송 상태: " + status);
            System.out.println("===============================================================");
        }

        System.out.println("\n1. 다음 단계로 진행하기");
        String menuNum = input(">> ");

        switch (menuNum) {
            case "1":
                approveNextStep();
                break;
            default:
                System.out.println("\n잘못된 메뉴 번호입니다. 제대로 입력해주세요.");
                break;
        }
    }

    // 다음 단계로 진행하는 메서드
    private static void approveNextStep() {
        System.out.println("\n===================다음 단계로 진행====================");
        System.out.println("승인할 상품명을 입력하세요:");
        String itemName = scanner.nextLine();
        DeliveryManager.approveNextStep(itemName);
        System.out.println("다음 단계로 승인되었습니다.");
        System.out.println("====================================================");
    }


    private static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}