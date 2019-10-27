package sample;

public class Character extends GameObject {
    protected double hp;
    protected final int defense;
    protected final double timeInstantiated;
    public Character(int defense){
        this.hp = 100;
        this.defense = defense;
        this.timeInstantiated = System.currentTimeMillis();
    }
    public boolean isDead(){
        return hp<=0;
    }
    public void isAttacked(double hit){
        hp-=hit;
    }
    public double getHp() {
        return hp;
    }
    public int getDefense() {
        return defense;
    }
}
