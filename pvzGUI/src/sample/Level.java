package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
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
    public static Stage level1window;

    public Level1(Player player,GameScreen gameInstance){
        super(new ArrayList<String>(),new ArrayList<String>(),new double[3], gameInstance, player);

    }

    public static void getlevel1() throws IOException {
        level1window = new Stage();
        level1window.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("Level1.fxml"));
        Scene scene1 = new Scene(login, 1028,702);
        level1window.setScene(scene1);
        level1window.setTitle("LEVEL 1");
        level1window.setResizable(false);
        level1window.show();
    }
}