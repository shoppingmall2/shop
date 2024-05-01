package user;

import jihye.DeliveryView;
import kibeom.CartView;


import static seungyeon.Category.openCate;
import static user.UserRepository.generateCaptcha;
import static user.UserRepository.generateThisTime;
import static user.UserRepository.*;
import static util.SimpleInput.input;

public class UserLoginView {
    static UserRepository ur;
    public static final String RESET = "\033[0m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    public void start() {

        // repository.load();

        while (true) {
            System.out.println("\n-----------------\uD83D\uDECD\uFE0F쇼핑몰 프로그램\uD83D\uDECD\uFE0F----------------");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 비밀번호 찾기");
            System.out.println("4. 프로그램 종료");
            System.out.println("\n------------------------------------------------");
            String menuNum = input(">> ");

            switch (menuNum) {
                case "1":
                    signUpUser();
                    break;
                case "2":
                    callLogin();
                    break;
                case "3":
                    searchPass();
                    break;
                case "4":
                    boolean flag = exitProgram();
                    if (flag) return;
                default:
                    System.out.println("\n메뉴를 잘못 선택했습니다.");
            }
        }
    } // start end

    private static void searchPass() {
        String trueName = input(GREEN + "가입하신 명의의 이름을 작성해주세요. \n ➡\uFE0F" + RESET);
        if (!alreadyLogId(trueName)) {
            System.out.printf("%s님의 이름으로 가입하신 계정의 이메일을 작성해주세요. \n",trueName);
            String truemail = input("➡\uFE0F");
            if (!alreadyMail(truemail)) {
                System.out.printf("%s님의 가입하신 나이를 입력해주세요.\n",trueName);
                String trueage = input("➡\uFE0F");
                if (!alreadyAge(Integer.parseInt(trueage))){
                    System.out.printf("✅ %s님의 정보로 가입한 계정의 비밀번호는 다음과 같습니다. \n ",trueName);
                    String s = srPass();
                    System.out.printf("➡\uFE0F %s",s);
                } else {
                    System.out.println("회원정보의 나이가 일치하지 않습니다.");
                }
            } else {
                System.out.println("작성하신 이메일의 정보가 일치하지 않습니다.");
            }
        } else {
            System.out.printf("%s의 이름으로 가입하신 회원정보가 존재하지 않습니다.",trueName);
        }
    }

    private static void signUpUser() {
        String password = null;
        String name = null;
        System.out.println("***************회원가입 필수 입력 항목************");
        String exitName = input(GREEN + "이름 ➡\uFE0F " + RESET);
        while (true) {
            if (alreadyLogId(exitName)) {
                System.out.println("# ✅ 가입 가능한 회원입니다.");
                name = exitName;
                break;
            }
            System.out.println("이미 가입된 회원입니다. 정보를 확인해주세요");
            return;
        }
        while (true) {
            System.out.println(GREEN + "비밀번호는 8글자 이상이여야 합니다." + RESET);
            String passwordChek = input(GREEN + "비밀번호 ➡\uFE0F " + RESET);
            if (passwordChek.length() >= 8) {
                password = passwordChek;
                System.out.println(GREEN + "# ✅ 사용 가능한 패스워드입니다." + RESET);
                break;
            } else {
                System.out.println(YELLOW + "가입 시 비밀번호 조건을 확인해주세요." + RESET);
            }
        }
        String email = input(GREEN + "이메일 ➡\uFE0F " + RESET);
        String nickname = input(GREEN + "별명 ➡\uFE0F " + RESET);
        int age = Integer.parseInt(input(GREEN + "나이 ➡\uFE0F " + RESET));
        String gender = input(GREEN + "성별 ➡\uFE0F " + RESET);
        String address = input(GREEN + "주소 ➡\uFE0F " + RESET);
        String captcha = generateCaptcha(6);
        String agree = input(GREEN + "# ✅ 개인정보 수집 및 회원가입에 동의하시겠습니까? [Y, N]\n >> " + RESET).toUpperCase();
        if (agree.equals("Y")) {
            System.out.println(GREEN + "# ✅ " + generateThisTime() + "에 개인정보에 동의하셨습니다." + RESET);
            System.out.println(GREEN + "자동 입력 방지 문자 ➡\uFE0F " + captcha + RESET);
            while (true) {
                String captchaTrue = input(GREEN + "자동 입력 방지 문자를 보이는대로 입력해주세요. \n >>" + RESET);
                if (captchaTrue.equals(captcha)) {
                    User newUser = new User(name, password, email, age, address, gender, nickname);
                    UserRepository.addUser(newUser);
                    System.out.println(YELLOW + "\uD83C\uDF89 회원가입이 완료되었습니다." + RESET);
                    break;
                } else {
                    System.out.println(YELLOW + "! 자동 입력 방지 문자를 확인해주세요" + RESET);
                    System.out.println(GREEN + "# 1. 자동 입력 방지 문자 새로고침하기" + RESET);
                    int menuNum = Integer.parseInt(input(">> "));
                    switch (menuNum) {
                        case 1:
                            captcha = generateCaptcha(6);
                            System.out.println(GREEN + "자동 입력 방지 문자 ➡\uFE0F " + captcha + RESET);
                    }
                }
            }
        } else {
            System.out.println(YELLOW + "그럼 가입하지마" + RESET);
        }
    }

    private void callLogin() {
        System.out.println("***************로그인 필수 입력 항목************");
        String name = input("이름 : ");
        String password = input("비밀번호 : ");
        boolean login = UserRepository.login(name, password);
        if (login) {
            System.out.println("# ✅ 로그인 성공!");
            System.out.printf("\uD83C\uDF89%s %s님 %s환영합니다.", YELLOW,name,RESET);
        } else {
            System.out.println("회원정보를 확인해주세요.");
        }

        mainPage();
    }

    public void mainPage() {
        boolean b = ur.loginTrue();
        while (b) {
            System.out.println("\n=============카테고리 페이지==============");
            System.out.println("1. 카테고리");
            System.out.println("2. 마이페이지");
            System.out.println("3. 회원정보 수정");
            System.out.println("4. 배송조회");
            System.out.println("5. 장바구니");
            System.out.println("6. 로그아웃");
            System.out.println("========================================");


            String menuNum = input(">> ");

            switch (menuNum) {
                case "1":
                    openCate();
                    break;
                case "2":
                    printLoggedInUserInfo();
                    break;
                case "3":
                    passCheck();
                    check = true;
                    break;
                case "4":
                    DeliveryView deliveryView = new DeliveryView();
                    deliveryView.deliveryMenu();
                    break;
                case "5":
                    CartView cartView = new CartView();
                    cartView.showCartRepository();
                case "6":
                    byebye();
                    break;
                default:
                    System.out.println("\n메뉴를 잘못 선택했습니다.");
            }
        }
    } // start

    public void byebye() {
        UserRepository.logout();
        System.out.println("# ✅ 성공적으로 로그아웃하였습니다.");
        start();
    }


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
            System.out.println("\n=============회원정보 수정==============");
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
                    check = true;
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


    boolean exitProgram() {
        String exit = input("# ✅ 프로그램을 종료합니까? [y/n]\n>> ");
        if (exit.equals("y")) {
            System.out.println("프로그램을 종료합니다!");
            return true;
        } else {
            System.out.println("프로그램 종료를 취소합니다.");
            return false;
        }
    }


    public static void printLoggedInUserInfo() {
        if (UserRepository.loggedInUser != null) {
            System.out.println("***************로그인한 회원 정보**************");
            System.out.println("이름 : " + UserRepository.loggedInUser.getName());
            System.out.println("나이 : " + UserRepository.loggedInUser.getAge());
            System.out.println("배송지 주소 : " + UserRepository.loggedInUser.getAddress());
            System.out.println("별명 : " + UserRepository.loggedInUser.getNickname());
            System.out.println("성별 : " + UserRepository.loggedInUser.getGender());
            System.out.println("이메일 : " + UserRepository.loggedInUser.getEmail());
            System.out.println("현재 보유 금액 : " + UserRepository.loggedInUser.getMoney());
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
            System.out.println("# ✅ 비밀번호가 변경되었습니다.");
            check = false;
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");

        }
    }

    public void nicknameChange() {
        System.out.println("변경할 닉네임을 입력해주세요.");
        String newNick = input(">> ");
        UserRepository.changeNickname(newNick);
        System.out.printf("# ✅ 닉네임이 %s 로 변경되었습니다.", newNick);
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
            System.out.println("# ✅ 이메일이 변경되었습니다.");
            check = false;
        } else {
            System.out.println("이메일이 일치하지 않습니다.");

        }
    }

}



