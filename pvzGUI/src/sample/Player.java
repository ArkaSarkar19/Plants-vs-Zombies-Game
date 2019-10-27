package sample;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private Level instanceLevel;

    public Player(String name){
        this.name = name;
        this.instanceLevel = new Level1(this,new GameScreen());
    }
}
