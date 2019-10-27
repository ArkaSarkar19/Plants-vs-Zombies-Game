package sample;

public class Lawnmower extends GameObject {
    private int lane;
    private int speed;
    private final int cost;
    public Lawnmower(int lane, int speed){
        this.lane = lane;
        this.speed = speed;
        this.cost = 4;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLane() {
        return lane;
    }

    public int getCost() {
        return cost;
    }
    public void activate(){

    }
}
