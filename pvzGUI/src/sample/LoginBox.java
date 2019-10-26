package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginBox {
    public static Stage loginwindow;
    public static Stage signupwindow;
    public static Stage levelwindow;


    public static void getLogin() throws IOException {
        loginwindow = new Stage();
        loginwindow.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("LoginBox.fxml"));
        Scene scene1 = new Scene(login, 720,405);
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
        signupwindow.setScene(scene1);
        signupwindow.setTitle("Register");
        signupwindow.setResizable(false);
        signupwindow.showAndWait();
    }
    public static void getLevelpage() throws IOException {
        levelwindow = new Stage();
        levelwindow.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("SelectLevel.fxml"));
        Scene scene1 = new Scene(login);
        levelwindow.setScene(scene1);
        levelwindow.setTitle("Select Level");
        levelwindow.setResizable(false);
        levelwindow.show();
    }
}

