package sample;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Controller {
    public Button clickToSignup;
    public Button clickToStart;
    public Button clickToLogin;
    public ImageView textonlevelscreen;
    public Button level1Button;
    public GridPane lawngrid;
    public  Stage inGameMenuwindow;

    public void handleStart() throws IOException {
       LoginBox.getLogin();
       Main.window.close();
    }
    public void handleSignup() throws IOException {

        LoginBox.getSignup();
        LoginBox.loginwindow.close();
    }
    public void handleleveltexttransition(){
        FadeTransition ft = new FadeTransition();
        ft.setNode(textonlevelscreen);
      //  System.out.println(textonlevelscreen);
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
//    public void handlegetlevel1() throws IOException {
//
//        Level1.getlevel1(lawngrid);
//
//        LoginBox.levelwindow.close();
//    }
public    void getInGameMenu() throws IOException {
    inGameMenuwindow = new Stage();
    inGameMenuwindow.initModality(Modality.APPLICATION_MODAL);
    Parent login = FXMLLoader.load(getClass().getResource("inGameMenu.fxml"));
    Scene scene1 = new Scene(login, 1028,702);
    Button inGameResume = (Button)scene1.lookup("#inGameResumeButton");
    inGameResume.setOnAction(event -> {
        inGameMenuwindow.close();
    });
    Button inGameMainMenuButton = (Button)scene1.lookup("#inGameMainMenuButton");
    inGameMainMenuButton.setOnAction(event -> {
        try {
            LoginBox.getLevelpage();
            inGameMenuwindow.close();
            Level1.level1window.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
    
    inGameMenuwindow.setScene(scene1);
    inGameMenuwindow.setResizable(false);
    inGameMenuwindow.show();
}

}
