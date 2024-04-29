package user;

import java.util.ArrayList;
import java.util.List;



public class UserRepository {
    public static final List<User> userList = new ArrayList<>();
    private static User loggedInUser; // 현재 로그인한 사용자 정보를 저장하는 변수
    private static int loginTrueGood;
    private static int mypagepass;

    static {
        userList.add(new User("진상훈", "kk00228", "tkdgnsdldkdlel@naver.com",
                23, "서울특별시 대림동", "남", "상후잉"));
        userList.add(new User("진상훈", "kk002281", "t1231231nsdldkdlel@naver.com",
                19, "서울특별시 대동", "남", "김"));
        userList.add(new User("한기범","gksrlqja","hgb926@naver.com",
                27, "서울특별시 관악구", "남", "기범"));
        userList.add(new User("1","1","hgb926@naver.com",
                27, "서울특별시 관악구", "남", "기범")); // 테스트용 계정

    }

    public static void addUser(User user) {
        userList.add(user);
    }

    public static String getPass() {
        return loggedInUser.getPassword();
    }

//    public static int getMoney() {
//        return loggedInUser.getMoney();
//    }
    public static User getUser() {
        return loggedInUser;
    }

    public static void printLoggedInUserInfo() {
        if (loggedInUser != null) {
            System.out.println("***************로그인한 회원 정보**************");
            System.out.println("이름 : " + loggedInUser.getName());
            System.out.println("나이 : " + loggedInUser.getAge());
            System.out.println("주소 : "+ loggedInUser.getAddress());
            System.out.println("별명 : " + loggedInUser.getNickname());
            System.out.println("성별 : " + loggedInUser.getGender());
            System.out.println("이메일 : " + loggedInUser.getEmail());
            System.out.println("비번 : " + loggedInUser.getPassword());
            System.out.println("잔액 : " + loggedInUser.getMoney());
        } else {
            System.out.println("로그인한 회원이 없습니다.");
        }
    }

    public static void ChangePass(String newPass) {

       loggedInUser.setPassword(newPass);
        System.out.println(loggedInUser.getPassword());
    }


    // 사용자 로그인 메서드
    public static void login(String username, String password) {
        for (User user : userList) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user; // 로그인한 사용자 정보 저장
                System.out.println("로그인 성공!");
                loginTrueGood = 1;
                return;
            }
        }
        System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
    }

    // 사용자 로그아웃 메서드
    public static void logout() {
        loggedInUser = null; // 로그아웃 시 현재 로그인한 사용자 정보 삭제
        System.out.println("로그아웃 되었습니다.");
    }

    public static boolean loginTrue() {
        if (loginTrueGood == 1) {
            return true;
        }
        return false;
    }

    public boolean mypage() {
        if (mypagepass == 1) {
            return true;
        }
        return false;
    }


}
