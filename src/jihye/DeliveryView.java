package jihye;

import user.UserLoginView;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


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

    // 1. 구매 목록 보기 기능 메서드
    private static void showPurchaseList() {
        System.out.println("\n========================구매 목록=============================");
        // DeliveryRepository 클래스에 임시로 넣어둔 리스트 반복해서 가져오기
        for (Buy buy : DeliveryRepository.buyList) {
            System.out.println("브랜드: " + buy.getBrand() + ", 상품명: " + buy.getProductName()
                    + ", 상품 금액 : " + buy.getOrderTotalValue() + ", 주소 : " + buy.getAddress());
        }
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

        String[] steps = {">> 주문 확인 중 \uD83D\uDED2", " → 배송 준비 중 \uD83D\uDCE6", " → 배송 중 \uD83D\uDE9A", " → 배송 완료 \u2705"}; // 모든 단계를 정의

        StringBuilder currentSteps = new StringBuilder(); // 현재까지의 단계를 저장할 문자열

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int currentStepIndex = 0; // 현재 진행 중인 단계 인덱스로 가져오기

            @Override
            public void run() {
                // 현재 단계 추가
                currentSteps.append(steps[currentStepIndex]);

                // 현재까지의 단계 출력
                System.out.print("\r" + currentSteps.toString());
                System.out.flush(); // 출력을 강제로 갱신

                // 다음 단계 인덱스로 이동
                currentStepIndex++;

                // 모든 단계가 출력되었다면 타이머 종료
                if (currentStepIndex == steps.length) {
                    timer.cancel();
                    System.out.println(); // 줄 바꿈 추가

                    //selectMenu();
                }
            }
        }, 0, 5000); // 처음 실행 후 3초마다 단계 진행되도록

        System.out.println("  \u2705 배송 현황 확인 완료시 아래 원하시는 메뉴를 입력하세요.\n   \uD83E\uDC7B \uD83E\uDC7B \uD83E\uDC7B \uD83E\uDC7B \uD83E\uDC7B \uD83E\uDC7B \n1. 구매 목록 재확인 하기 \n2. 카테고리 페이지로 가기\n");
        // 사용자 입력 대기
        String input;
        do {
            input = input(">> ").trim(); // 사용자 입력 받고 앞뒤 공백 제거
            if (!input.isEmpty()) { // 입력이 비어있지 않으면
                if (input.equals("1")) {
                    timer.cancel(); // 타이머 취소하여 단계 출력 멈춤
                    showPurchaseList(); // 구매 목록 재확인 메서드 호출
                    return; // 무한 루프 탈출
                } else if (input.equals("2")) {
                    timer.cancel(); // 타이머 취소하여 단계 출력 멈춤
                    UserLoginView userLoginView = new UserLoginView();
                    userLoginView.mainPage(); // 다른 클래스의 mainPage() 메서드로 가야 함
                    return; // 무한 루프 탈출
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 다시 제대로 입력해주세요.");
                }
            }
        } while (input.isEmpty()); // 입력이 비어있으면 계속해서 입력 대기

    }

    private static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}