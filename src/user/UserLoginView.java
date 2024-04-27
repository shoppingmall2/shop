package user;

import static user.UserRepository.generateCaptcha;
import static user.UserRepository.generateThisTime;
import static util.SimpleInput.input;

public class UserLoginView {
    static UserRepository ur;

    public void start() {

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
        String captcha = generateCaptcha(6);
        String agree = input("개인정보 수집 및 회원가입에 동의하시겠습니까? [Y, N]\n >> ").toUpperCase();
        if (agree.equals("Y")){
            System.out.println(generateThisTime()+"에 개인정보에 동의하셨습니다.");
            System.out.println("자동 입력 방지 문자: " + captcha);
            while (true) {
                String captchaTrue = input("자동 입력 방지 문자를 보이는대로 입력해주세요. \n >>");
                if (captchaTrue.equals(captcha))  {
                User newUser = new User(name, password, email, age, address, gender, nickname);
                UserRepository.addUser(newUser);
                    System.out.println("#. 회원가입이 완료되었습니다.");
                    break;
                } else {
                    System.out.println("! 자동 입력 방지 문자를 확인해주세요");
                    System.out.println("[# 1. 자동 입력 방지 문자 새로고침]");
                    int menuNum = Integer.parseInt(input(">> "));

                    switch (menuNum) {
                        case 1 :
                            captcha = generateCaptcha(6);
                            System.out.println("자동 입력 방지 문자: " + captcha);
                    }
                }
            }
        } else {
            System.out.println("그럼 가입하지마");
        }
    }

    private void callLogin() {
        System.out.println("***************로그인 필수 입력 항목************");
        String name = input("이름 : ");
        String password = input("비밀번호 : ");
        UserRepository.login(name, password);
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
//                    signUpUser();
                    break;
                case "2":
                    printLoggedInUserInfo();
                    break;
                case "3":
                    passCheck();
                    check = true;
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

    public void byebye() {
        UserRepository.logout();
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



    public static void printLoggedInUserInfo() {
        if (UserRepository.loggedInUser != null) {
            System.out.println("***************로그인한 회원 정보**************");
            System.out.println("이름 : " + UserRepository.loggedInUser.getName());
            System.out.println("나이 : " + UserRepository.loggedInUser.getAge());
            System.out.println("배송지 주소 : "+ UserRepository.loggedInUser.getAddress());
            System.out.println("별명 : " + UserRepository.loggedInUser.getNickname());
            System.out.println("성별 : " +UserRepository.loggedInUser.getGender());
            System.out.println("이메일 : " + UserRepository.loggedInUser.getEmail());
            System.out.println("비번 : " + UserRepository.loggedInUser.getPassword());
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

}



