package com.isep.hpah.core;

import static com.isep.hpah.core.Gamelogic.*;

public class player extends character{
    public int numpotion, numspell, numatkupgrades,numdefuprades;
    public String[] spell = {"Wingardium Leviosa", "Accio","Expecto\n" +
            "Patronum","expelliarmus"};
    public String[] potion = {"回血","加强防御","增加攻击力","增加准度"};
    public player(String name) {
        super(name, 100, 0);
        this.numatkupgrades = 0;
        this.numdefuprades = 0;
        this.numpotion = 0;
        choosepotion();
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    public void choosepotion(){
        Gamelogic.printHeading("我们准备了一个药水作为开学礼物，你可以从以下选项当中选择一个");
        System.out.println("1.回血\n"+"2.加强防御\n"+"3.加强攻击力\n"+"4.增加准度");
        int choosepotion = readInt("->",4);
        if(choosepotion == 1){
            System.out.println("Vous avez choisi potion 回血");
            numpotion++;
        }else if(choosepotion == 2){
            System.out.println("Vous avez choisi potion 加强防御");
            numpotion++;
        }else if(choosepotion == 3){
            System.out.println("Vous avez choisi potion 加强攻击力");
            numpotion++;
        }else if(choosepotion == 4){
            System.out.println("Vous avez choisi potion 增加准度");
            numpotion++;
        }
        Gamelogic.appuyerenter();
    }

}