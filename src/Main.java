import kibeom.CartRepository;
import user.UserLoginView;


public class Main {
    public static void main(String[] args) {
        UserLoginView userLoginView = new UserLoginView();
        CartRepository cartRepository = new CartRepository();
        userLoginView.start();
    }
}
