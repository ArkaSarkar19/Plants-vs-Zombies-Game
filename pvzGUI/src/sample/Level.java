package sample;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.Serializable;
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
    @FXML
    private Label progressText;
    public ArrayList<NormalZombie> lane = new ArrayList<>();
    double start ;
    public static Stage level1window;

    public static TranslateTransition tt;
    public Level1(Player player,GameScreen gameInstance){
        super(new ArrayList<String>(),new ArrayList<String>(),new double[3], gameInstance, player);

    }

    public  void getlevel1() throws IOException, InterruptedException {
        start = System.currentTimeMillis();
        level1window = new Stage();
        level1window.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("Level1.fxml"));
        Scene scene1 = new Scene(login, 1028,702);
        GridPane p = (GridPane)scene1.lookup("#lawngrid");
        GameScreen gameScreen = new GameScreen();
        gameScreen.setLawngrid(p);
        Controller.setGameScreen(gameScreen);
        level1window.setScene(scene1);
        level1window.setTitle("LEVEL 1");
        level1window.setResizable(false);
        level1window.show();
        double duration = 5*1000;
        Label progressText = (Label)scene1.lookup("#progessText");
        Timeline tml = new Timeline();
        gameScreen.setTimeline(tml);
        gameScreen.spawnZombie();
        KeyFrame k1 = new KeyFrame(new Duration(10),event -> {
            progressText.setText(String.valueOf((Math.round((System.currentTimeMillis() - start)/duration))) + "%");
        });
        tml.getKeyFrames().add(k1);
        tml.play();
    }
}