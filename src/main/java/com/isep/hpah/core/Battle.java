package com.isep.hpah.core;
import java.util.Random;

import static com.isep.hpah.core.Gamelogic.*;

public class Battle {
    public static void battle() {
        while (true) {
            Gamelogic.clearConsole();
            Gamelogic.printHeading(Enemy.name[Player.xp] + " \nHp:" + Enemy.hp[Player.xp] + "/" + Enemy.maxHp[Player.xp]);
            System.out.println(Player.name + " \nHp:" + Player.hp + "/" + Player.maxHp);
            Gamelogic.printSeperator(30);
            System.out.println("choisissez une action:");
            System.out.println("1.Se battre\n2.Utilisez la Potion\n3.Utilisez le spell\n4.S'enfuir");
            int input = Gamelogic.readInt("->", 4);
            if (input == 1) {
                Random random = new Random();
                if (random.nextInt(10) < Player.miss) {
                    int dmg = Player.attack - Enemy.defense[Player.xp];
                    int dmgTook = Enemy.attack[Player.xp] - Player.defense;
                    if (dmgTook < 0) {
                        dmg -= dmgTook / 2;
                        dmgTook = 0;
                    }
                    if (dmg < 0)
                        dmg = 0;
                    Player.hp -= dmgTook;
                    Enemy.hp[Player.xp] -= dmg;
                    Gamelogic.clearConsole();
                    printHeading("BATAILLE");
                    System.out.println("Vous avez fait " + dmg + " dégâts au " + Enemy.name[Player.xp]);
                    Gamelogic.printSeperator(15);
                    System.out.println("Le " + Enemy.name[Player.xp] + " a fait " + dmgTook + " dégâts à vous.");
                    Gamelogic.appuyerenter();
                    if (Player.hp <= 0) {
                        Gamelogic.clearConsole() ;
                        printHeading("Vous êtes mort...");
                        System.out.println("C'est dommage que vous n'ayez pas passé ce niveau, continue à travailler dur la prochaine fois");
                        isRunning = false;
                        break;
                    } else if (Enemy.hp[Player.xp] <= 0) {
                        Gamelogic.clearConsole();
                        Gamelogic.printHeading("Vous avez vaincu le " + Enemy.name[Player.xp]);
                        Player.xp++;
                        Gamelogic.appuyerenter();
                        break;
                    }
                }else{
                    Gamelogic.clearConsole();
                    Gamelogic.printHeading("L'attaque a échoué！");
                    Gamelogic.appuyerenter();
                }
            }else if(input == 2){

            }else if(input == 3){

            }else{
                Gamelogic.clearConsole();
                if(Math.random()*10 + 1 <= 3.5){
                    printHeading("You ran away from the " + Enemy.name[Player.xp]);
                    Gamelogic.appuyerenter();
                    break;
                }else{
                    Gamelogic.printHeading("Vous n'avez pas réussi à vous échapper.");
                    int dmgTook = Enemy.attack[Player.xp];
                    System.out.println("Dans votre hâte vous avez pris " + dmgTook + " dégâts");
                    Player.hp -= dmgTook;
                    Gamelogic.appuyerenter();
                    if(Player.hp <= 0){
                        Gamelogic.clearConsole() ;
                        printHeading("Vous êtes mort...");
                        System.out.println("C'est dommage que vous n'ayez pas passé ce niveau, continue à travailler dur la prochaine fois");
                        isRunning = false;
                    }
                }
            }
        }


        }
        //player potion = new player();
    }
