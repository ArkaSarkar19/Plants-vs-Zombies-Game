package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class Sun extends GameObject{
    private int[] position;
    private int sunSpeed;
    private ImageView sunImage;
    private TranslateTransition tt;
    private GameScreen gameScreen;

    public Sun(int[] position,GameScreen gameScreen){
        this.position = position;
        this.sunSpeed = 0;
        sunImage = new ImageView(new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/sun.gif"))));
        tt = new TranslateTransition();
        tt.setNode(sunImage);
        this.gameScreen = gameScreen;

    }
    public  Sun(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        Random p = new Random();
        int x = p.nextInt(9);
        position = new int[]{x, 0};
        sunImage = new ImageView(new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/sun.gif"))));
        tt = new TranslateTransition();
        tt.setNode(sunImage);
        gameScreen.lawngrid.add(sunImage,x,0);
        this.sunSpeed = 5;
    }

    public int getSunSpeed() {
        return sunSpeed;
    }

    public ImageView getSunImage() {
        return sunImage;
    }

    public int[] getPosition() {
        return position;
    }
    public void move(){
        tt.setDuration(Duration.millis(100));
        sunImage.setY(800);
        tt.setByY(+sunSpeed);
        tt.play();
        tt.setOnFinished(e->{
            tt.playFromStart();
            sunImage.setY(sunImage.getY()-sunSpeed);
            sunImage.setOnMouseClicked(event -> {
                gameScreen.lawngrid.getChildren().remove(sunImage);
                Button s = (Button) gameScreen.getLevel().scene1.lookup("#sunTokenButton");
                int prev = gameScreen.getSunTokens();
                int next = 25+prev;
                gameScreen.setSunTokens(next);
                s.setText(String.valueOf(gameScreen.getSunTokens()));
                this.remove();
            });
            if(sunImage.getY()<= 220){
                tt.stop();
            }
        });
    }
    public void remove(){
        gameScreen.getLawngrid().getChildren().remove(this.sunImage);
        sunImage= null;
        tt.stop();
        System.gc();

    }

}
