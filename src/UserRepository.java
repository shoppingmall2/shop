import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static final List<User> userList = new ArrayList<>();
    private static User loggedInUser; // 현재 로그인한 사용자 정보를 저장하는 변수

    static {
        userList.add(new User("진상훈","kk00228","tkdgnsdldkdlel@naver.com",
                23,"서울특별시 대림동","남","상후잉"));
        userList.add(new User("진상훈","kk002281","t1231231nsdldkdlel@naver.com",
                19,"서울특별시 대동","남","김"));

    }

    public static void addUser(User user) {
        userList.add(user);
    }

    public static void printLoggedInUserInfo() {
        if (loggedInUser != null) {
            System.out.println("***************로그인한 회원 정보************");
            System.out.println(loggedInUser);
        } else {
            System.out.println("로그인한 회원이 없습니다.");
        }
    }

    // 사용자 로그인 메서드
    public static void login(String username, String password) {
        for (User user : userList) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user; // 로그인한 사용자 정보 저장
                System.out.println("로그인 성공!");
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
}
