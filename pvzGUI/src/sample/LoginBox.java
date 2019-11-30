package sample;
import javafx.animation.Animation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

//import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.io.IOException;
import java.nio.file.Paths;

public class LoginBox {
    public static Stage loginwindow;
    public static Stage signupwindow;
    public static Stage levelwindow;


    public static void getLogin() throws IOException {
        loginwindow = new Stage();
        loginwindow.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("LoginBox.fxml"));
        Scene scene1 = new Scene(login, 720,405);
        Button logincancel = (Button)scene1.lookup("#loginCancelButton");
        logincancel.setOnAction(event -> loginwindow.close());

        loginwindow.setScene(scene1);
        loginwindow.setTitle("Login");
        loginwindow.setResizable(false);
        loginwindow.showAndWait();
    }
    public static void getSignup() throws IOException {
        signupwindow = new Stage();
        signupwindow.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("Signup.fxml"));
        Scene scene1 = new Scene(login);
        Button letsGo = (Button)scene1.lookup("#letsGoSignup");
        Button cancel = (Button)scene1.lookup("#cancelSignup");
        letsGo.setOnAction(event -> {
            try {
                getLogin();
                signupwindow.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        cancel.setOnAction(event -> signupwindow.close());
        signupwindow.setScene(scene1);
        signupwindow.setTitle("Register");
        signupwindow.setResizable(false);
        signupwindow.show();

    }
    public static void getLevelpage() throws IOException {

        Main.zombieSound.setCycleCount(Animation.INDEFINITE);
        Main.zombieSound.setAutoPlay(true);
        Main.zombieSound.play();
        levelwindow = new Stage();
        levelwindow.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("SelectLevel.fxml"));
        Scene scene1 = new Scene(login);
        Button level1Button = (Button)scene1.lookup("#level1Button");
        Button level2Button = (Button)scene1.lookup("#level2");
        Button level3Button = (Button)scene1.lookup("#level3");
        Button level4Button = (Button)scene1.lookup("#level4");
        Button level5Button = (Button)scene1.lookup("#level5");


        level1Button.setOnAction(event -> {
            Level1 l = new Level1(null);
            try {
                l.getlevel();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            levelwindow.close();
        });

        level2Button.setOnAction(event -> {
            Level2 l = new Level2(null);
            try {
                l.getlevel();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            levelwindow.close();
        });
        level3Button.setOnAction(event -> {
            Level3 l = new Level3(null);
            try {
                l.getlevel();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            levelwindow.close();
        });
        level4Button.setOnAction(event -> {
            Level4 l = new Level4(null);
            try {
                l.getlevel();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            levelwindow.close();
        });
        level5Button.setOnAction(event -> {
            Level5 l = new Level5(null);
            try {
                l.getlevel();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            levelwindow.close();
        });
        levelwindow.setScene(scene1);
        levelwindow.setTitle("Select Level");
        levelwindow.setResizable(false);
        levelwindow.show();
    }
}

