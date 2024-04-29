package sanghun;

<<<<<<< HEAD
=======
import user.UserLoginView;
>>>>>>> main
import user.UserRepository;

import static util.SimpleInput.input;


public class myInfoView {

    private UserRepository userRepository;

    public void infoView() {
        while (true) {
<<<<<<< HEAD
            userRepository.printLoggedInUserInfo();
=======
            UserLoginView.printLoggedInUserInfo();
>>>>>>> main
        }
    } // start end
}
