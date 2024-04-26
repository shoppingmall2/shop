import util.SimpleInput;

public class View {

    private UserRepository userRepo;
    public View() {
        this.userRepo = userRepo;
    }

    public void start() {
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 프로그램 종료");
        String menuNum = SimpleInput.input(">> ");

        switch (menuNum) {
            case "1":
                makeUser();
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                System.out.println("1~3.");
        }
    }

    private void makeUser() {
        String name = SimpleInput.input("이름: ");
        String password = SimpleInput.input("비밀번호: ");
        String email = SimpleInput.input("이메일: ");
        int age = Integer.parseInt(SimpleInput.input("나이: "));
        String address = SimpleInput.input("주소: ");
        String gender = SimpleInput.input("성별: ");
        String nickname = SimpleInput.input("닉네임: ");
        User newUser = new User(name, password, email, age, address, gender, nickname);
        userRepo.addMember(newUser);

    }
}
