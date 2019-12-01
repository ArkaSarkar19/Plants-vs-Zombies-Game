package sample;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {
    public static Parent root;
    public static Stage window;
//    public static MediaPlayer menuSound = new MediaPlayer(new Media(Paths.get("/home/arkasarkar/Desktop/APPROJECT/Plants-vs-Zombies/pvzGUI/src/sample/resources/sounds/menu.wav").toUri().toString()));
//   public static MediaPlayer zombieSound = new MediaPlayer(new Media(Paths.get("/home/arkasarkar/Desktop/APPROJECT/Plants-vs-Zombies/pvzGUI/src/sample/resources/sounds/zombies_coming.wav").toUri().toString()));
    public static MediaPlayer menuSound = new MediaPlayer(new Media(Paths.get("D:\\Rachit\\Semester 3\\AP\\Plants-vs-Zombies\\pvzGUI\\src\\sample\\resources\\sounds\\menu.wav").toUri().toString()));
    public static MediaPlayer zombieSound = new MediaPlayer(new Media(Paths.get("D:\\Rachit\\Semester 3\\AP\\Plants-vs-Zombies\\pvzGUI\\src\\sample\\resources\\sounds\\zombies_coming.wav").toUri().toString()));

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        root = FXMLLoader.load(getClass().getResource("startpage.fxml"));
        window.setTitle("Plants Vs Zombies");
        window.setScene(new Scene(root, 1080, 805));
        window.setResizable(false);
        window.show();
        menuSound.setCycleCount(Animation.INDEFINITE);
        menuSound.setAutoPlay(true);
        menuSound.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
//module javafx {
//    requires javafx.controls;
//    requires javafx.fxml;
//    opens sample;
//}