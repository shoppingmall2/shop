package user;

import static jihye.DeliveryView.deliveryMenu;
import static user.UserRepository.printLoggedInUserInfo;
import static util.SimpleInput.input;

public class UserLoginView {
    public static UserRepository ur;

    public static void start() {

        // repository.load();

        while (true) {
            System.out.println("\n============쇼핑몰 프로그램==============");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 프로그램 종료");
            System.out.println("========================================");

            String menuNum = input(">> ");

            switch (menuNum) {
                case "1":
                    signUpUser();
                    break;
                case "2":
                    callLogin();
                    break;
                case "3":
                    boolean flag = exitProgram();
                    if (flag) return;
                default:
                    System.out.println("\n메뉴를 잘못 선택했습니다.");
            }
        }
    } // start end

    private static void signUpUser() {
        System.out.println("***************회원가입 필수 입력 항목************");
        String name = input("이름 : ");
        String password = input("비밀번호 : ");
        String email = input("이메일 : ");
        String nickname = input("별명 : ");
        int age = Integer.parseInt(input("나이 : "));
        String gender = input("성별 : ");
        String address = input("주소 : ");

        User newUser = new User(name, password, email, age, address, gender, nickname);
        UserRepository.addUser(newUser);
    }

    private static void callLogin() {
        System.out.println("***************로그인 필수 입력 항목************");
        String name = input("이름 : ");
        String password = input("비밀번호 : ");
        UserRepository.login(name, password);
        mainPage();
    }

    public static void mainPage() {
        boolean b = ur.loginTrue();
        while (b) {
            System.out.println("\n=============카테고리 페이지==============");
            System.out.println("1. 카테고리");
            System.out.println("2. 마이페이지");
            System.out.println("3. 비밀번호 변경");
            System.out.println("4. 배송조회");
            System.out.println("5. 장바구니");
            System.out.println("6. 로그아웃");
            System.out.println("========================================");


            String menuNum = input(">> ");

            switch (menuNum) {
                case "1":
//                    signUpUser();
                    break;
                case "2":
                    printLoggedInUserInfo();
                    break;
                case "3":
                    passwordChange();
                    break;
                case "4":
                    deliveryMenu();
                    break;
                case "6":
                    byebye();
                    b = false;
                    break;
                default:
                    System.out.println("\n메뉴를 잘못 선택했습니다.");
            }
        }
    } // start



    public static void byebye() {
        UserRepository.logout();
    }


    static boolean exitProgram() {
        String exit = input("- 프로그램을 종료합니까? [y/n]\n>> ");
        if (exit.equals("y")) {
            System.out.println("프로그램을 종료합니다!");
            return true;
        } else {
            System.out.println("프로그램 종료를 취소합니다.");
            return false;
        }
    }


    public static void passwordChange() {
        String pas = input("현재 비밀번호를 입력해주세요.");
        String newPas = input("변경할 비밀번호를 입력해주세요.");
        String pass = UserRepository.getPass();

        if (pass.equals(pas)) {
            UserRepository.ChangePass(newPas);
        }
//        boolean b = ur.mypage();
//        while (b) {
//            String oldPass = input("현재 비밀번호를 입력해주세요");
//            String newPass = input("변경 할 비밀번호를 입력해주세요");
//        }
    }
}


