package sample;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

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
    public void move(){

    }
    public boolean gameOver(){
        return position == 0;
    }
    public void decreaseSpeedTemp(){

    }
}

class NormalZombie extends Zombie{
    public NormalZombie(int lane){
        super(0,25,lane,0,50);
        Image z = new Image(Zombie.class.getResource("resources/spritesNStuff/zombie_normal.gif").toString());
        zombieImage = new ImageView(z);
        tt = new TranslateTransition();
        tt.setNode(zombieImage);
    }
    @Override
    public void move(){
        tt.setDuration(Duration.millis(500));
        System.out.println("Start: "+ position);
//        tt.setFromX(position);
        tt.setByX(-speed);
//        position-=speed;
//        System.out.println(position);
//        System.out.println(this);
//        System.out.println(position);
//        tt.setCycleCount(Animation.INDEFINITE);
        tt.play();
        tt.setOnFinished(e->{
//            tt.playFromStart();
            zombieImage.setX(zombieImage.getX()-50);
            System.out.println("end: "+ position);
//            tt.setNode(zombieImage);
        });
    }
}