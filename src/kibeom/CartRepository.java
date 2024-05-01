package kibeom;


import seungyeon.Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static jihye.DeliveryRepository.buyList;
import static seungyeon.ItemRepository.getItems;

public class CartRepository {
    public static List<Cart> CartList = new ArrayList<>();

    static {
        CartList.add(new Cart("유니클로", "jacket", "TOP", 130000, "남성"));
    }

    public static void addCartList(Cart cart) {
        CartList.add(cart);
    }


    public static List<Cart> getCartList() {
        return CartList;
    }

    public static void setCartList(List<Cart> cartList) {
        CartList = cartList;
    }



    public static Cart isContains(String itemName) { // 입력값 확인
        for (Cart cart : CartList) {
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
}

