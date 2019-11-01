package sample;

import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.sql.Time;

public class Zombie  extends Character{
    protected int lane;
    protected int position;
    protected int speed;
    protected int attack;
    protected double timeInstantiated;
    protected ImageView zombieImage;
    protected TranslateTransition tt;
    public Zombie(int defense, int attack, int lane, int position, int speed){
        super(defense);
        this.attack = attack;
        this.lane   = lane;
        this.position = position;
        this.speed = speed;
        this.timeInstantiated = System.currentTimeMillis();

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
    public void move(Timeline tml, int i){

    }
    public boolean gameOver(){
        return position == 0;
    }
    public void decreaseSpeedTemp(){

    }
}

class NormalZombie extends Zombie{
    public NormalZombie(int lane){
        super(0,25,lane,0,10);
        Image z = new Image(Zombie.class.getResource("resources/spritesNStuff/zombie_normal.gif").toString());
        zombieImage = new ImageView(z);
        tt = new TranslateTransition();
        tt.setNode(zombieImage);
    }
    @Override
    public void move(Timeline tml,int i){
//        tt.setDuration(Duration.millis(1000));
//        System.out.println("Start: "+ position);
////        tt.setFromX(position);
//        tt.setByX(-speed);
////        position-=speed;
////        System.out.println(position);
////        System.out.println(this);
////        System.out.println(position);
////        tt.setCycleCount(Animation.INDEFINITE);
//        tt.play();
//        tt.setOnFinished(e->{
//            tt.playFromStart();
//            zombieImage.setX(zombieImage.getX()-speed);
//            System.out.println("end: "+ zombieImage.getX());
////            tt.setNode(zombieImage);
//        });
        KeyFrame movezombie = new KeyFrame(Duration.millis(40000 - 10000*i%30000),
                new KeyValue(zombieImage.translateXProperty(), -700));
        tml.getKeyFrames().add(movezombie);

    }
}