package com.isep.hpah.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.isep.hpah.core.Gamelogic.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Potion {
    private String name;

    public static List<Potion> potions = new ArrayList<>();

    public static Potion ListPotion(player player) {
        Potion potion = ChoosePotion(player);
        potion.setName(potion.getName());

        return potion;
    }

    public static Potion ChoosePotion(player player) {
        Gamelogic.printHeading("我们准备了一个药水作为开学礼物，你可以从以下选项当中选择一个");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.回血\n" + "2.加强防御\n" + "3.加强攻击力\n" + "4.增加准度");
        int numbpotion = scanner.nextInt();
        Potion ChoosedPotion = null;
        switch (numbpotion) {
            case 1 -> ChoosedPotion = soin;
            case 2 -> ChoosedPotion = defence;
            case 3 -> ChoosedPotion = attack;
            case 4 -> ChoosedPotion = precision;
            default -> ChoosePotion(player);

        }
        System.out.println("Vous venez d'obtenir la potion " + ChoosedPotion.getName());
        Player.numpotion++;
        Gamelogic.appuyerenter();
        Player.getPotions().add(ChoosedPotion);
        return ChoosedPotion;
    }

    public static final Potion soin = new Potion("soin");
    public static final Potion defence = new Potion("defence");
    public static final Potion attack = new Potion("attack");
    public static final Potion precision = new Potion("precision");

    /*public void usepotion(){
        List<Potion> potions = this.getPotions();

    }*/
}
