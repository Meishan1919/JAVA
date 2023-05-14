package com.isep.hpah.core;

public class Enemy extends character{

    int PlayerXp;

    public static String[] name = {"Troll","Basilic","Détraqueurs","Voldemort\n" +
            "et Peter Pettigrow","Dolores Ombrage","Mangemorts","Voldemort et Bellatrix Lestrange"};
    public static int[] hp = {50,60,75,100,135,150,200};
    public static int[] maxHp = {50,60,75,100,135,150,200};
    public static int[] attack = {15,20,25,30,35,40,45};
    public static int[] defense = {5,10,15,20,25,30,35};
    public Enemy(String name, int maxHp, int xp) {
        super(name, maxHp, xp);
        this.xp = PlayerXp;
        //this.hp = maxHp;

    }

}
