package com.isep.hpah.core;

import java.util.List;

import lombok.*;


import static com.isep.hpah.core.Gamelogic.*;

@Getter @Setter
public class player extends character {
    public int numpotion, numspell;
    public int attack;
    public int defense;
    public int miss;
    public int n;
    public int m;
    private String potion;

    public String[] spell = {"Wingardium Leviosa", "Accio", "Expecto\n" +
            "Patronum", "expelliarmus"};
    /*public String[] potion1= {"soin(回血)"};
    public String[] potion2 ={"augmenter la defence加强防御"};
    public String[] potion3 ={"augmenter l'attack增加攻击力"};
    public String[] potion4 = {"augmenter la precision增加准度"};*/


    public player(String name) {
        super(name, 150, 0);
        this.attack = 20;
        this.defense = 10;
        this.miss = 7;
        this.n = 5;
        this.potion = potion;
        this.m = 4;
        choosehouse();
        //  ChoosePotion();
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    public String getPotion() {
        return potion;
    }


    public void choosehouse() {
        Gamelogic.clearConsole();
        Gamelogic.printHeading("Il y a quatre maisons,Chaque maison a sa spécificité :\n" +
                "•Les potions sont plus efficaces pour les membres de Hufflepuff.\n" +
                "•Les sorts font plus de dégâts pour les membres de Slytherin.\n" +
                "• Les sorciers de Gryffindor sont plus résistants aux dégâts.\n" +
                "• Les sorciers de Ravenclaw sont plus précis.");
        // 定义ANSI颜色码
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        int choicehouse = Gamelogic.readInt(ANSI_YELLOW + "1.Hufflepuff\n" + ANSI_RESET +
                ANSI_GREEN + "2.Slytherin\n" + ANSI_RESET +
                ANSI_RED + "3.Gryffindor\n" + ANSI_RESET +
                ANSI_BLUE + "4.Ravenclaw" + ANSI_RESET, 4);
        if (choicehouse == 1) {
            clearConsole();
            Gamelogic.printHeading("Vous faites maintenant partie de" + ANSI_YELLOW + " Hufflepuff " + ANSI_RESET);
            n += m;
        } else if (choicehouse == 2) {
            clearConsole();
            Gamelogic.printHeading("Vous faites maintenant partie de" + ANSI_GREEN + " Slytherin " + ANSI_RESET);
            attack += n;
        } else if (choicehouse == 3) {
            clearConsole();
            Gamelogic.printHeading("Vous faites maintenant partie de" + ANSI_RED + " Gryffindor " + ANSI_RESET);
            defense += n;
        } else if (choicehouse == 4) {
            clearConsole();
            Gamelogic.printHeading("Vous faites maintenant partie de" + ANSI_BLUE + " Ravenclaw " + ANSI_RESET);
            miss++;
        }
        appuyerenter();
        clearConsole();
        Gamelogic.printHeading("Nous avons préparé deux potions de guérison comme cadeaux pour vous");
        numpotion++;
        numpotion++;

    }
}



