package sample;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Pea extends GameObject{
    protected int  attack;
    protected int speed;
    protected int lane;
    protected int[] position;
    protected ImageView peaImage;
    protected TranslateTransition tt;
    protected static Timeline timeline;
    public Pea(int[] position,int lane){
        this.position = position;
        this.lane = lane;
        this.attack = 25;
        this.speed = 25;
        Image z = new Image(Pea.class.getResource("resources/spritesNStuff/Pea.png").toString());
        peaImage = new ImageView(z);
        tt = new TranslateTransition();
        tt.setNode(peaImage);
        GameScreen.lawngrid.add(this.getPeaImage(),position[0]+1,position[1]);
    }

    public int getAttack() {
        return attack;
    }

    public int getLane() {
        return lane;
    }

    public int[] getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }
    protected void  attack(Zombie zombie){

    }
    protected boolean checkBoundary(){
        return position[1]<=0;
    }

    public ImageView getPeaImage() {
        return peaImage;
    }

    protected void move(){
        tt.setDuration(Duration.millis(100));
        peaImage.setX(800);
        tt.setByX(+speed);
        tt.play();
        tt.setOnFinished(e->{
            tt.playFromStart();
            peaImage.setX(peaImage.getX()-speed);
            if(peaImage.getX()<= 0){
                tt.stop();
            }
        });
    }

    public static void setTimeline(Timeline timeline) {
        Pea.timeline = timeline;
    }
}

class NormalPea extends Pea{
    public NormalPea(int[] position, int lane){
        super(position,lane);
    }
}