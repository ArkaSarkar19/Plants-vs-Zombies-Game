package sample;

import java.util.Random;

public class Sun extends GameObject{
    private int[][] position;
    private int sunSpeed;
    public Sun(int[][] position){
        this.position = position;
        this.sunSpeed = 0;
    }
    public  Sun(){
        Random p = new Random();
        int x = p.nextInt(9);
        position = new int[][]{{x, 0}};
        this.sunSpeed = 6;
    }

    public int getSunSpeed() {
        return sunSpeed;
    }
}
