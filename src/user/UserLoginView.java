package user;

<<<<<<< HEAD
import kibeom.CartRepository;
import kibeom.CartView;

import static user.UserRepository.printLoggedInUserInfo;
=======
import static user.UserRepository.generateCaptcha;
import static user.UserRepository.generateThisTime;
>>>>>>> main
import static util.SimpleInput.input;

public class UserLoginView {
    static UserRepository ur;
<<<<<<< HEAD
    CartRepository cartRepository = new CartRepository();

    public void start() {
=======
    public static final String RESET = "\033[0m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    public void start() {

>>>>>>> main
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
<<<<<<< HEAD
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
=======
        String password = null;
        System.out.println("***************회원가입 필수 입력 항목************");
        String name = input(GREEN+ "이름 : "+ RESET);
        System.out.println("가입 가능한 회원입니다.");
        while (true) {
            System.out.println(GREEN+ "비밀번호는 8글자 이상이여야 합니다." + RESET);
            String passwordChek = input(GREEN+ "비밀번호 : "+ RESET);
            if (passwordChek.length() >= 8 ) {
                password = passwordChek;
                System.out.println(GREEN+ "사용 가능한 패스워드입니다."+RESET);
                break;
            } else {
                System.out.println(YELLOW+ "가입 시 비밀번호 조건을 확인해주세요."+RESET);
            }
        }
        String email = input(GREEN+ "이메일 : "+RESET);
        String nickname = input(GREEN+ "별명 : "+RESET);
        int age = Integer.parseInt(input(GREEN+ "나이 : ")+RESET);
        String gender = input(GREEN+ "성별 : "+RESET);
        String address = input(GREEN+ "주소 : "+RESET);
        String captcha = generateCaptcha(6);
        String agree = input(GREEN+ "개인정보 수집 및 회원가입에 동의하시겠습니까? [Y, N]\n >> "+RESET).toUpperCase();
        if (agree.equals("Y")){
            System.out.println(GREEN+ generateThisTime() + "에 개인정보에 동의하셨습니다."+RESET);
            System.out.println(GREEN+ "자동 입력 방지 문자: " + captcha+RESET);
            while (true) {
                String captchaTrue = input(GREEN+ "자동 입력 방지 문자를 보이는대로 입력해주세요. \n >>"+RESET);
                if (captchaTrue.equals(captcha))  {
                User newUser = new User(name, password, email, age, address, gender, nickname);
                UserRepository.addUser(newUser);
                    System.out.println(GREEN+ "#. 회원가입이 완료되었습니다."+RESET);
                    break;
                } else {
                    System.out.println(YELLOW+ "! 자동 입력 방지 문자를 확인해주세요"+RESET);
                    System.out.println(GREEN+ "# 1. 자동 입력 방지 문자 새로고침하기"+RESET);
                    int menuNum = Integer.parseInt(input(">> "));

                    switch (menuNum) {
                        case 1 :
                            captcha = generateCaptcha(6);
                            System.out.println(GREEN+ "자동 입력 방지 문자: " + captcha+RESET);
                    }
                }
            }
        } else {
            System.out.println(YELLOW+ "그럼 가입하지마"+RESET);
        }
>>>>>>> main
    }

    private void callLogin() {
        System.out.println("***************로그인 필수 입력 항목************");
        String name = input("이름 : ");
        String password = input("비밀번호 : ");
<<<<<<< HEAD
        UserRepository.login(name, password);
=======
        boolean login = UserRepository.login(name, password);
        if (login) {
            System.out.printf("%s님 환영합니다.",name);
        } else {
            System.out.println("회원정보를 확인해주세요.");
        }

>>>>>>> main
        mainPage();
    }

    public void mainPage() {
        boolean b = ur.loginTrue();
        while (b) {
            System.out.println("\n=============카테고리 페이지==============");
            System.out.println("1. 카테고리");
            System.out.println("2. 마이페이지");
<<<<<<< HEAD
            System.out.println("3. 비밀번호 변경");
=======
            System.out.println("3. 회원정보 수정");
>>>>>>> main
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
<<<<<<< HEAD
                    passwordChange();
                    break;
                case "5":
                    CartView.showCartRepository();
=======
                    passCheck();
                    check = true;
                    break;
>>>>>>> main
                case "6":
                    byebye();
                    b = false;
                    break;
                default:
                    System.out.println("\n메뉴를 잘못 선택했습니다.");
            }
        }
    } // start

    public void byebye() {
        UserRepository.logout();
    }


<<<<<<< HEAD
=======
        boolean check = true;
    public void passCheck() {
        boolean b = ur.loginTrue();
        while (b && check) {
            String check = input("현재 로그인한 계정의 비밀번호를 입력해주세요. ");
            boolean isLogin = UserRepository.loginCheck(check);
            if (isLogin) {
                changeInfo();
            } else {
                System.out.println("비밀번호를 확인해주세요");
                break;
            }
        }
    }

    public void changeInfo() {
        boolean b = ur.loginTrue();
        while (b && check) {
            System.out.println("\n=============카테고리 페이지==============");
            System.out.println("# 1. 별명 변경하기");
            System.out.println("# 2. 배송지 수정하기");
            System.out.println("# 3. 이메일 변경하기");
            System.out.println("# 4. 비밀번호 변경하기");
            System.out.println("# 5. 뒤로가기");
            System.out.println("========================================");


            String menuNum = input(">> ");

            switch (menuNum) {
                case "1":
                    nicknameChange();
                    break;
                case "2":
                    printLoggedInUserInfo();
                    break;
                case "3":
                    check=true;
                    emailChange();
                    break;
                case "4":
                    check = true;
                    passwordChange();
                    break;
                case "5":
                    mainPage();
                case "6":
                    byebye();
                    b = false;
                    break;
                default:
                    System.out.println("\n메뉴를 잘못 선택했습니다.");
            }
        }
    }


>>>>>>> main
    boolean exitProgram() {
        String exit = input("- 프로그램을 종료합니까? [y/n]\n>> ");
        if (exit.equals("y")) {
            System.out.println("프로그램을 종료합니다!");
            return true;
        } else {
            System.out.println("프로그램 종료를 취소합니다.");
            return false;
        }
    }


<<<<<<< HEAD
    public void passwordChange() {
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
=======

    public static void printLoggedInUserInfo() {
        if (UserRepository.loggedInUser != null) {
            System.out.println("***************로그인한 회원 정보**************");
            System.out.println("이름 : " + UserRepository.loggedInUser.getName());
            System.out.println("나이 : " + UserRepository.loggedInUser.getAge());
            System.out.println("배송지 주소 : "+ UserRepository.loggedInUser.getAddress());
            System.out.println("별명 : " + UserRepository.loggedInUser.getNickname());
            System.out.println("성별 : " +UserRepository.loggedInUser.getGender());
            System.out.println("이메일 : " + UserRepository.loggedInUser.getEmail());
            System.out.println("비번 : " + UserRepository.blindPassword());
        } else {
            System.out.println("로그인한 회원이 없습니다.");
        }
    }


    public void passwordChange() {
        System.out.println("현재 비밀번호를 입력해주세요");
        String pas = input(">> ");
        String pass = UserRepository.getPass();
        if (pass.equals(pas)) {
            System.out.println("변경할 비밀번호를 입력해주세요.");
            String newPas = input(">> ");
            UserRepository.ChangePass(newPas);
            System.out.println("#. 비밀번호가 변경되었습니다.");
            check = false;
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");

        }
    }
    public void nicknameChange() {
            System.out.println("변경할 닉네임을 입력해주세요.");
            String newNick = input(">> ");
            UserRepository.changeNickname(newNick);
            System.out.printf("#. 닉네임이 %s 로 변경되었습니다.", newNick);
            check = false;
    }
    public void emailChange() {
        System.out.println("현재 이메일을 입력해주세요");
        String thismail = input(">> ");
        String oldmail = UserRepository.getEmail();
        if (oldmail.equals(thismail)) {
            System.out.println("변경할 이메일을 입력해주세요.");
            String newEmail = input(">> ");
            UserRepository.changeEmail(newEmail);
            System.out.println("#. 이메일이 변경되었습니다.");
            check = false;
        } else {
            System.out.println("이메일이 일치하지 않습니다.");

        }
    }

>>>>>>> main
}



