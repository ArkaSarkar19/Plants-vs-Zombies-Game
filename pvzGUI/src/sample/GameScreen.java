package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

public class GameScreen implements Serializable {
    private Plant[][] garden;
    private int columnWiidths;
    private int sunTokens;
    private double startTime;
    private double timeElapsed;
    private double endTime;
    private int screenHeight;
    private int screenWidth;
    private int sunTimer;
    private Lawnmower[] lawnmowers;
    private Shovel shovel;
    private ArrayList<Zombie> laneZombie_1;
    private ArrayList<Zombie> laneZombie_2;
    private ArrayList<Zombie> laneZombie_3;
    private ArrayList<Zombie> laneZombie_4;
    private ArrayList<Zombie> laneZombie_5;
    private TreeSet<Pea> lanePea_1;
    private TreeSet<Pea> lanePea_2;
    private TreeSet<Pea> lanePea_3;
    private TreeSet<Pea> lanePea_4;
    private TreeSet<Pea> lanePea_5;
    private Level level;

    private Pane[][] panes;
    public   GridPane lawngrid;
    public  Timeline timeline;
    public GameScreen(){
//        this.level = level;
        this.garden = new Plant[9][5];
        this.startTime = System.currentTimeMillis();
        this.sunTimer = 10000;
        this.sunTokens = 0;
        this.laneZombie_1 = new ArrayList<>();
        this.laneZombie_2 = new ArrayList<>();
        this.laneZombie_3 = new ArrayList<>();
        this.laneZombie_4 = new ArrayList<>();
        this.laneZombie_5 = new ArrayList<>();
//        this.panes = Level.panes;

    }

    public void setLevel(Level level) {
        this.level = level;
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

    public double getEndTime() {
        return endTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getTimeElapsed() {
        return timeElapsed;
    }

    public int getColumnWiidths() {
        return columnWiidths;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public Lawnmower[] getLawnmowers() {
        return lawnmowers;
    }

    public Shovel getShovel() {
        return shovel;
    }

    public TreeSet<Pea> getLanePea_1() {
        return lanePea_1;
    }

    public TreeSet<Pea> getLanePea_2() {
        return lanePea_2;
    }

    public TreeSet<Pea> getLanePea_3() {
        return lanePea_3;
    }

    public TreeSet<Pea> getLanePea_4() {
        return lanePea_4;
    }

    public TreeSet<Pea> getLanePea_5() {
        return lanePea_5;
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
        KeyFrame k = new KeyFrame(new Duration(2500), event -> {
             Zombie z = this.produceZombies();

        });
        timeline.getKeyFrames().add(k);
        return null;
    }
    public void removeZombie(Zombie zombie){

    }

    public void produceSuns(){
        Random r = new Random();
        int a = r.nextInt(9);


    }
    public Zombie produceZombies(){
        Random r = new Random();
        int b = r.nextInt(3);
        NormalZombie z = null;

        if(b==2){
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
            lawngrid.add(z.getZombieImage(),9,a);
            z.move();
        }
        return z;
    }
    public void moveZombiePeas(){

    }
    public void addPlant(int[] position, Plant plant){
        int[] pos  = plant.getPosition();
        garden[position[0]][position[1]] = plant;
        KeyFrame k = new KeyFrame(new Duration(2500), event -> {
            plant.useAbility();
        });
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
        this.timeline = timeline;
        timeline.setCycleCount(Timeline.INDEFINITE);

    }

}
