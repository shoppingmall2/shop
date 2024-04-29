package user;

import java.util.*;


public class UserRepository {
    public static final List<User> userList = new ArrayList<>();
    public static User loggedInUser; // 현재 로그인한 사용자 정보를 저장하는 변수
    private static int loginTrueGood;
    private static int mypagepass;

    static {
        userList.add(new User("진상훈", "kk00228", "tkdgnsdldkdlel@naver.com",
                23, "서울특별시 대림동", "남", "상후잉"));
        userList.add(new User("진상훈", "kk002281", "t1231231nsdldkdlel@naver.com",
                19, "서울특별시 대동", "남", "김"));

    }


    public static void addUser(User user) {
        userList.add(user);
    }
    public static User getUser() {
        return loggedInUser;
    }

    public static String getPass() {
        return loggedInUser.getPassword();
    }

    public static String getNickName() {
        return loggedInUser.getNickname();
    }
    public static String getEmail() {
        return loggedInUser.getEmail();
    }


    public static void ChangePass(String newPass) {

        loggedInUser.setPassword(newPass);
    }

    public static void changeNickname(String newNick) {

        loggedInUser.setNickname(newNick);
    }

    public static void changeEmail(String email) {
        loggedInUser.setEmail(email);
    }

    // 사용자 로그인 메서드
    public static boolean login(String username, String password) {
        for (User user : userList) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user; // 로그인한 사용자 정보 저장
                loginTrueGood = 1;
                return true;
            }
        }
        return false;
    }

    public static boolean loginCheck(String checkPassword) {
        if (loggedInUser.getPassword().equals(checkPassword)) {
            return true;
        }
        return false;
    }

    // 사용자 로그아웃 메서드
    public static boolean logout() {
        loggedInUser = null;// 로그아웃 시 현재 로그인한 사용자 정보 삭제
        return false;
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

    // 자동 입력 방지 문자 생성
    public static String generateCaptcha(int length) {
        // 사용할 문자 범위 설정
        String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random rnd = new Random();
        // 문자열 생성
        for (int i = 0; i < length; i++) {
            captcha.append(charSet.charAt(rnd.nextInt(charSet.length())));
        }

        return captcha.toString();
    }

    public static String generateThisTime() {
        Calendar currentTime = Calendar.getInstance();
        int year = currentTime.get(Calendar.YEAR);
        int month = currentTime.get(Calendar.MONTH) + 1; // 월은 0부터 시작하므로 +1
        int day = currentTime.get(Calendar.DAY_OF_MONTH);
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);
        int second = currentTime.get(Calendar.SECOND);
        return "현재 시간: " + year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
    }

    public static String blindPassword() {
        String password = loggedInUser.getPassword();
        if (password.length() <= 1) {
            return password; // 패스워드 길이가 2 이하인 경우에는 그대로 반환
        }
        char[] hiddenChars = new char[password.length() - 1]; // '*'로 대체할 문자열 배열 생성
        Arrays.fill(hiddenChars, '*'); // '*'로 채워진 배열 생성
        return password.substring(0, 1) + new String(hiddenChars); // 처음 한 글자와 '*'로 대체된 문자열 합침
    }
}

