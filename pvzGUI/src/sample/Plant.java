package sample;

public abstract class Plant extends Character {
    protected final int[][] position;
    protected final int buyTime;
    protected final int cost;
    protected double lastBought;
    public Plant(int buyTime,int cost,int defense, int[][] position){
        super( defense);
        this.buyTime = buyTime;
        this.cost = cost;
        this.position  = position;
        this.lastBought = 0;
    }
    public int getBuyTime() {
        return buyTime;
    }
    public int[][] getPosition() {
        return position;
    }
    public int getCost() {
        return cost;
    }
    public boolean canBuy(){
        return System.currentTimeMillis() - lastBought >=buyTime;
    }
    public void buy(){
        lastBought = System.currentTimeMillis();
    }
    public abstract GameObject useAbility();
}

abstract class PeaShooter extends Plant{
    protected double timeIntervalForShooting;
    protected double timeElapsed;
    protected double startTime;
     public PeaShooter(int[][] position){
         super(7000,100,0,position);
         this.startTime = System.currentTimeMillis();
         this.timeIntervalForShooting = 1500;
     }
     protected abstract Pea shootPeas();
}



class Sunflower extends Plant{
    private  double timeIntervalOfSuns;
    private double lastSunProduced;
    public Sunflower(int[][] position){
        super(7000,50, 25,position);
        this.timeIntervalOfSuns = 10000;
        this.lastSunProduced = 0;
    }

    @Override
    public GameObject useAbility() {
        if(lastSunProduced==0 || System.currentTimeMillis()-lastSunProduced > timeIntervalOfSuns){
            lastSunProduced = System.currentTimeMillis();
            return this.produceSuns();
        }
        return null;
    }

    private Sun produceSuns(){
        Sun new_sun = new Sun(position);
        return new_sun;
    }
}