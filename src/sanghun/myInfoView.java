package sanghun;

import user.UserLoginView;
import user.UserRepository;

import static util.SimpleInput.input;


public class myInfoView {

    private UserRepository userRepository;

    public void infoView() {
        while (true) {
            UserLoginView.printLoggedInUserInfo();
        }
    } // start end
}