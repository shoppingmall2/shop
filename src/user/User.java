package user;

import java.util.Objects;

public class User {
    private final String name; // 이름
    private String password; // 비번
    private final String email; // 이멜
    private final int age; // 나이
    private final String address; // 주소
    private final String gender;
    private final String nickname; // 닉ㄴㅇ




    public User(String name, String password, String email, int age, String address, String gender, String nickname) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.nickname = nickname;
    }

    public String setPassword(String password) {
        return this.password = password;
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

    public String getGender() {
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
                '}';
    }

}
