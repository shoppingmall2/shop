package kibeom;


import seungyeon.Item;
import user.User;
import user.UserRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static seungyeon.ItemRepository.getItems;
import static user.UserRepository.getUser;

public class CartRepository {
    public static List<Cart> CartList = new ArrayList<>();



//    public static void addCartList(Cart cart) {
//        CartList.add(cart);
//    }


    public static List<Cart> getCartList() {
        return CartList;
    }

    public static void setCartList(List<Cart> cartList) {
        CartList = cartList;
    }



    public static Cart isContains(String itemName) { // 입력값 확인
        List<Cart> cartList = getUser().getCartList();
        for (Cart cart : cartList) {
            if (cart.getItemName().equals(itemName)) {
                return cart;
            }
        }
        return null;
    }

    public static void deleteItem(String itemNames) {
        Iterator<Cart> iterator = CartList.iterator();
        while (iterator.hasNext()) {
            Cart cart = iterator.next();
            if (cart.getItemName().equals(itemNames)) {
                iterator.remove();
            }
        }
    }

    Item buyitem;
    public static Item addNewItem(String itemName) {
        List<Item> items1 = getItems();
        for (Item item : items1) {
            if (item.getItemName().toLowerCase().equals(itemName)){
                CartList.add(new Cart(item.getBrand(), item.getItemName(), item.getType(),item.getPrice(),item.getGender()));
            }
        }
        return null;
    }
    public static void addCartList(Cart cart) {
        getUser().getCartList().add(cart); // 해당 사용자의 장바구니에 상품 추가
    }
    public static void deleteItem(User user, String itemName) {
        Iterator<Cart> iterator = user.getCartList().iterator();
        while (iterator.hasNext()) {
            Cart cart = iterator.next();
            if (cart.getItemName().equals(itemName)) {
                iterator.remove(); // 해당 사용자의 장바구니에서 상품 제거
            }
        }
    }



}

