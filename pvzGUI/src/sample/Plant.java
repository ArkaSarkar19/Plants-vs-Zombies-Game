package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

//import java.sql.Time;
import java.util.Random;


public abstract class Plant extends Character {
    protected final int[] position;
    protected final int buyTime;
    protected final int cost;
    protected double lastBought;
//    protected int hp;
    protected ImageView plantImage;
    protected TranslateTransition tt;
    protected Timeline timeline = new Timeline();

    public Plant(int buyTime,int cost,int defense, int[] position){
        super(defense);
        this.buyTime = buyTime;
        this.cost = cost;
        this.position  = position;
        this.lastBought = 0;
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    public int getBuyTime() {

        return buyTime;
    }

    public void setTimelineNull(){
        this.timeline.stop();
        this.timeline = null;
        System.gc();
    }
    public int[] getPosition()
    {
        return position;
    }

    public int getCost() {

        return cost;
    }
    public boolean canBuy(){
        return System.currentTimeMillis() - lastBought >=buyTime;
    }
    public void buy(){
        lastBought = System.currentTimeMillis();
    }
    public abstract GameObject useAbility();

    public ImageView getPlantImage() {
        return plantImage;
    }

    public Timeline getTimeline() {
        return timeline;
    }
    public boolean eatPlant(int attk){
        if (defense>0){
            if (defense>attk){
                System.out.println(1);
                defense-=attk;
                return false;
            }
            else{
                defense = 0;
                attk -= defense;
                if (attk>hp){
                    hp = 0;
                    System.out.println(2);
                    return true;
                }
                else{
                    hp -= attk;
                    System.out.println(3);
                    return false;
                }
            }
        }
        else{
            System.out.println(attk+ " "+ hp);
            if (attk>hp){
                hp = 0;
                System.out.println(5);
                return true;
            }
            else{
                hp -= attk;
                System.out.println(6);
                return false;
            }
        }
    }

}

abstract class PeaShooter extends Plant{
    protected double timeIntervalForShooting;
    protected double timeElapsed;
    protected double startTime;


    public PeaShooter(int[] position){
         super(7000,100,0,position);
         this.startTime = System.currentTimeMillis();
         this.timeIntervalForShooting = 1500;

     }
     @Override
     public GameObject useAbility(){
         return this.shootPeas(position[1]);
     }

    protected abstract Pea shootPeas(int lane);
}

class NormalPeaShooter extends PeaShooter{
    public NormalPeaShooter(int[] position){
        super(position);
        Image m  = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/pea_shooter.gif")));
        plantImage = new ImageView(m);
        plantImage.setX((position[0]+1)*800/9);
    }
    @Override
    protected  Pea shootPeas(int lane){
        NormalPea p = new NormalPea(position,lane);
        p.move();
        return null;
    }

}


class Sunflower extends Plant{
    private  double timeIntervalOfSuns;
    private double lastSunProduced;
    protected TranslateTransition tt;
    public Sunflower(int[] position){
        super(7000,50, 25,position);
        this.timeIntervalOfSuns = 10000;
        this.lastSunProduced = 0;
        plantImage = new ImageView(new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/sun_flower.gif"))));
        plantImage.setX((position[0]+1)*800/9);

        tt = new TranslateTransition();


    }

    @Override
    public GameObject useAbility() {
//        if(lastSunProduced==0 || System.currentTimeMillis()-lastSunProduced > timeIntervalOfSuns){
//            lastSunProduced = System.currentTimeMillis();
//            return this.produceSuns();
//
//        }
//        this.produceSuns();
        return null;
    }

    public Sun produceSuns(){
        KeyFrame k2 = new KeyFrame(new Duration(2500),event -> {
            Sun new_sun = new Sun(position);
             GameScreen.lawngrid.add(new_sun.getSunImage(),position[0],position[1]);
            //s.getChildren().add(new_sun.getSunImage());
        });
        timeline.getKeyFrames().add(k2);
        timeline.play();
        return null;
    }
}

class WallNut extends Plant{
    public WallNut(int[] position){
        super(10000,50,15,position);
    }

    @Override
    public GameObject useAbility() {
        return null;
    }
}

