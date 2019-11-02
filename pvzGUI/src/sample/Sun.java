package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.util.Random;

public class Sun extends GameObject{
    private int[] position;
    private int sunSpeed;
    private ImageView sunImage;
    public Sun(int[] position){
        this.position = position;
        this.sunSpeed = 0;
        sunImage = new ImageView(new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/sun.gif"))));
    }
    public  Sun(){
        Random p = new Random();
        int x = p.nextInt(9);
        position = new int[]{x, 0};
        this.sunSpeed = 6;
    }

    public int getSunSpeed() {
        return sunSpeed;
    }

    public ImageView getSunImage() {
        return sunImage;
    }
}
