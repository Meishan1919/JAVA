package com.isep.hpah.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import lombok.*;


import static com.isep.hpah.core.Gamelogic.*;

@Getter @Setter
public class player extends character{
    public int numpotion, numspell, numatkupgrades,numdefuprades, miss;

    public String[] spell = {"Wingardium Leviosa", "Accio","Expecto\n" +
            "Patronum","expelliarmus"};
    //public String[] potion;/*= {"soin(回血)","augmenter la defence加强防御","augmenter l'attack增加攻击力","augmenter la precision增加准度"};*/

    List<Potion> potions;

    public List<Potion> listPotion(){
        return potions;
    }
    public player(String name) {
        super(name, 100, 0);
        this.numatkupgrades = 0;
        this.numdefuprades = 0;
        this.numpotion = 0;
        this.miss = 60;
    }

    /*public List<Potion> potions(){
        List<Potion> potions = new ArrayList<>();
        return potions;
    }*/
    //public

    /*public void usepotion(){
        List<Potion> potions = this.getPotions();
    }*/

    //@Override
    //public int attack() {
       // return 0;
    //}

    /*public String getPotion(){
        return potion;
    }
    public void setPotion(){

        this.potion =potion;
    }*/
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    /*public static Potion ListPotion(Wizard wizard) {
        Potion potion = new potion();
        potion.setName(choosepotion(wizard));
        return potion;
    }

    private static String ChoosePotion(Wizard wizard) {
        Gamelogic.printHeading("我们准备了一个药水作为开学礼物，你可以从以下选项当中选择一个");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.回血\n"+"2.加强防御\n"+"3.加强攻击力\n"+"4.增加准度");
        int choosepotion = readInt("->",4);
        switch (choosepotion){
            case 1 -> choosepotion = soin;
            case 2 -> choosepotion = attack;
            case 3 -> choosepotion = defence;
            case 4 -> choosepotion = attack;
            default -> null;
            System.out.println("Vous venez d'obtenir la potion " + choosedpotion.getName());
            wizard.getPotions().add(choosedpotion);
            return choosedpotion.getName();
        }
        /*if(choosepotion == 1){
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

    public static final potion soin = new potion("soin");
    public static final potion defence = new potion("defence");
    public static final potion attack = new potion("attack");
    public static final potion precision = new potion("precision");*/

}