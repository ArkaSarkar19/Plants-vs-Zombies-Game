package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private String userName;
    private String password;
    private Level instanceLevel;
    private int[] levelsCompleted;
//    private int currentLevel;
    private boolean midLevelSave;
    private Plant[][] garden;
    private ArrayList<Zombie> laneZombie_1;
    private ArrayList<Zombie> laneZombie_2;
    private ArrayList<Zombie> laneZombie_3;
    private ArrayList<Zombie> laneZombie_4;
    private ArrayList<Zombie> laneZombie_5;
    private int sunTokens;

//    public Controller controller;

    public Player(String name, String password){
        this.userName = name;
        this.password = password;
        this.instanceLevel = new Level1(this);
//        this.controller = new Controller();
    }
}
