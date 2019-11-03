package sample;

import javafx.animation.KeyFrame;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;


public abstract class Plant extends Character {
    protected final int[] position;
    protected final int buyTime;
    protected final int cost;
    protected double lastBought;
    protected ImageView plantImage;
    protected TranslateTransition tt;
    public Plant(int buyTime,int cost,int defense, int[] position){
        super( defense);
        this.buyTime = buyTime;
        this.cost = cost;
        this.position  = position;
        this.lastBought = 0;
    }
    public int getBuyTime() {
        return buyTime;
    }
    public int[] getPosition() {
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
         return this.shootPeas();
     }

    protected abstract Pea shootPeas();
}

class NormalPeaShooter extends PeaShooter{
    public NormalPeaShooter(int[] position){
        super(position);
        Image m  = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/pea_shooter.gif")));
        plantImage = new ImageView(m);
    }
    @Override
    protected  Pea shootPeas(){
        NormalPea p = new NormalPea(position,0);
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
        Random r = new Random();
        int a = r.nextInt(6);
        KeyFrame k2 = new KeyFrame(new Duration(2500-100*a),event -> {
            Sun new_sun = new Sun(position);
             GameScreen.lawngrid.add(new_sun.getSunImage(),position[0],position[1]);
            //s.getChildren().add(new_sun.getSunImage());
        });
        GameScreen.timeline.getKeyFrames().add(k2);
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

