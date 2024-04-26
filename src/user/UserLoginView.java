package user;

import static util.SimpleInput.input;

public class UserLoginView {
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
                    callLogin();
                    break;
                case "3":
                    break;
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
        System.out.println("***************회원가입 필수 입력 항목************");
        String name = input("이름 : ");
        String password = input("비밀번호 : ");

        UserRepository.login(name,password);
    }
}
