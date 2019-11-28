package sample;

import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.TreeSet;

//import java.sql.Time;

public class Zombie  extends Character implements Comparable<Zombie>{
    protected int lane;
    protected int position;
    protected int speed;
    protected int attack;
    protected double timeInstantiated;
    protected ImageView zombieImage;
    protected TranslateTransition tt;
    protected GameScreen gameScreen;
    protected ArrayList<Zombie> ZombieLane;
    protected Timeline timeline = new Timeline();
    private static int counter;
    protected int id;
    public Zombie(int defense, int attack, int lane, int position, int speed, GameScreen gs){
        super(defense);
        this.gameScreen =gs;
        counter++;
        if (lane ==0){
            ZombieLane = gs.getLaneZombie_1();
        }
        else if (lane ==1){
            ZombieLane = gs.getLaneZombie_2();
        }
        else if (lane ==2){
            ZombieLane = gs.getLaneZombie_3();
        }
        else if (lane ==3){
            ZombieLane = gs.getLaneZombie_4();
        }
        else{
            ZombieLane = gs.getLaneZombie_5();
        }
        id = counter;
        this.attack = attack;
        this.lane   = lane;
        this.position = position;
        this.speed = speed;
        this.timeInstantiated = System.currentTimeMillis();
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    @Override
    public boolean equals(Object obj) {
        Zombie z = (Zombie) obj;
        return (this.id==z.getID());
    }

    public int getID(){
        return id;
    }
    public ImageView getZombieImage() {
        return zombieImage;
    }
    public int getLane() {
        return lane;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPosition() {
        return position;
    }

    public int getAttack() {
        return attack;
    }
    public void attack(Plant plant){

    }
    public void move(){

    }
    public boolean gameOver(){
        return position == 0;
    }
    public void decreaseSpeedTemp(){

    }
    public int compareTo(Zombie other){
        if(this.position>other.getPosition()){
            return 1;
        }
        else{
            return -1;
        }
    }
    protected void removeZombie(){
        for (int i =0;i<ZombieLane.size();i++){
            Zombie z = ZombieLane.get(i);
            if (z.equals(this)){
                gameScreen.getLawngrid().getChildren().remove(this.zombieImage);
                z = null;
                System.gc();
                break;
            }
        }
    }

    public Timeline getTimeline() {
        return timeline;
    }
}

class NormalZombie extends Zombie{
    public NormalZombie(int lane, GameScreen l){
        super(0,25,lane,0,10, l);
        Image z = new Image(Zombie.class.getResource("resources/spritesNStuff/zombie_normal.gif").toString());
        zombieImage = new ImageView(z);
        tt = new TranslateTransition();
        tt.setNode(zombieImage);
    }
    @Override
    public void move(){
        tt.setDuration(Duration.millis(1000));
        getZombieImage().setX(800);
        tt.setByX(-speed);
        tt.play();
//        System.out.println(ZombieLane);
        tt.setOnFinished(e->{
            tt.playFromStart();
            zombieImage.setX(zombieImage.getX()-speed);
            if(zombieImage.getX()<= 0){
                tt.stop();
                removeZombie();

            }
//            System.out.println(this.id+ " " +this + " " + zombieImage.getBoundsInParent());

            for(int j=0;j<9;j++){
                    if(gameScreen.getGarden()[j][lane] !=null){
//                        System.out.println("zombie ki position hai ye: "+ (800-zombieImage.getBoundsInLocal().getMinX())+" |ab plant ki position ye hai "+ gameScreen.getGarden()[j][lane].getPlantImage().getBoundsInLocal().getMaxX());
                        //System.out.println(gameScreen.getGarden()[j][lane].getPlantImage().getX());

                    }

                    if(gameScreen.getGarden()[j][lane] !=null && (zombieImage.getBoundsInLocal().getMinX()+30<=gameScreen.getGarden()[j][lane].getPlantImage().getX() && zombieImage.getBoundsInLocal().getMaxX()>gameScreen.getGarden()[j][lane].getPlantImage().getX())){
                        System.out.println("ooh ooh jaane jaana dhunde tujhe diwana");
                        tt.stop();
                    }
                }

        });

    }
}