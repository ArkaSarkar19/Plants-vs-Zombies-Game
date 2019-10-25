package sample;

import javafx.scene.control.Button;

import java.io.IOException;

public class Controller {
    public Button clickToSignup;
    public Button clickToStart;
    public void handleStart() throws IOException {
       LoginBox.getLogin();
    }
    public void handleSignup() throws IOException {
        LoginBox.getSignup();
    }

}
