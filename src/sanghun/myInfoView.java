package sanghun;

import user.UserRepository;

import static util.SimpleInput.input;


public class myInfoView {

    private UserRepository userRepository;

    public void infoView() {
        while (true) {
            userRepository.printLoggedInUserInfo();
        }
    } // start end
}
