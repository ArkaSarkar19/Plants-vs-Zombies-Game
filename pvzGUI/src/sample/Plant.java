package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


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
         Image m  = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/pea_shooter.gif")));
         plantImage = new ImageView(m);
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
    }
    @Override
    protected  Pea shootPeas(){
        return  null;
    }

}


class Sunflower extends Plant{
    private  double timeIntervalOfSuns;
    private double lastSunProduced;
    public Sunflower(int[] position){
        super(7000,50, 25,position);
        this.timeIntervalOfSuns = 10000;
        this.lastSunProduced = 0;
    }

    @Override
    public GameObject useAbility() {
        if(lastSunProduced==0 || System.currentTimeMillis()-lastSunProduced > timeIntervalOfSuns){
            lastSunProduced = System.currentTimeMillis();
            return this.produceSuns();
        }
        return null;
    }

    private Sun produceSuns(){
        Sun new_sun = new Sun(position);
        return new_sun;
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

