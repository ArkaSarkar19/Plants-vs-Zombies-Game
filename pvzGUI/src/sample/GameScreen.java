package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class GameScreen implements Serializable {
    private Plant[][] garden;
    private int sunTokens;
    private double startTime;
    private int sunTimer;
    private Lawnmower[] lawnmowers;
    private Shovel shovel;
    private ArrayList<Zombie> laneZombie_1;
    private ArrayList<Zombie> laneZombie_2;
    private ArrayList<Zombie> laneZombie_3;
    private ArrayList<Zombie> laneZombie_4;
    private ArrayList<Zombie> laneZombie_5;
    private Level level;
    private Pane[][] panes;
    private Controller controller;
    private MediaPlayer backgroundsound;
    private Boolean peaShooterAvailable;
    private Boolean sunFlowerAvailable;
    private Boolean wallNutAvailable;
    private Boolean potatoMineAvailable;
    private Boolean cherryBombAvailable;
    private Image inactivePeaShooterGif;
    private Image activePeaShooterGif;
    private Image inactiveSunFlowerGif;
    private Image activeSunFlowerGif;
    private Stage nextLevelWindow;
    private Image inactiveWallnutGif;
    private Image activeWallnutGif;
    private Image activeCherryBombGif;
    private Image inactiveCherryBombGif;


    public  GridPane lawngrid;
    public  Timeline zombieTimeline;
    public  Timeline sunTimeline;
    public  Timeline buyPlantTimeline;
    public Timeline soundTimeline;
    private boolean hugeWaveCame;
    private ImageView aHugeWaveOfZombies;
    private MediaPlayer aHugeWaveSound;

    public GameScreen(){
        this.garden = new Plant[9][5];
        this.startTime = System.currentTimeMillis();
        this.sunTimer = 10000;
        this.sunTokens = 0;
        this.laneZombie_1 = new ArrayList<>();
        this.laneZombie_2 = new ArrayList<>();
        this.laneZombie_3 = new ArrayList<>();
        this.laneZombie_4 = new ArrayList<>();
        this.laneZombie_5 = new ArrayList<>();
        this.sunTimeline = new Timeline();
        this.buyPlantTimeline = new Timeline();
        this.soundTimeline  = new Timeline();
        sunTimeline.setCycleCount(Animation.INDEFINITE);
        buyPlantTimeline.setCycleCount(Animation.INDEFINITE);
        soundTimeline.setCycleCount(Animation.INDEFINITE);
        buyPlantTimeline.play();
        this.inactivePeaShooterGif = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/pea_shooter_GS.gif")));
        this.activePeaShooterGif = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/pea_shooter.gif")));
        this.inactiveSunFlowerGif = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/sun_flower_GS.gif")));
        this.activeSunFlowerGif = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/sun_flower.gif")));
        this.activeWallnutGif= new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/walnut_full_life.gif")));
        this.inactiveWallnutGif = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/walnut_GS.gif")));
        this.activeCherryBombGif= new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/cb.gif")));
        this.inactiveCherryBombGif = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/cb_GS.gif")));
        this.aHugeWaveOfZombies = new ImageView(new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/huge_wave_of_zombies_text.png"))));
        this.hugeWaveCame = false;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setLawnmowers(Lawnmower[] lawnmowers) {
        this.lawnmowers = lawnmowers;
    }

    public  GridPane getLawngrid() {
            return lawngrid;
    }

    public int getSunTokens() {
        return sunTokens;
    }

    public int getSunTimer() {
        return sunTimer;
    }

    public double getStartTime() {
        return startTime;
    }

    public Lawnmower[] getLawnmowers() {
        return lawnmowers;
    }

    public Shovel getShovel() {
        return shovel;
    }

    public ArrayList<Zombie> getLaneZombie_1() {
        return laneZombie_1;
    }

    public ArrayList<Zombie> getLaneZombie_2() {
        return laneZombie_2;
    }

    public ArrayList<Zombie> getLaneZombie_3() {
        return laneZombie_3;
    }

    public ArrayList<Zombie> getLaneZombie_4() {
        return laneZombie_4;
    }

    public ArrayList<Zombie> getLaneZombie_5() {
        return laneZombie_5;
    }

    public Plant[][] getGarden() {
        return garden;
    }
    public Zombie spawnZombie(){
        Timeline t = null;
        double duration = 0;

        KeyFrame k = new KeyFrame(new Duration(6000), event -> {
             Zombie z = this.produceZombies();

        });
        zombieTimeline.getKeyFrames().add(k);
        return null;
    }
    public void removeZombie(Zombie zombie){

    }

    public void produceSuns(){

        KeyFrame k = new KeyFrame(new Duration(10000),event -> {
            Sun s = new Sun(this);

            s.move();
        });
        sunTimeline.getKeyFrames().add(k);
        sunTimeline.play();

    }
    public Zombie produceZombies(){
        if(level.progress<100) {
            int bound = 0;
            if(level.getProgress()<=25) bound = 4;
            else if(level.getProgress() > 25 && level.getProgress() <= 75) bound = 3;
            else if(level.getProgress() >= 75 && level.getProgress() < 85) bound = 2;
            else{

                return null;
            }
            Random r = new Random();
            int b = r.nextInt(bound);
            NormalZombie z = null;

            if (b <= 2) {
                int a = r.nextInt(5);
                if (a == 0) {
                    z = new NormalZombie(a, this);
                    laneZombie_1.add(z);
//                break;
                } else if (a == 1) {
                    z = new NormalZombie(a, this);
                    laneZombie_2.add(z);
//                break;
                } else if (a == 2) {
                    z = new NormalZombie(a, this);
                    laneZombie_3.add(z);
//                break;
                } else if (a == 3) {
                    z = new NormalZombie(a, this);
                    laneZombie_4.add(z);
//                break;
                } else {
                    z = new NormalZombie(a, this);
                    laneZombie_5.add(z);
//                break;
                }
                lawngrid.add(z.getZombieImage(), 9, a + 1);
                z.move();
                int prev = level.getCurrentZombies() + 1;
                level.setCurrentZombies(prev);


            }
            return z;
        }
        return null;
    }
    public void moveZombiePeas(){

    }
    public void addPlant(int[] position, Plant plant){
        int[] pos  = plant.getPosition();
        garden[position[0]][position[1]] = plant;
        KeyFrame k = null;

        if(plant instanceof PeaShooter){
            k = new KeyFrame(new Duration(3500), event -> {
                plant.useAbility();
            });
            Timeline t = new Timeline();
            t.setCycleCount(700);
            KeyFrame k1 = new KeyFrame(new Duration(10),event -> {
                inactivePeaShooter();
            });
            t.getKeyFrames().add(k1);
            t.play();
        }
        else if(plant instanceof Sunflower){
            k = new KeyFrame(new Duration(12000), event -> {
                plant.useAbility();
            });
            Timeline t = new Timeline();
            t.setCycleCount(500);
            KeyFrame k1 = new KeyFrame(new Duration(10),event -> {
                inactiveSunFlower();
            });
            t.getKeyFrames().add(k1);
            t.play();
        }
        else if(plant instanceof WallNut){
            Timeline t = new Timeline();
            t.setCycleCount(1500);
            KeyFrame k1 = new KeyFrame(new Duration(10),event -> {
                inactiveWalnut();
            });
            t.getKeyFrames().add(k1);
            t.play();
        }
        if (!(plant instanceof WallNut)) {
            plant.getTimeline().getKeyFrames().add(k);
            plant.getTimeline().play();
        }
    }
    public void removePlant(int j, int lane){
        Pane p = level.panes[j][lane];

        p.getChildren().remove(garden[j][lane].getPlantImage());
        garden[j][lane].getTimeline().stop();
        garden[j][lane].setTimelineNull();
        garden[j][lane] = null;
        System.gc();

    }
    public void collectSunTokens(){

    }
    public void addPea(int lane, Pea pea){

    }

    public boolean eatPlant(int j, int lane, int attk){
        if(garden[j][lane].eatPlant(attk)){
            removePlant(j,lane);
            return true;
        }
        return false;

    }

    public void setLawngrid(GridPane lawngrid) {
        this.lawngrid = lawngrid;
    }

    public  void setTimeline(Timeline timeline) {
        this.zombieTimeline = timeline;
        timeline.setCycleCount(Timeline.INDEFINITE);

    }
    public void start(){
        Label progressText = (Label)level.getScene().lookup("#progessText");
        KeyFrame k1 = new KeyFrame(new Duration(10),event -> {
            System.out.println(level.getTotalZombies());
            System.out.println(level.getCurrentZombies());
            level.setProgress(level.getCurrentZombies()*100 /level.getTotalZombies());
            progressText.setText(String.valueOf((Math.round(level.getProgress()) + "%")));

            if(!hugeWaveCame && level.getProgress() >= 85 ){
                System.out.println("A HUGE WAVE OF ZOMBIES ARE COMING");
                AnchorPane a = (AnchorPane) level.getScene().lookup("#mainAnchorPane");
                a.getChildren().add(aHugeWaveOfZombies);
                aHugeWaveOfZombies.setY(250);
                aHugeWaveOfZombies.setX(150);
                FadeTransition ft = new FadeTransition();
                ft.setNode(aHugeWaveOfZombies);
                System.out.println(aHugeWaveOfZombies);
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.setCycleCount(10);
                ft.setAutoReverse(true);
                ft.playFromStart();

                ft.setOnFinished(event1 -> {
                    aHugeWaveOfZombies.setVisible(false);
                });
//                aHugeWaveSound = new MediaPlayer(new Media(Paths.get("/home/arkasarkar/Desktop/APPROJECT/Plants-vs-Zombies/pvzGUI/src/sample/resources/sounds/zombies_coming.wav").toUri().toString()));

                aHugeWaveSound = new MediaPlayer(new Media(Paths.get("/home/arkasarkar/Desktop/APPROJECT/Plants-vs-Zombies/pvzGUI/src/sample/resources/sounds/zombies_coming.wav").toUri().toString()));

                aHugeWaveSound.play();
                if(!hugeWaveCame) getHugeWave();

                aHugeWaveOfZombies.setVisible(true);
                hugeWaveCame = true;
            }
            if(level.getTotalZombies()==level.getZombiesKilled()){
                level.levelCompleted = true;
                this.stop();
                nextLevelWindow = new Stage();
                nextLevelWindow.initModality(Modality.APPLICATION_MODAL);
                Parent login = null;
                try {
                    login = FXMLLoader.load(LoginBox.class.getResource("NextLevelWindow.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene1 = new Scene(login, 720,405);
                nextLevelWindow.setScene(scene1);
                nextLevelWindow.setTitle("LEVEL COMPLETED");
                nextLevelWindow.setResizable(false);
                nextLevelWindow.show();
                Button nextLevel = (Button) scene1.lookup("#nextLevelButton");
                Button mainMenu = (Button) scene1.lookup("#mainMenuButton");
                nextLevel.setOnAction(event1 -> {
                    Player p = level.getPlayer();
                    level.levelwindow.close();
                  //  Controller c = level.getController();
                    level = null;
                    Level l = new Level2(p);

                    try {
                        //l.setController(c);

                        l.getlevel();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                });
            }

        });
        zombieTimeline.getKeyFrames().add(k1);

        KeyFrame k2 = new KeyFrame(new Duration(100),event -> {

            ArrayList<String> a = level.getAvailablePlants();
            for(int i=0;i<a.size();i++){
                if(a.get(i).equals("peaShooter") && sunTokens - 100 <0){
                    inactivePeaShooter();
                }
               else if(a.get(i).equals("peaShooter") && sunTokens - 100 >=0){
                    activePeaShooter();
                }
                 else if(a.get(i).equals("sunFlower") && sunTokens - 50 <0){
                    inactiveSunFlower();
                }
                 else if(a.get(i).equals("sunFlower") && sunTokens - 50 >=0){
                    activeSunFLower();
                }
                 else if (a.get(i).equals("wallnut") && sunTokens-50>=0){
                     activeWalnut();
                }
                 else if (a.get(i).equals("wallnut") && sunTokens-50<0){
                     inactiveWalnut();
                }

            }
        });

        buyPlantTimeline.getKeyFrames().add(k2);
        backgroundsound = new MediaPlayer(new Media(Paths.get("/home/arkasarkar/Desktop/APPROJECT/Plants-vs-Zombies/pvzGUI/src/sample/resources/sounds/background.wav").toUri().toString()));
        backgroundsound.setAutoPlay(true);
        backgroundsound.setCycleCount(Animation.INDEFINITE);
        backgroundsound.play();

        //soundTimeline.getKeyFrames().add(k3);
        this.produceSuns();
        this.spawnZombie();
        this.sunTokens = 50;
    }

    public Level getLevel() {
        return level;
    }

    public void setSunTokens(int sunTokens) {
        this.sunTokens = sunTokens;
        Button s = (Button) getLevel().scene1.lookup("#sunTokenButton");
        s.setText(String.valueOf(getSunTokens()));

    }
    public void moveLawnmover(int lane){
        getLawnmowers()[lane].move();

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void inactivePeaShooter(){
        try {
            ImageView i = (ImageView) level.scene1.lookup("#peashooterImage");
            if (i != null) i.setImage(this.inactivePeaShooterGif);
            this.peaShooterAvailable = false;
        }
        catch (NullPointerException e){
            ;
        }
    }
    public void activePeaShooter() {
        try{
            ImageView i = (ImageView) level.scene1.lookup("#peashooterImage");
            if (i != null) i.setImage(this.activePeaShooterGif);
            this.peaShooterAvailable = true;
        }
        catch (NullPointerException e){
            ;
        }
    }
    public void inactiveSunFlower(){
        try {
            ImageView i = (ImageView) level.scene1.lookup("#sunflowerImage");
            i.setImage(this.inactiveSunFlowerGif);
            this.sunFlowerAvailable = false;
        }
        catch (NullPointerException e){
            ;
        }
    }
    public void activeSunFLower(){
        try {
            ImageView i = (ImageView) level.scene1.lookup("#sunflowerImage");
            if (i != null) i.setImage(this.activeSunFlowerGif);
            this.sunFlowerAvailable = true;
        }
        catch (NullPointerException e){
            ;
        }
    }
    public void inactiveWalnut(){
        try {
            ImageView i = (ImageView) level.scene1.lookup("#wallnutImage");
            i.setImage(this.inactiveWallnutGif);
            this.wallNutAvailable = false;
        }
        catch (NullPointerException e){
            ;
        }
    }

    public void activeWalnut(){
        try {
            ImageView i = (ImageView) level.scene1.lookup("#wallnutImage");
            i.setImage(this.activeWallnutGif);
            this.wallNutAvailable = true;
        }
        catch (NullPointerException e){
            ;
        }

    }


    public Timeline getBuyPlantTimeline() {
        return buyPlantTimeline;
    }

    public Timeline getSoundTimeline() {
        return soundTimeline;
    }

    public Boolean getCherryBombAvailable() {
        return cherryBombAvailable;
    }

    public Boolean getPeaShooterAvailable() {
        return peaShooterAvailable;
    }

    public Boolean getPotatoMineAvailable() {
        return potatoMineAvailable;
    }

    public Boolean getSunFlowerAvailable() {
        return sunFlowerAvailable;
    }

    public Boolean getWallNutAvailable() {
        return wallNutAvailable;
    }
    public  void stop(){
        zombieTimeline.stop();
        backgroundsound.stop();
        buyPlantTimeline.stop();
        sunTimeline.stop();
        for(int i=0;i<laneZombie_1.size();i++){
            laneZombie_1.get(i).removeZombie(i);
        }
        for(int i=0;i<laneZombie_2.size();i++){
            laneZombie_2.get(i).removeZombie(i);
        }
        for(int i=0;i<laneZombie_3.size();i++){
            laneZombie_3.get(i).removeZombie(i);
        }
        for(int i=0;i<laneZombie_4.size();i++){
            laneZombie_4.get(i).removeZombie(i);
        }
        for(int i=0;i<laneZombie_5.size();i++){
            laneZombie_5.get(i).removeZombie(i);
        }
        for(int i = 0;i<9;i++){
            for(int j=0;j<5;j++){
                if(garden[i][j]!=null){
                    this.removePlant(i,j);
                }
            }
        }
        garden = null;
        System.gc();

    }
    private void getHugeWave(){
        int r_zombies  = level.getTotalZombies() - level.getCurrentZombies();
        KeyFrame k = new KeyFrame(new Duration(1000), event -> {

            {
                if (level.getCurrentZombies() <= level.getTotalZombies()) {
                    NormalZombie z1 = new NormalZombie(0, this);
                    laneZombie_1.add(z1);
                    NormalZombie z2 = new NormalZombie(1, this);
                    laneZombie_2.add(z2);
                    NormalZombie z3 = new NormalZombie(2, this);
                    laneZombie_3.add(z3);
                    NormalZombie z4 = new NormalZombie(3, this);
                    laneZombie_4.add(z4);
                    NormalZombie z5 = new NormalZombie(4, this);
                    laneZombie_5.add(z5);
                    lawngrid.add(z1.getZombieImage(), 9, 0 + 1);
                    z1.move();
                    lawngrid.add(z2.getZombieImage(), 9, 1 + 1);
                    z2.move();
                    lawngrid.add(z3.getZombieImage(), 9, 2 + 1);
                    z3.move();
                    lawngrid.add(z4.getZombieImage(), 9, 3 + 1);
                    z4.move();
                    lawngrid.add(z5.getZombieImage(), 9, 4 + 1);
                    z5.move();

                    int prev = level.getCurrentZombies() + 5;
                    level.setCurrentZombies(prev);
                }
            }




        });
        zombieTimeline.getKeyFrames().add(k);

    }
}
