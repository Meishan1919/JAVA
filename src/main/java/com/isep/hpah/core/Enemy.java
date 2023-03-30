package com.isep.hpah.core;

public class Enemy extends character{
    int PlayerXp;
    public Enemy(String name, int maxHp, int xp) {
        super(name,50, 1);
        this.PlayerXp = PlayerXp;

    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }
}
