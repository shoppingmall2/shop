package user;

import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class UserRepository {
    public static final List<User> userList = new ArrayList<>();
    public static User loggedInUser; // 현재 로그인한 사용자 정보를 저장하는 변수
    private static int loginTrueGood;
    private static int mypagepass;
    private static User searchUser;

    static {
        userList.add(new User("진훈", "kk00228", "tkdgnsdldkdlel@naver.com",
                23, "서울특별시 대림동", Gender.MALE, "상후잉"));
        userList.add(new User("진상훈", "kk002281", "t1231231nsdldkdlel@naver.com",
                19, "서울특별시 대동", Gender.MALE, "김"));
        userList.add(new User("강지혜", "1", "t1231231nsdldkdlel@naver.com",
                19, "서울특별시 대동", Gender.FEMALE, "김"));
        userList.add(new User("한기범", "gksrlqja", "hgb926@naver.com",
                27, "서울특별시 관악구 봉천로 305", Gender.MALE, "기범"));
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

    /**
     * - 비밀번호 찾기 했을 때 비밀번호 찾은 다음 비밀번호에 앞 4글자까지 * 처리를 해줌.
     * @return - 블러 처리한 비밀번호 return 시켜줌.
     */
    public static String srPass() {
        String password =  searchUser.getPassword();
        if (password.length() <= 1) {
            return password; // 패스워드 길이가 2 이하인 경우에는 그대로 반환
        }
        char[] hiddenChars = new char[password.length() - 4]; // '*'로 대체할 문자열 배열 생성
        Arrays.fill(hiddenChars, '*'); // '*'로 채워진 배열 생성
        return password.substring(0, 4) + new String(hiddenChars); //
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

    /**
     *
     * @param username - user repository에 있는 유저 이름.
     * @param password - param1인 username에 들어온 이름과 비밀번호가 맞는지 확인.
     *                 - 입력한 정보를 user에서 찾아서 loggredInUser에 따로 넣어둠.
     * @return
     */
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
    public static boolean koreanCheck(String name){
        if(name.matches("^[가-힣]*$")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean englishCheck(String name){
        if(name.matches(".*[a-z||A-Z]+.*")) {
            return false;
        } else {
            return true;
        }
    }
    public static Gender genderCheck(String genderNum) {
        switch (genderNum) {
            case "M":
                return Gender.MALE;
            case "F":
                return Gender.FEMALE;
        }
        return Gender.NULL;

    }
    /**
     *
     * @param id repository 안에 입력한 이름이 있는지 확인
     * @return 있으면 false 반환 없으면 true 반환해줌.
     */
    public static boolean alreadyLogId(String id) {
        for (User user:userList) {
            if (user.getName().equals(id)) {
                searchUser = user;
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param mail - 비밀번호 찾기 중일 때 찾는 회원과 이메일이 같으면 false 반환 해줌.
     * @return
     */
    public static boolean alreadyMail(String mail) {
        if (searchUser.getEmail().equals(mail)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param age - 비밀번호 찾기 중일 때 찾는 유저와 나이가 같으면 false 반환.
     * @return
     */
    public static boolean alreadyAge(int age) {
        if (searchUser.getAge() == age) {
            return false;
        }
        return true;
    }

    /**
     * 개인정보 찾을 때 비밀번호 한 번 확인을 해주는 것
     * @param checkPassword  - 현재 로그인한 회원과 입력한 비밀번호가 맞는 지 확인해줌.
     * @return -- 맞으면 true 리턴
     */
    public static boolean loginCheck(String checkPassword) {
        if (loggedInUser.getPassword().equals(checkPassword)) {
            return true;
        }
        return false;
    }

    // 사용자 로그아웃 메서드
    public static boolean logout() {
        loggedInUser = null;// 로그아웃 시 현재 로그인한 사용자 정보 삭제
        loginTrueGood = 0;
        return false;
    }

    public static boolean loginTrue() {
        if (loginTrueGood == 1) {
            return true;
        } else if (loginTrueGood == 0) return false;
        return false;
    }


    public boolean mypage() {
        if (mypagepass == 1) {
            return true;
        }
        return false;
    }


    /**
     *
     * @param length 길이 입력하면 charSet에 저장된 문자열을 길이에 맞게 랜덤으로 출력해줌.
     * @return 랜덤 생성한 캡챠코드 문자열로 리턴해줌.
     */
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


    /**
     *
     * @param age - 사용자가 입력한 값
     * @return
     */
    public static boolean ageCheck(int age) {
        if(age>0&&age<150){
            return true;
        }else {
            return false;

        }

    }

    /**
     *
     * @param name -- 유저 이름 받기
     * @return
     */
    public static boolean idLengthCheck(String name){
        if(name.length()>=2&&name.length()<=12) {
            return true;
        }else {
            return false;

        }
    }

//    public static String searchPass(User getPassUserName) {
//        String password = getPassUserName.getPassword();
//        if (password.length() <= 1) {
//            return password; // 패스워드 길이가 2 이하인 경우에는 그대로 반환
//        }
//        char[] hiddenChars = new char[password.length() - 1]; // '*'로 대체할 문자열 배열 생성
//        Arrays.fill(hiddenChars, '*'); // '*'로 채워진 배열 생성
//        return password.substring(0, 4) + new String(hiddenChars); // 처음 한 글자와 '*'로 대체된 문자열 합침
//    }


}