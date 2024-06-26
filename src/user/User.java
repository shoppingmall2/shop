package user;

import jihye.Buy;
import jihye.BuyRepository;
import jihye.DeliveryRepository;
import kibeom.Cart;
import sanghun.Address;
import seungyeon.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private final String name; // 이름
    private String password; // 비번
    private int money;
    private String email; // 이멜
    private final int age; // 나이
//    private String address; // 주소
    private final Gender gender;
    private String nickname; // 닉ㄴㅇ
    private List<Cart> cartList;
    private List<Buy> buylist;
    private List<Address> address;
    private Address defaultAddress;



    public User(String name, String password, String email, int age, Gender gender, String nickname) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.nickname = nickname;
        this.money = 300000; // 0427 money 추가
        this.cartList = new ArrayList<>();
        this.buylist = new ArrayList<>();
        this.address = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public List<Buy> getBuylist() {
        return buylist;
    }

    public List<Address> getAddress() {
        return address;
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


    public Gender getGender() {
        return gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setDefaultAddress(Address address) {
        this.defaultAddress = address;
    }


    public Address getDefaultAddress() {
        return defaultAddress;
    }
    public List<Cart> getCartList() {
        return cartList;
    }
    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
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