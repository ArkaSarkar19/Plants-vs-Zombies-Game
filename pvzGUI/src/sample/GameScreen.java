package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.Random;
import java.util.TreeSet;

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
    private TreeSet<Zombie> laneZombie_1;
    private TreeSet<Zombie> laneZombie_2;
    private TreeSet<Zombie> laneZombie_3;
    private TreeSet<Zombie> laneZombie_4;
    private TreeSet<Zombie> laneZombie_5;
    private TreeSet<Pea> lanePea_1;
    private TreeSet<Pea> lanePea_2;
    private TreeSet<Pea> lanePea_3;
    private TreeSet<Pea> lanePea_4;
    private TreeSet<Pea> lanePea_5;
    public  static GridPane lawngrid;
    public static Timeline timeline;
    public GameScreen(){
        this.garden = new Plant[9][5];
        this.startTime = System.currentTimeMillis();
        this.sunTimer = 10000;
        this.sunTokens = 0;
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

    public TreeSet<Zombie> getLaneZombie_1() {
        return laneZombie_1;
    }

    public TreeSet<Zombie> getLaneZombie_2() {
        return laneZombie_2;
    }

    public TreeSet<Zombie> getLaneZombie_3() {
        return laneZombie_3;
    }

    public TreeSet<Zombie> getLaneZombie_4() {
        return laneZombie_4;
    }

    public TreeSet<Zombie> getLaneZombie_5() {
        return laneZombie_5;
    }

    public Plant[][] getGarden() {
        return garden;
    }
    public Zombie spawnZombie(){
        KeyFrame k = new KeyFrame(new Duration(2500), event -> {
            this.produceZombies();
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
    public void produceZombies(){
        Random r = new Random();
        int b = r.nextInt(3);
        if(b==2){
        int a = r.nextInt(5);
        System.out.println(a);
        NormalZombie z = new NormalZombie(a);
        lawngrid.add(z.getZombieImage(),9,a);
        z.move();}
    }
    public void moveZombiePeas(){

    }
    public void addPlant(int[] position, Plant plant){
        //lawngrid.add(plant.getPlantImage(),position[0],position[1]);
        Random r = new Random();
        int a = r.nextInt(10);
        KeyFrame k = new KeyFrame(new Duration(2500 - 60*a), event -> {
            plant.useAbility();
        });
        timeline.getKeyFrames().add(k);
    }
    public void removePlant(int[][] position){

    }
    public void collectSunTokens(){

    }
    public void addPea(int lane, Pea pea){

    }

    public void setLawngrid(GridPane lawngrid) {
        this.lawngrid = lawngrid;
    }

    public  void setTimeline(Timeline timeline) {
        GameScreen.timeline = timeline;
        timeline.setCycleCount(Timeline.INDEFINITE);

    }
}
