package seungyeon;
//
//import kibeom.CartRepository;
//import user.User;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Cart {
//    private final static List<String> items = new ArrayList<>();
//
//    public Cart() {
//
//    }
//
//
//
//
//    // 제품을 장바구니에 추가하는 메서드
//    public static void addItem(String item) {
//        items.add(item);
//////        getitemList();
//
//    }
//
//    public static void getitemList() {
//        for (String item : items) {
//            System.out.println("item = " + item);
//        }
//    }
//}
//

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static final List<String> items = new ArrayList<>();

    public Cart() {

    }

    public static void addItem(String item) {
        items.add(item);
        // getitemList(); // 주석 처리된 부분은 필요하지 않을 것 같아 주석 처리했습니다.
    }

    public static void getitemList() {
        for (String item : items) {
            System.out.println("item = " + item);
        }
    }
}





