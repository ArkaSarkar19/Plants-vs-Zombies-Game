package sample;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class Controller {
    public Button clickToSignup;
    public Button clickToStart;
    public Button clickToLogin;
    public ImageView textonlevelscreen;
    public void handleStart() throws IOException {
       LoginBox.getLogin();
       Main.window.close();
    }
    public void handleSignup() throws IOException {
        LoginBox.getSignup();
    }
    public void handleleveltexttransition(){
        FadeTransition ft = new FadeTransition();
        ft.setNode(textonlevelscreen);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.playFromStart();

    }
    public void handleLogin() throws IOException {

        LoginBox.getLevelpage();
        LoginBox.loginwindow.close();
    }

}
