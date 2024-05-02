package user;

import java.util.Objects;

public class User {
    private final String name; // 이름
    private String password; // 비번
    private int money;
    private String email; // 이멜
    private final int age; // 나이
    private final String address; // 주소
    private final Gender gender;
    private String nickname; // 닉ㄴㅇ




    public User(String name, String password, String email, int age, String address, Gender gender, String nickname) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.nickname = nickname;
        this.money = 300000; // 0427 money 추가
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public String setNickname(String nickname) {
        return this.nickname = nickname;
    }
    public String setEmail(String email) {
        return this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(gender, user.gender) && Objects.equals(nickname, user.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, email, age, address, gender, nickname);
    }

    /*
    0427 user 필드로 money 추가 후, toString 에 money 추가
     */
    @Override
    public String toString() {
        return "user.User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", nickname='" + nickname + '\'' +
                ", money=" + money +
                '}';
    }

}