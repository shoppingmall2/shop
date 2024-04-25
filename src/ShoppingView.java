import util.SimpleInput;

import static util.SimpleInput.*;
// 프로그램 입출력 처리 담당
public class ShoppingView {

    //private static ShoppingRepository repository = new ShoppingRepository();
    static ShoppingRepository sr;
    SimpleInput si;

    public ShoppingView() {
        this.sr = new ShoppingRepository();
    }

    // 프로그램 메뉴 실행
    public static void start() {

        // repository.load();

        while (true) {
            System.out.println("\n============쇼핑몰 프로그램==============");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 프로그램 종료");
            System.out.println("==========================================");

            String menuNum = input(">> ");

            switch (menuNum) {
                case "1":
                    signUpUser();
                    break;
                case "2":
                    signInUser();
                    break;
                case "3":
                    System.out.println("\n프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n메뉴를 잘못 선택했습니다.");
            }
        }
    } // start end

    // 1. 회원가입 기능
    private static void signUpUser() {
        //SignUpUser user = sr.getSignUpUser();
        System.out.println("***************회원가입 필수 입력 항목************");
        String id = input("아이디 : ");
        String password = input("비밀번호 : ");
        String name = input("이름 : ");
        String nickname = input("별명 : ");
        String age = input("나이 : ");
        String gender = input("성별 : ");
        String email = input("이메일 : ");
//        System.out.println("비밀번호 : " + user.getPassword());
//        System.out.println("이름 : " + user.getName());
//        System.out.println("별명 : " + user.getNickName());
//        System.out.println("나이 : " + user.getAge());
//        System.out.println("성별 : " + user.getGender());

//        String email = null;
//        while (true) {
//            email = input("- 이메일: ");
//            if (!sr.isDuplicateEmail(email)) {
//                break;
//            }
//            System.out.println("중복된 이메일입니다.");
//        }
        String address = input("주소 : ");
    }

    // 2. 로그인 기능
    private static void signInUser() {

    }


}