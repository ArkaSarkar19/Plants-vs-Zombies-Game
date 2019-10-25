package sample;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.time.Duration;

public class Controller {
    public Button clickToSignup;
    public Button clickToStart;
    public ImageView textonlevelscreen;
    public void handleStart() throws IOException {
       LoginBox.getLogin();
    }
    public void handleSignup() throws IOException {
        LoginBox.getSignup();
    }
    public void handleleveltexttransition(){
        FadeTransition ft = new FadeTransition();
        ft.setNode(textonlevelscreen);
        ft.setDuration(new Duration(0.5);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(6);
        ft.setAutoReverse(true);

    }

}
