package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
