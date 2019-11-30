package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public abstract class Plant extends Character {
    protected final int[] position;
    protected final int buyTime;
    protected final int cost;
    protected double lastBought;
    protected ImageView plantImage;
    protected TranslateTransition tt;
    protected Timeline timeline;
    protected GameScreen gameScreen;
    public Plant(int buyTime,int cost,int defense, int[] position){
        super(defense);
        this.buyTime = buyTime;
        this.cost = cost;
        this.position  = position;
        this.lastBought = 0;
        timeline = new Timeline();
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

                defense-=attk;
                return false;
            }
            else{
                defense = 0;
                attk -= defense;
                if (attk>hp){
                    hp = 0;

                    return true;
                }
                else{
                    hp -= attk;

                    return false;
                }
            }
        }
        else{

            if (attk>hp){
                hp = 0;

                return true;
            }
            else{
                hp -= attk;

                return false;
            }
        }
    }


}

abstract class PeaShooter extends Plant{
    protected double timeIntervalForShooting;
    protected double startTime;


    public PeaShooter(int[] position){
         super(7000,100,0,position);
         this.timeIntervalForShooting = 1500;

     }
     @Override
     public GameObject useAbility(){
         return this.shootPeas(position[1]);
     }

    protected abstract Pea shootPeas(int lane);
}

class NormalPeaShooter extends PeaShooter{
    public NormalPeaShooter(int[] position, GameScreen gameScreen){
        super(position);
        Image m  = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/pea_shooter.gif")));
        plantImage = new ImageView(m);
        plantImage.setX((position[0]+1)*800/9);
        this.gameScreen = gameScreen;
    }
    @Override
    protected  Pea shootPeas(int lane){
        NormalPea p = new NormalPea(position,(position[0]+1)*800/9,lane,gameScreen);
        p.move();
        return null;
    }

}


class Sunflower extends Plant{
    private  double timeIntervalOfSuns;
    private double lastSunProduced;
    protected TranslateTransition tt;
    public Sunflower(int[] position, GameScreen gameScreen){
        super(7000,50, 25,position);
        this.timeIntervalOfSuns = 10000;
        this.lastSunProduced = 0;
        plantImage = new ImageView(new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/sun_flower.gif"))));
        plantImage.setX((position[0]+1)*800/9);
        this.gameScreen = gameScreen;
        tt = new TranslateTransition();


    }

    @Override
    public GameObject useAbility() {
        this.produceSuns();
        return null;
    }

    public Sun produceSuns(){
        Sun new_sun = new Sun(position,gameScreen);
        gameScreen.lawngrid.add(new_sun.getSunImage(),position[0],position[1]+1);

        new_sun.move();
        return null;
    }
}

class WallNut extends Plant{
    public WallNut(int[] position, GameScreen gameScreen){
        super(10000,50,100,position);
        this.gameScreen = gameScreen;
        Image m  = new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/walnut_full_life.gif")));
        plantImage = new ImageView(m);
        plantImage.setX((position[0]+1)*800/9);
    }

    @Override
    public GameObject useAbility() {
        return null;
    }
}

