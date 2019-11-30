package sample;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Level extends GameObject implements Serializable  {
    protected ArrayList<String> availablePlants;
    protected  ArrayList<String> avalableZombies;
    protected double[] probabilityZombie;
    protected Player player;
    protected Pane[][] panes;
    protected Scene scene1;
    protected int totalZombies;
    protected int zombiesKilled;
    protected int currentZombies;
    protected double progress;
    protected Boolean levelCompleted;
    protected   static Stage levelwindow;
    public Level(ArrayList<String> availablePlants,ArrayList<String> avalableZombies,double[] probabilityZombie,Player player){
        this.availablePlants = availablePlants;
        this.avalableZombies = avalableZombies;
        this.probabilityZombie = probabilityZombie;
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



    public Player getPlayer() {
        return player;
    }
    public void saveGame() throws IOException{

    }
    public void pause(){

    }
    public void setPanes(Pane[][] panes) {
        this.panes = panes;
    }
    public Pane[][] getPanes(){
        return this.panes;
    }

    public Scene getScene() {
        return scene1;
    }

    public int getCurrentZombies() {
        return currentZombies;
    }

    public void setCurrentZombies(int currentZombies) {
        this.currentZombies = currentZombies;
    }

    public int getTotalZombies() {
        return totalZombies;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        if(progress >=100) this.progress = 100;
        else this.progress = progress;
    }

    public Stage getLevelwindow() {
        return levelwindow;
    }
    public void getlevel() throws IOException, InterruptedException {
        Main.menuSound.stop();
        Main.zombieSound.stop();
    }

    public void setZombiesKilled() {
        this.zombiesKilled++;
    }

    public int getZombiesKilled() {
        return zombiesKilled;
    }
}

class Level1 extends Level{
    @FXML
    private Label progressText;

    public ArrayList<NormalZombie> lane = new ArrayList<>();
    double start ;
    public static TranslateTransition tt;
    public Level1(Player player){
        super(new ArrayList<String>(),new ArrayList<String>(),new double[3], player);
        totalZombies = 28;
        this.availablePlants = new ArrayList<String>();
        this.availablePlants.add("peaShooter");
        this.availablePlants.add("sunFlower");
        this.avalableZombies = new ArrayList<String>();
        this.avalableZombies.add("normal_zombie");
    }
    @Override
    public  void getlevel() throws IOException, InterruptedException {
        super.getlevel();
        start = System.currentTimeMillis();
        levelwindow = new Stage();
        levelwindow.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("Level1.fxml"));
        scene1 = new Scene(login, 1028,702);
        GridPane p = (GridPane)scene1.lookup("#lawngrid");
        Pane sp00 = (Pane)scene1.lookup("#sp00");
        Pane sp01 = (Pane)scene1.lookup("#sp01");
        Pane sp02 = (Pane)scene1.lookup("#sp02");
        Pane sp03 = (Pane)scene1.lookup("#sp03");
        Pane sp04 = (Pane)scene1.lookup("#sp04");
        Pane sp10 = (Pane)scene1.lookup("#sp10");
        Pane sp11 = (Pane)scene1.lookup("#sp11");
        Pane sp12 = (Pane)scene1.lookup("#sp12");
        Pane sp13 = (Pane)scene1.lookup("#sp13");
        Pane sp14 = (Pane)scene1.lookup("#sp14");
        Pane sp20 = (Pane)scene1.lookup("#sp20");
        Pane sp21 = (Pane)scene1.lookup("#sp21");
        Pane sp22 = (Pane)scene1.lookup("#sp22");
        Pane sp23 = (Pane)scene1.lookup("#sp23");
        Pane sp24 = (Pane)scene1.lookup("#sp24");
        Pane sp30 = (Pane)scene1.lookup("#sp30");
        Pane sp31 = (Pane)scene1.lookup("#sp31");
        Pane sp32 = (Pane)scene1.lookup("#sp32");
        Pane sp33 = (Pane)scene1.lookup("#sp33");
        Pane sp34 = (Pane)scene1.lookup("#sp34");
        Pane sp40 = (Pane)scene1.lookup("#sp40");
        Pane sp41 = (Pane)scene1.lookup("#sp41");
        Pane sp42 = (Pane)scene1.lookup("#sp42");
        Pane sp43 = (Pane)scene1.lookup("#sp43");
        Pane sp44 = (Pane)scene1.lookup("#sp44");
        Pane sp50 = (Pane)scene1.lookup("#sp50");
        Pane sp51 = (Pane)scene1.lookup("#sp51");
        Pane sp52 = (Pane)scene1.lookup("#sp52");
        Pane sp53 = (Pane)scene1.lookup("#sp53");
        Pane sp54 = (Pane)scene1.lookup("#sp54");
        Pane sp60 = (Pane)scene1.lookup("#sp60");
        Pane sp61 = (Pane)scene1.lookup("#sp61");
        Pane sp62 = (Pane)scene1.lookup("#sp62");
        Pane sp63 = (Pane)scene1.lookup("#sp63");
        Pane sp64 = (Pane)scene1.lookup("#sp64");
        Pane sp70 = (Pane)scene1.lookup("#sp70");
        Pane sp71 = (Pane)scene1.lookup("#sp71");
        Pane sp72 = (Pane)scene1.lookup("#sp72");
        Pane sp73 = (Pane)scene1.lookup("#sp73");
        Pane sp74 = (Pane)scene1.lookup("#sp74");
        Pane sp80 = (Pane)scene1.lookup("#sp80");
        Pane sp81 = (Pane)scene1.lookup("#sp81");
        Pane sp82 = (Pane)scene1.lookup("#sp82");
        Pane sp83 = (Pane)scene1.lookup("#sp83");
        Pane sp84 = (Pane)scene1.lookup("#sp84");
        Pane[][] panes = new Pane[][]{{sp00,sp01,sp02,sp03,sp04},{sp10,sp11,sp12,sp13,sp14},{sp20,sp21,sp22,sp23,sp24},{sp30,sp31,sp32,sp33,sp34},{sp40,sp41,sp42,sp43,sp44},{sp50,sp51,sp52,sp53,sp54},{sp60,sp61,sp62,sp63,sp64},{sp70,sp71,sp72,sp73,sp74},{sp80,sp81,sp82,sp83,sp84}};
        this.setPanes(panes);
        GameScreen gameScreen = new GameScreen();
        super.gameScreen = gameScreen;
        gameScreen.setLevel(this);
        Lawnmower m1 = new Lawnmower(0,(ImageView) scene1.lookup("#lMower1"),gameScreen);
        Lawnmower m2 = new Lawnmower(1,(ImageView) scene1.lookup("#lMower2"),gameScreen);
        Lawnmower m3 = new Lawnmower(2,(ImageView) scene1.lookup("#lMower3"),gameScreen);
        Lawnmower m4 = new Lawnmower(3,(ImageView) scene1.lookup("#lMower4"),gameScreen);
        Lawnmower m5 = new Lawnmower(4,(ImageView) scene1.lookup("#lMower5"),gameScreen);
        Lawnmower[] lawnmowers = new Lawnmower[]{m1,m2,m3,m4,m5};
        gameScreen.setLawnmowers(lawnmowers);
        gameScreen.setLawngrid(p);
        Controller.setGameScreen(gameScreen);
        levelwindow.setScene(scene1);
        levelwindow.setTitle("LEVEL 1");
        levelwindow.setResizable(false);
        levelwindow.show();
        levelwindow.setOnCloseRequest(event -> {
            this.gameScreen.stop();
            this.gameScreen = null;
            // System.gc();
            levelwindow = null;
        });
        double duration = 5*1000;
        Label progressText = (Label)scene1.lookup("#progessText");
        Timeline tml = new Timeline();
        gameScreen.setTimeline(tml);
        gameScreen.setLevel(this);
        gameScreen.start();
        tml.play();
        gameScreen.getBuyPlantTimeline().play();
        gameScreen.getSoundTimeline().play();


    }

}

class Level2 extends Level{
    @FXML
    private Label progressText;

    public ArrayList<NormalZombie> lane = new ArrayList<>();
    double start ;
    public static TranslateTransition tt;
    public Level2(Player player){
        super(new ArrayList<String>(),new ArrayList<String>(),new double[3], player);
        totalZombies = 28;
        this.availablePlants = new ArrayList<String>();
        this.availablePlants.add("peaShooter");
        this.availablePlants.add("sunFlower");
        this.availablePlants.add("wallnut");
        this.avalableZombies = new ArrayList<String>();
        this.avalableZombies.add("normal_zombie");

    }
    @Override
    public  void getlevel() throws IOException, InterruptedException {
        super.getlevel();

        start = System.currentTimeMillis();
        levelwindow = new Stage();
        levelwindow.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("Level2.fxml"));
        scene1 = new Scene(login, 1028,702);
        GridPane p = (GridPane)scene1.lookup("#lawngrid");
        Pane sp00 = (Pane)scene1.lookup("#sp00");
        Pane sp01 = (Pane)scene1.lookup("#sp01");
        Pane sp02 = (Pane)scene1.lookup("#sp02");
        Pane sp03 = (Pane)scene1.lookup("#sp03");
        Pane sp04 = (Pane)scene1.lookup("#sp04");
        Pane sp10 = (Pane)scene1.lookup("#sp10");
        Pane sp11 = (Pane)scene1.lookup("#sp11");
        Pane sp12 = (Pane)scene1.lookup("#sp12");
        Pane sp13 = (Pane)scene1.lookup("#sp13");
        Pane sp14 = (Pane)scene1.lookup("#sp14");
        Pane sp20 = (Pane)scene1.lookup("#sp20");
        Pane sp21 = (Pane)scene1.lookup("#sp21");
        Pane sp22 = (Pane)scene1.lookup("#sp22");
        Pane sp23 = (Pane)scene1.lookup("#sp23");
        Pane sp24 = (Pane)scene1.lookup("#sp24");
        Pane sp30 = (Pane)scene1.lookup("#sp30");
        Pane sp31 = (Pane)scene1.lookup("#sp31");
        Pane sp32 = (Pane)scene1.lookup("#sp32");
        Pane sp33 = (Pane)scene1.lookup("#sp33");
        Pane sp34 = (Pane)scene1.lookup("#sp34");
        Pane sp40 = (Pane)scene1.lookup("#sp40");
        Pane sp41 = (Pane)scene1.lookup("#sp41");
        Pane sp42 = (Pane)scene1.lookup("#sp42");
        Pane sp43 = (Pane)scene1.lookup("#sp43");
        Pane sp44 = (Pane)scene1.lookup("#sp44");
        Pane sp50 = (Pane)scene1.lookup("#sp50");
        Pane sp51 = (Pane)scene1.lookup("#sp51");
        Pane sp52 = (Pane)scene1.lookup("#sp52");
        Pane sp53 = (Pane)scene1.lookup("#sp53");
        Pane sp54 = (Pane)scene1.lookup("#sp54");
        Pane sp60 = (Pane)scene1.lookup("#sp60");
        Pane sp61 = (Pane)scene1.lookup("#sp61");
        Pane sp62 = (Pane)scene1.lookup("#sp62");
        Pane sp63 = (Pane)scene1.lookup("#sp63");
        Pane sp64 = (Pane)scene1.lookup("#sp64");
        Pane sp70 = (Pane)scene1.lookup("#sp70");
        Pane sp71 = (Pane)scene1.lookup("#sp71");
        Pane sp72 = (Pane)scene1.lookup("#sp72");
        Pane sp73 = (Pane)scene1.lookup("#sp73");
        Pane sp74 = (Pane)scene1.lookup("#sp74");
        Pane sp80 = (Pane)scene1.lookup("#sp80");
        Pane sp81 = (Pane)scene1.lookup("#sp81");
        Pane sp82 = (Pane)scene1.lookup("#sp82");
        Pane sp83 = (Pane)scene1.lookup("#sp83");
        Pane sp84 = (Pane)scene1.lookup("#sp84");
        Pane[][] panes = new Pane[][]{{sp00,sp01,sp02,sp03,sp04},{sp10,sp11,sp12,sp13,sp14},{sp20,sp21,sp22,sp23,sp24},{sp30,sp31,sp32,sp33,sp34},{sp40,sp41,sp42,sp43,sp44},{sp50,sp51,sp52,sp53,sp54},{sp60,sp61,sp62,sp63,sp64},{sp70,sp71,sp72,sp73,sp74},{sp80,sp81,sp82,sp83,sp84}};
        this.setPanes(panes);
        GameScreen gameScreen = new GameScreen();
        super.gameScreen = gameScreen;
        gameScreen.setLevel(this);
        Lawnmower m1 = new Lawnmower(0,(ImageView) scene1.lookup("#lMower1"),gameScreen);
        Lawnmower m2 = new Lawnmower(1,(ImageView) scene1.lookup("#lMower2"),gameScreen);
        Lawnmower m3 = new Lawnmower(2,(ImageView) scene1.lookup("#lMower3"),gameScreen);
        Lawnmower m4 = new Lawnmower(3,(ImageView) scene1.lookup("#lMower4"),gameScreen);
        Lawnmower m5 = new Lawnmower(4,(ImageView) scene1.lookup("#lMower5"),gameScreen);
        Lawnmower[] lawnmowers = new Lawnmower[]{m1,m2,m3,m4,m5};
        gameScreen.setLawnmowers(lawnmowers);
        gameScreen.setLawngrid(p);
        Controller.setGameScreen(gameScreen);
        levelwindow.setScene(scene1);
        levelwindow.setTitle("LEVEL 2");
        levelwindow.setResizable(false);
        levelwindow.show();
        double duration = 5*1000;
        Label progressText = (Label)scene1.lookup("#progessText");
        Timeline tml = new Timeline();
        gameScreen.setTimeline(tml);
        gameScreen.setLevel(this);
        gameScreen.start();
        tml.play();
        gameScreen.getBuyPlantTimeline().play();
        gameScreen.getSoundTimeline().play();


    }

}
class Level4 extends Level{
    @FXML
    private Label progressText;

    public ArrayList<NormalZombie> lane = new ArrayList<>();
    double start ;
    public static TranslateTransition tt;
    public Level4(Player player){
        super(new ArrayList<String>(),new ArrayList<String>(),new double[3], player);
        totalZombies = 28;
        this.availablePlants = new ArrayList<String>();
        this.availablePlants.add("peaShooter");
        this.availablePlants.add("sunFlower");
        this.availablePlants.add("wallnut");
        this.availablePlants.add("cherrybomb");
        this.avalableZombies = new ArrayList<String>();
        this.avalableZombies.add("normal_zombie");
        this.avalableZombies.add("football_zombie");

    }
    @Override
    public  void getlevel() throws IOException, InterruptedException {
        super.getlevel();

        start = System.currentTimeMillis();
        levelwindow = new Stage();
        levelwindow.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(LoginBox.class.getResource("Level4.fxml"));
        scene1 = new Scene(login, 1028,702);
        GridPane p = (GridPane)scene1.lookup("#lawngrid");
        Pane sp00 = (Pane)scene1.lookup("#sp00");
        Pane sp01 = (Pane)scene1.lookup("#sp01");
        Pane sp02 = (Pane)scene1.lookup("#sp02");
        Pane sp03 = (Pane)scene1.lookup("#sp03");
        Pane sp04 = (Pane)scene1.lookup("#sp04");
        Pane sp10 = (Pane)scene1.lookup("#sp10");
        Pane sp11 = (Pane)scene1.lookup("#sp11");
        Pane sp12 = (Pane)scene1.lookup("#sp12");
        Pane sp13 = (Pane)scene1.lookup("#sp13");
        Pane sp14 = (Pane)scene1.lookup("#sp14");
        Pane sp20 = (Pane)scene1.lookup("#sp20");
        Pane sp21 = (Pane)scene1.lookup("#sp21");
        Pane sp22 = (Pane)scene1.lookup("#sp22");
        Pane sp23 = (Pane)scene1.lookup("#sp23");
        Pane sp24 = (Pane)scene1.lookup("#sp24");
        Pane sp30 = (Pane)scene1.lookup("#sp30");
        Pane sp31 = (Pane)scene1.lookup("#sp31");
        Pane sp32 = (Pane)scene1.lookup("#sp32");
        Pane sp33 = (Pane)scene1.lookup("#sp33");
        Pane sp34 = (Pane)scene1.lookup("#sp34");
        Pane sp40 = (Pane)scene1.lookup("#sp40");
        Pane sp41 = (Pane)scene1.lookup("#sp41");
        Pane sp42 = (Pane)scene1.lookup("#sp42");
        Pane sp43 = (Pane)scene1.lookup("#sp43");
        Pane sp44 = (Pane)scene1.lookup("#sp44");
        Pane sp50 = (Pane)scene1.lookup("#sp50");
        Pane sp51 = (Pane)scene1.lookup("#sp51");
        Pane sp52 = (Pane)scene1.lookup("#sp52");
        Pane sp53 = (Pane)scene1.lookup("#sp53");
        Pane sp54 = (Pane)scene1.lookup("#sp54");
        Pane sp60 = (Pane)scene1.lookup("#sp60");
        Pane sp61 = (Pane)scene1.lookup("#sp61");
        Pane sp62 = (Pane)scene1.lookup("#sp62");
        Pane sp63 = (Pane)scene1.lookup("#sp63");
        Pane sp64 = (Pane)scene1.lookup("#sp64");
        Pane sp70 = (Pane)scene1.lookup("#sp70");
        Pane sp71 = (Pane)scene1.lookup("#sp71");
        Pane sp72 = (Pane)scene1.lookup("#sp72");
        Pane sp73 = (Pane)scene1.lookup("#sp73");
        Pane sp74 = (Pane)scene1.lookup("#sp74");
        Pane sp80 = (Pane)scene1.lookup("#sp80");
        Pane sp81 = (Pane)scene1.lookup("#sp81");
        Pane sp82 = (Pane)scene1.lookup("#sp82");
        Pane sp83 = (Pane)scene1.lookup("#sp83");
        Pane sp84 = (Pane)scene1.lookup("#sp84");
        Pane[][] panes = new Pane[][]{{sp00,sp01,sp02,sp03,sp04},{sp10,sp11,sp12,sp13,sp14},{sp20,sp21,sp22,sp23,sp24},{sp30,sp31,sp32,sp33,sp34},{sp40,sp41,sp42,sp43,sp44},{sp50,sp51,sp52,sp53,sp54},{sp60,sp61,sp62,sp63,sp64},{sp70,sp71,sp72,sp73,sp74},{sp80,sp81,sp82,sp83,sp84}};
        this.setPanes(panes);
        GameScreen gameScreen = new GameScreen();
        super.gameScreen = gameScreen;
        gameScreen.setLevel(this);
        Lawnmower m1 = new Lawnmower(0,(ImageView) scene1.lookup("#lMower1"),gameScreen);
        Lawnmower m2 = new Lawnmower(1,(ImageView) scene1.lookup("#lMower2"),gameScreen);
        Lawnmower m3 = new Lawnmower(2,(ImageView) scene1.lookup("#lMower3"),gameScreen);
        Lawnmower m4 = new Lawnmower(3,(ImageView) scene1.lookup("#lMower4"),gameScreen);
        Lawnmower m5 = new Lawnmower(4,(ImageView) scene1.lookup("#lMower5"),gameScreen);
        Lawnmower[] lawnmowers = new Lawnmower[]{m1,m2,m3,m4,m5};
        gameScreen.setLawnmowers(lawnmowers);
        gameScreen.setLawngrid(p);
        Controller.setGameScreen(gameScreen);
        levelwindow.setScene(scene1);
        levelwindow.setTitle("LEVEL 4");
        levelwindow.setResizable(false);
        levelwindow.show();
        double duration = 5*1000;
        Label progressText = (Label)scene1.lookup("#progessText");
        Timeline tml = new Timeline();
        gameScreen.setTimeline(tml);
        gameScreen.setLevel(this);
        gameScreen.start();
        tml.play();
        gameScreen.getBuyPlantTimeline().play();
        gameScreen.getSoundTimeline().play();
    }

}