package sample;

public class Zombie  extends Character{
    protected int lane;
    protected int position;
    protected int speed;
    protected int attack;
    protected double timeInstantiated;
    public Zombie(int defense, int attack, int lane, int position, int speed){
        super(defense);
        this.attack = attack;
        this.lane   = lane;
        this.position = position;
        this.speed = speed;
        this.timeInstantiated = System.currentTimeMillis();
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
    public void attack(Plant plant){

    }
    public void move(){

    }
    public boolean gameOver(){
        return position == 0;
    }
    public void decreaseSpeedTemp(){

    }
}

class NormalZombie extends Zombie{
    public NormalZombie(int lane, int position){
        super(0,25,lane,position,10);
    }
}