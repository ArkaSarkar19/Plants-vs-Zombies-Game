package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
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

    public  GridPane lawngrid;
    public  Timeline zombieTimeline;
    public  Timeline sunTimeline;
    public  Timeline buyPlantTimeline;
    public Timeline soundTimeline;
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
        if(level.getProgress()<25){
            duration = 6000;
        }
        else if(level.getProgress() > 26 && level.getProgress() < 65){
            duration = 4500;
        }
        else{
            duration = 1800;
        }
        KeyFrame k = new KeyFrame(new Duration(duration), event -> {
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
        Random r = new Random();
        int b = r.nextInt(3);
        NormalZombie z = null;

        if(b<=2){
            int a = r.nextInt(5);
            if(a ==0) {
                z = new NormalZombie(a, this);
                laneZombie_1.add(z);
//                break;
            }
            else if (a==1){
                z = new NormalZombie(a,this);
                laneZombie_2.add(z);
//                break;
            }
            else if (a==2) {
                z = new NormalZombie(a, this);
                laneZombie_3.add(z);
//                break;
            }
            else if (a==3) {
                z = new NormalZombie(a, this);
                laneZombie_4.add(z);
//                break;
            }
            else{
                z = new NormalZombie(a,this);
                laneZombie_5.add(z);
//                break;
            }
            lawngrid.add(z.getZombieImage(),9,a+1);
            z.move();
            int prev = level.getCurrentZombies()+1;
            level.setCurrentZombies(prev);
            System.out.println(prev);

        }
        return z;
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
            t.setCycleCount(700);
            KeyFrame k1 = new KeyFrame(new Duration(10),event -> {
                inactiveSunFlower();
            });
            t.getKeyFrames().add(k1);
            t.play();
        }
        plant.getTimeline().getKeyFrames().add(k);
        plant.getTimeline().play();
    }
    public void removePlant(int j, int lane){
        Pane p = level.panes[j][lane];
        p.getChildren().remove(garden[j][lane].getPlantImage());
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
            if(level.getProgress() > 75){
                System.out.println("A HUGE WAVE OF ZOMBIES ARE COMING");
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
        ImageView i = (ImageView) level.scene1.lookup("#peashooterImage");
        i.setImage(this.inactivePeaShooterGif);
        this.peaShooterAvailable = false;
    }
    public void activePeaShooter(){
        ImageView i = (ImageView) level.scene1.lookup("#peashooterImage");
        i.setImage(this.activePeaShooterGif);
        this.peaShooterAvailable = true;
    }
    public void inactiveSunFlower(){
        ImageView i = (ImageView) level.scene1.lookup("#sunflowerImage");
        i.setImage(this.inactiveSunFlowerGif);
        this.sunFlowerAvailable = false;
    }
    public void activeSunFLower(){
        ImageView i = (ImageView) level.scene1.lookup("#sunflowerImage");
        i.setImage(this.activeSunFlowerGif);
        this.sunFlowerAvailable = true;
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
}
