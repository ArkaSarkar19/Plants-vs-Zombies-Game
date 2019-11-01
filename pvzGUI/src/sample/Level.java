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
        level1window = new Stage();
        level1window.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("Level1.fxml"));
        Scene scene1 = new Scene(login, 1028,702);
        GridPane p = (GridPane)scene1.lookup("#lawngrid");
        Timeline tml = new Timeline();
        tml.setCycleCount(Timeline.INDEFINITE);

            tml.playFrom(String.valueOf(((System.currentTimeMillis() - start + 4000))));
            {
               for(int i=0;i<10;i++) {
                   NormalZombie z = new NormalZombie(2);
                   p.add(z.getZombieImage(), 9, i%5);
                   z.move(tml,i);

               }
                NormalZombie z = new NormalZombie(2);
                p.add(z.getZombieImage(), 9, 5);
                z.move(tml,0);



            }

        tml.play();


        level1window.setScene(scene1);
        level1window.setTitle("LEVEL 1");
        level1window.setResizable(false);
        level1window.show();

//        tt.play();
//        TranslateTransition ttx = new TranslateTransition();
//        ttx.setNode(zx);
//        ttx.setDuration(Duration.millis(40000));
//        ttx.setByX(-800);
//        ttx.setCycleCount(5);
////        ttx.play();
//        ParallelTransition pt = new ParallelTransition(tt,ttx);
//
//        pt.play();
//        tt.setNode(zomb);
//        tt.setDuration(Duration.millis(40000));
//        tt.setByX(-800);
//        tt.setCycleCount(5);
//        tt.play();
//        System.out.println(tt.getCurrentTime());
//        p.add(zomb,9,0);
//        p.add(zx,9,7);

    }
}