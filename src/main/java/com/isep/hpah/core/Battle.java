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
            System.out.println("Choisissez une action:");
            System.out.println("1.Se battre\n2.Utilisez la Potion\n3.Utilisez le spell\n4.S'enfuir");
            int input = Gamelogic.readInt("->", 4);
            if (input == 1) {
                Random random = new Random();
                int dmg = Player.attack - Enemy.defense[Player.xp];
                int dmgTook = Enemy.attack[Player.xp] - Player.defense;
                if (random.nextInt(10) < Player.miss) {
                    //int dmg = Player.attack - Enemy.defense[Player.xp];
                    //int dmgTook = Enemy.attack[Player.xp] - Player.defense;
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
                        if(Math.random()*10 + 1 <= 7.5){
                            Gamelogic.clearConsole();
                            int randomnumber = random.nextInt(5) + 1;
                            Gamelogic.printHeading("Félicitations, faites tomber "+ randomnumber +" potion au hasard en tuant le "+ Enemy.name[Player.xp]);
                            Player.numpotion += randomnumber;
                            Gamelogic.appuyerenter();
                        }
                        break;
                    }
                }else{
                    Gamelogic.clearConsole();
                    Gamelogic.printHeading("L'attaque a échoué！");
                    dmg = 0;
                    Player.hp -= dmgTook;
                    Gamelogic.appuyerenter();
                    Gamelogic.clearConsole();
                    printHeading("BATAILLE");
                    System.out.println("Vous avez fait " + dmg + " dégâts au " + Enemy.name[Player.xp]);
                    Gamelogic.printSeperator(15);
                    System.out.println("Le " + Enemy.name[Player.xp] + " a fait " + dmgTook + " dégâts à vous.");
                    Gamelogic.appuyerenter();
                }
            }else if(input == 2){
                Gamelogic.clearConsole();
                if(Player.numpotion > 0 && Player.hp < Player.maxHp){
                    Gamelogic.printHeading("Vous voulez boire une potion?(" + Player.numpotion + " resté).");
                    System.out.println("1.Oui\n2.Non,peut-être plus tard");
                    input = readInt("->",2);
                    if(input == 1){
                        Player.hp += Player.n;
                        Player.numpotion--;
                        if(Player.hp >= Player.maxHp){
                            Player.hp = Player.maxHp;
                        }
                        Gamelogic.clearConsole();
                        Gamelogic.printHeading("Vous avez bu une potion de soin,la santé est restaurée "+ Player.n);
                        Gamelogic.appuyerenter();
                    }
                }else{
                    Gamelogic.printHeading("Vous n'avez pas de potions ou votre santé est pleine");
                    Gamelogic.appuyerenter();
                }
            }else if(input == 3){

            }else{
                Gamelogic.clearConsole();
                if(Math.random()*10 + 1 <= 3.5){
                    printHeading("Vous avez fui le " + Enemy.name[Player.xp]);
                    Enemy.hp[Player.xp] = Enemy.maxHp[Player.xp];
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
    }
