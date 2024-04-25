public class SignUpUser {

    // 1명의 회원가입 정보를 갖는 객체
    SignUpUser[] mArr;

    void MemberList() {
        this.mArr = new SignUpUser[0];
    }

    private String id;
    private String password;
    private String name;
    private String nickName;
    private int age;
    private String gender;
    private String email;
    private String address;

    public SignUpUser(String id, String password, String name, String nickName, int age, String gender, String email, String address) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SignUpUser{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int findIndex(String targetEmail) {
        for (int i = 0; i < mArr.length; i++) {
            if (email.equals(mArr[i].email)) {
                return i;
            }
        }
        return -1;
    }
}
