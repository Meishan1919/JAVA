package com.isep.hpah.core;

import java.util.Random;

import static com.isep.hpah.core.Gamelogic.*;

public class Spell {
    public static void spell() {
        Random random = new Random();
        if (Player.xp == 0) {
            Gamelogic.clearConsole();
            Gamelogic.printHeading("Vous voulez utiliez lequel spell?");
            System.out.println("1.Wingardium Leviosa\n2.Non, peut-être plus tard");
            int input = readInt("->", 2);
            if (input == 1) {
                有效魔咒();
            }
        } else if (Player.xp == 1) {
            Gamelogic.clearConsole();
            Gamelogic.printHeading("Vous voulez utiliez lequel spell?");
            if (Player.defense == 15) {
                System.out.println("1.Wingardium Leviosa\n2.Croc du basilic avec Accio\n3.Épée de Gryffondor");
                System.out.println("4.Non, peut-être plus tard");
                int input = readInt("->", 3);
                if (input == 1) {
                    Gamelogic.printHeading("Le spell ne fonctionne pas");
                    Gamelogic.appuyerenter();
                } else if (input == 2) {
                    有效魔咒();
                }else if(input == 3){
                    有效魔咒();
                }
            }else{
                System.out.println("1.Wingardium Leviosa\n2.Croc du basilic avec Accio\n3.Non, peut-être plus tard");
            }
            int input = readInt("->", 3);
            if (input == 1) {
                Gamelogic.printHeading("Le spell ne fonctionne pas");
                Gamelogic.appuyerenter();
            } else if (input == 2) {
                有效魔咒();
            }
        }

    }
    public static  void 有效魔咒(){
        Random random = new Random();
        if (random.nextInt(10) < 5) {
            Gamelogic.clearConsole();
            Gamelogic.printHeading("Vous avez vaincu le " + Enemy.name[Player.xp]);
            Player.xp++;
            Enemy.hp[Player.xp] = 0;
            Gamelogic.appuyerenter();
            if(Math.random()*10 + 1 <= 7.5){
                Gamelogic.clearConsole();
                int randomnumber = random.nextInt(5) + 1;
                Gamelogic.printHeading("Félicitations, faites tomber "+ randomnumber +" potion au hasard en tuant le "+ Enemy.name[Player.xp]);
                Player.numpotion += randomnumber;
                Gamelogic.appuyerenter();
            }
        } else {
            Gamelogic.clearConsole();
            Gamelogic.printHeading("L'attaque a échoué！");
            Gamelogic.appuyerenter();
            Player.hp -= Enemy.attack[Player.xp];
            Gamelogic.clearConsole();
            printHeading("BATAILLE");
            System.out.println("Vous avez fait 0 dégâts au " + Enemy.name[Player.xp]);
            Gamelogic.printSeperator(15);
            System.out.println("Le " + Enemy.name[Player.xp] + " a fait " + Enemy.attack[Player.xp] + " dégâts à vous.");
            Gamelogic.appuyerenter();
        }
    }

}
