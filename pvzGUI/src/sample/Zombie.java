package sample;

import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeSet;

//import java.sql.Time;

public class Zombie  extends Character implements Comparable<Zombie>{
    protected int lane;
    protected int position;
    protected int speed;
    protected int attack;
    protected boolean stop;
    protected double timeInstantiated;
    protected ImageView zombieImage;
    protected TranslateTransition tt;
    protected GameScreen gameScreen;
    protected ArrayList<Zombie> ZombieLane;
    protected Timeline timeline = new Timeline();
    private static int counter;
    protected int id;
    protected final int finSpeed;
    protected  MediaPlayer eatingSound;
    protected boolean blast;
    public Zombie(int defense, int attack, int lane, int position, int speed,int fS, GameScreen gs){
        super(defense);
//        eatingSound = new MediaPlayer(new Media(Paths.get("D:\\Rachit\\Semester 3\\AP\\Plants-vs-Zombies\\pvzGUI\\src\\sample\\resources\\sounds\\chomp.wav").toUri().toString()));
        eatingSound = new MediaPlayer(new Media(Paths.get("/home/arkasarkar/Desktop/APPROJECT/Plants-vs-Zombies/pvzGUI/src/sample/resources/sounds/chomp.wav").toUri().toString()));
        this.finSpeed = fS;
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
        tt = new TranslateTransition();
    }

    @Override
    public boolean equals(Object obj) {
        Zombie z = (Zombie) obj;
        return (this.id==z.getID());
    }

    public void peaAttack(int attack){
        if (this.hp+defense<=attack){
            hp = 0;
            System.out.println("ab marega ye");

            this.removeZombie();
        }
        else{
            if (defense >0){
                if (defense>=attack){
                    defense -= attack;
                    attack -=defense;
                }
                else{
                    defense = 0;
                }

            }
            if (hp>attack){
            hp -=attack;}
            else{
                hp =0;
            }
        }
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
    public int attack(int getJ, int s){
        if (getJ==-1) {
            for (int j = 0; j < 9; j++) {
                if (gameScreen.getGarden()[j][lane] != null) {
                    System.out.println(zombieImage);
                    if (zombieImage.getBoundsInLocal().getMinX() + 30 <= gameScreen.getGarden()[j][lane].getPlantImage().getX() && zombieImage.getBoundsInLocal().getMaxX() > gameScreen.getGarden()[j][lane].getPlantImage().getX()) {
                        getJ = j;
                        if (gameScreen.getGarden()[j][lane] instanceof CherryBomb) {
                            gameScreen.blast((int) gameScreen.getGarden()[j][lane].getPlantImage().getX(), lane, gameScreen.getGarden()[j][lane]);
                            stop = true;
                            blast = true;
                            return getJ;
                        }
                        eatingSound.setAutoPlay(true);
                        eatingSound.setCycleCount(10);

                        eatingSound.play();
                        //sound       here
                        if (gameScreen.eatPlant(j, lane, attack)) {
                            speed = s;
                            stop = false;
                        } else {
                            stop = true;
                            speed = 0;
                        }
                        break;
                    }
                     else{
                            speed = s;
                        }
                    }

                else {
                    speed = s;
                }
                }

            }

        else{
            if(gameScreen.getGarden()[getJ][lane] !=null && (zombieImage.getBoundsInLocal().getMinX()+30<=gameScreen.getGarden()[getJ][lane].getPlantImage().getX() && zombieImage.getBoundsInLocal().getMaxX()>gameScreen.getGarden()[getJ][lane].getPlantImage().getX())){
                //sound here
                eatingSound.setAutoPlay(true);
                if(gameScreen.getGarden()[getJ][lane] instanceof WallNut) eatingSound.setCycleCount(13);
                if(!(gameScreen.getGarden()[getJ][lane] instanceof WallNut)) eatingSound.setCycleCount(4);
                eatingSound.play();
                if (gameScreen.eatPlant(getJ,lane, attack)){
                    speed = s;
                    stop = false;
                }
                else {
                    stop = true;
                    speed = 0;
                }
            }
            else{
                speed = s;
            }
        }
        return getJ;
    }
    public void move(){
        tt.setDuration(Duration.millis(1000));
        getZombieImage().setX(800);
        tt.setByX(-speed);
        tt.play();
        tt.setOnFinished(e->{
            zombieImage.setX(zombieImage.getX()-speed);
            if(zombieImage.getX()<= 0){
                if (gameScreen.getLawnmowers()[lane] !=null){
//                    System.out.println("ho jaye shuru");
                    gameScreen.moveLawnmover(lane);
                }
                else{
                    gameScreen.setGameOver(true);
                }
                return;
            }
            int getJ = attack(-1,finSpeed);
            if (stop && blast){
                return;
            }
            if (!stop) {
                tt.playFromStart();
            }
            else{
                getJ = attack(getJ,finSpeed);

            }
            tt.setByX(-speed);
            tt.playFromStart();
        });
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
//                int prev = gameScreen.getLevel().getZombiesKilled();
                gameScreen.getLevel().setZombiesKilled();
                System.out.println("Itne zombies mare " + gameScreen.getLevel().getZombiesKilled());
//                zombieImage= new ImageView(String.valueOf(new Image(String.valueOf(Zombie.class.getResource("resources/spritesNStuff/zombie_normal_dying.gif")))));
                gameScreen.getLawngrid().getChildren().remove(this.zombieImage);
                ZombieLane.remove(i);
                tt.stop();
                tt= null;
//                z = null;
                System.gc();
                break;
            }
        }
    }
    protected void removeZombie(int i) {
        Zombie z = ZombieLane.get(i);
        if (z.equals(this)) {
//            int prev = gameScreen.getLevel().getZombiesKilled();
            gameScreen.getLevel().setZombiesKilled();
            System.out.println("Itne zombies mare " + gameScreen.getLevel().getZombiesKilled());
//                zombieImage= new ImageView(String.valueOf(new Image(String.valueOf(Zombie.class.getResource("resources/spritesNStuff/zombie_normal_dying.gif")))));
            gameScreen.getLawngrid().getChildren().remove(this.zombieImage);
            ZombieLane.remove(i);
            tt.stop();
            tt = null;
            z = null;
            System.gc();
        }
    }

    public Timeline getTimeline() {

        return timeline;
    }
    

}

class NormalZombie extends Zombie{
    public NormalZombie(int lane, GameScreen l){
        super(0,15,lane,0,10, 10,l);
        Image z = new Image(Zombie.class.getResource("resources/spritesNStuff/zombie_normal.gif").toString());
        zombieImage = new ImageView(z);
        tt.setNode(zombieImage);
    }
}

class FootballZombie extends Zombie{

    public FootballZombie(int lane, GameScreen gs) {
        super(50, 15, lane, 0, 20, 20, gs);
        Image z = new Image(Zombie.class.getResource("resources/spritesNStuff/zombie_football.gif").toString());
        zombieImage = new ImageView(z);
        tt.setNode(zombieImage);
    }

}
class BucketZombie extends Zombie{

    public BucketZombie(int lane, GameScreen gs) {
        super(100, 35, lane, 0, 10, 10, gs);
        Image z = new Image(Zombie.class.getResource("resources/spritesNStuff/zombie_bucket.gif").toString());
        zombieImage = new ImageView(z);
        zombieImage.setFitWidth(80);
        zombieImage.setFitHeight(140);
        tt.setNode(zombieImage);
    }

}
