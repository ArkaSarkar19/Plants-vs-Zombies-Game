package sample;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.ArrayList;

public class Lawnmower extends GameObject {
    private int lane;
    private int speed;
    private ImageView mowerImage;
    private GameScreen gameScreen;
    protected TranslateTransition tt;
    protected Timeline timeline = new Timeline();
    private ArrayList<Zombie> ZombieLane;
    protected MediaPlayer lawnMowerRoar;
    public Lawnmower(int lane,ImageView mI, GameScreen gameScreen){
        this.lane = lane;
        lawnMowerRoar = new MediaPlayer(new Media(Paths.get("/home/arkasarkar/Desktop/APPROJECT/Plants-vs-Zombies/pvzGUI/src/sample/resources/sounds/lamborghini.wav").toUri().toString()));
        this.gameScreen = gameScreen;
        this.speed = 20;
        this.mowerImage = mI;
        timeline.setCycleCount(Animation.INDEFINITE);
        tt = new TranslateTransition();
        tt.setNode(mowerImage);
        if (lane ==0){
            ZombieLane = gameScreen.getLaneZombie_1();
        }
        else if (lane ==1){
            ZombieLane = gameScreen.getLaneZombie_2();
        }
        else if (lane ==2){
            ZombieLane = gameScreen.getLaneZombie_3();
        }
        else if (lane ==3){
            ZombieLane = gameScreen.getLaneZombie_4();
        }
        else{
            ZombieLane = gameScreen.getLaneZombie_5();
        }
    }

    public ImageView getMowerImage() {
        return mowerImage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLane() {
        return lane;
    }

    protected void move() {
        tt.setDuration(Duration.millis(1000));
        mowerImage.setX(0);
        tt.setByX(+speed);
        lawnMowerRoar.play();
        tt.play();
        tt.setOnFinished(e->{
            mowerImage.setX(mowerImage.getX()+speed);
            if (mowerImage.getX()>=830){
                tt.stop();
                tt = null;
                gameScreen.getLawngrid().getChildren().remove(mowerImage);
                mowerImage=null;
                System.gc();
                return;
            }
            for (int i=0;i<ZombieLane.size();i++) {
                if ((ZombieLane.get(i).getZombieImage().getBoundsInLocal().getMinX() - 25 <= this.mowerImage.getX()) && ((ZombieLane.get(i).getZombieImage().getBoundsInLocal().getMaxX() -20 >= this.mowerImage.getX()))) {
                    System.out.println("mower hit");
                    ZombieLane.get(i).removeZombie();
                }
            }
            tt.playFromStart();

        });
    }

//    public int getCost() {
//        return cost;
//    }
    public void activate(){

    }
}
