package com.isep.hpah.core;

public abstract class character {
    public String name;
    public int maxHp, hp, xp;
    public character(String name, int maxHp, int xp){
        this.name = name;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp = maxHp;
    }

    public  abstract int attack();
    public  abstract int defend();
}
