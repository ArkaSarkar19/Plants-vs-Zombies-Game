package sample;
import javafx.animation.*;
import javafx.scene.control.Button;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;

public class Level implements Serializable {
    protected ArrayList<String> availablePlants;
    protected  ArrayList<String> avalableZombies;
    protected double[] probabilityZombie;
    protected GameScreen gameInstance;
    protected Player player;

    public Level(ArrayList<String> availablePlants,ArrayList<String> avalableZombies,double[] probabilityZombie,GameScreen gameInstance,Player player){
        this.availablePlants = availablePlants;
        this.avalableZombies = avalableZombies;
        this.probabilityZombie = probabilityZombie;
        this.gameInstance = gameInstance;
        this.player = player;
    }
    public void produceZombies(){

    }

    public ArrayList<String> getAvailablePlants() {
        return availablePlants;
    }

    public ArrayList<String> getAvalableZombies() {
        return avalableZombies;
    }

    public double[] getProbabilityZombie() {
        return probabilityZombie;
    }

    public GameScreen getGameInstance() {
        return gameInstance;
    }

    public Player getPlayer() {
        return player;
    }
    public void saveGame() throws IOException{

    }
    public void pause(){

    }


}

class Level1 extends Level{
    public ArrayList<NormalZombie> lane = new ArrayList<>();
    double start ;
    public static Stage level1window;
    public static TranslateTransition tt;
    public Level1(Player player,GameScreen gameInstance){
        super(new ArrayList<String>(),new ArrayList<String>(),new double[3], gameInstance, player);

    }

    public  void getlevel1() throws IOException, InterruptedException {
        start = System.currentTimeMillis();
        level1window = Main.window;
        //level1window.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("Level1.fxml"));
        Scene scene1 = new Scene(login, 1028,702);
        GridPane p = (GridPane)scene1.lookup("#lawngrid");

        NormalPeaShooter peashooter = new NormalPeaShooter(new int[]{4,1});
        GameScreen gameScreen = new GameScreen();
        gameScreen.setLawngrid(p);

        gameScreen.addPlant(new int[]{4,1},peashooter);

        level1window.setScene(scene1);
        level1window.setTitle("LEVEL 1");
        level1window.setResizable(false);
        level1window.show();
        Timeline tml = new Timeline();
        tml.setCycleCount(Timeline.INDEFINITE);
        KeyFrame k = new KeyFrame(new Duration(3000),event -> {
            gameScreen.produceZombies();
        });
        tml.getKeyFrames().add(k);



        tml.play();

    }
}