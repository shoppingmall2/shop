package kibeom;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartRepository {
    public static List<Cart> CartList = new ArrayList<>();

    static {
        CartList.add(new Cart("jacket", "TOP", 130000, "남성"));
        CartList.add(new Cart("jean", "BOTTOM", 30000, "남성"));
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

    public static void showCartRepository() {
        List<Cart> cartList = getCartList();
        System.out.println();
        for (Cart cart : cartList) {
            System.out.println( "제품 명 : " + cart.getItemName() + "\n" +
                    "제품 분류 : " + cart.getType() + "\n" +
                    "제품 가격 : " + cart.getPrice() + "\n" +
                    "성별 : " + cart.getGender() + "\n" + "\n");
        }

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

    @Override
    public String toString() {
        return super.toString();
    }
}

