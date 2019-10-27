package sample;

public class Pea extends GameObject{
    protected int  attack;
    protected int speed;
    protected int lane;
    protected int position;
    public Pea(int position,int lane){
        this.position = position;
        this.lane = lane;
        this.attack = 25;
        this.speed = 10;
    }

    public int getAttack() {
        return attack;
    }

    public int getLane() {
        return lane;
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }
    protected void  attack(Zombie zombie){

    }
    protected boolean checkBoundary(){
        return position<=0;
    }
}

class NormalPea extends Pea{
    public NormalPea(int position, int lane){
        super(position,lane);
    }
}