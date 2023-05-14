package com.isep.hpah.core;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Gamelogic {
    static Scanner scanner = new Scanner(System.in);
    static player Player;

    public static boolean isRunning;

    public static int place = 0, act;
    public static String[] places = {"The Philosopher’s Stone","The Chamber of Secrets","The Prisonner of Azkaban","The Goblet of Fire","The Order of the Phenix","The Half-Blood Prince","The Deathly Hallows"};
    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = scanner.nextInt();
                if (input < 1 || input > 4) {
                    System.out.println("Veuillez choisir entre 1 et 4");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Veuillez choisir entre 1 et 4");
                scanner.nextLine();
            }
        }while (true);
        return input;
    }

    public static void clearConsole(){
        for(int i = 0; i <100; i++)
            System.out.println();
    }

    public static void printSeperator(int n){
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printHeading(String title){
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    public static void appuyerenter(){
        /*System.out.println("Appuyer ENTER pour continuer");
        scanner.next();*/
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println("Appuyer ENTER pour continuer");
        s.nextLine();
    }

    public static void startGame(){
        clearConsole();
        printSeperator(40);
        printSeperator(30);
        System.out.println("HARRY POTTER");
        System.out.println("RPG BY CHEN Meishan");
        printSeperator(30);
        printSeperator(40);
        appuyerenter();
        clearConsole();
        story.introduction();
        clearConsole();
        printHeading("Veillez entrer votre nom de joueur ：");
        String name = scanner.nextLine();
        clearConsole();
        System.out.println("Bonjour, " + name);
        appuyerenter();
        Player = new player(name);
        isRunning = true;
        story.lession();
        gameloop();

    }

    public static void printMenu(){
            clearConsole();
            printHeading(places[place]);
            System.out.println("Choisissez une action:");
            System.out.println("(1) Continuez votre voyage");
            System.out.println("(2) CHARACTER INFO");
            System.out.println("(3) Quitter le jeu");


    }

    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(Player.name+ "\tHP:" + Player.hp+"/"+ Player.maxHp);
        printSeperator(20);
        System.out.println("Attack:" +Player.attack + "\tDéfense:" +Player.defense);
        printSeperator(20);
        System.out.println("Nombre de potions:" +Player.numpotion);
        printSeperator(20);
        /*if(Player.numpotion > 0){
            System.out.println("药水名字:" +Player.numpotion);
        }*/
        System.out.println("Niveau:" +Player.xp);
        printSeperator(20);
        System.out.println("spell:" + Player.spell[Player.numspell]);
        printSeperator(20);
        appuyerenter();
    }

    public static void checkAct(){
        if(Player.xp == 0){
            place = 0;
            story.PhilosopherStone();
            Battle.battle();
        }else if(Player.xp == 1) {
            place = 1;
            story.ChamberofSecrets();
            Battle.battle();
        }else if(Player.xp == 2){
            place = 2;
            story.PrisonnerofAzkaban();
            Battle.battle();
        }else if(Player.xp == 3) {
            place = 3;
            story.GobletofFire();
            Battle.battle();
        }else if(Player.xp == 4) {
            place = 4;
            story.OrderofthePhenix();
            Battle.battle();
        }else if(Player.xp == 5) {
            place = 5;
            story.HalfBloodPrince();
            Battle.battle();
        }else if(Player.xp == 6) {
            place = 6;
            story.DeathlyHallows();
            Battle.battle();
        }
    }
    public static void continueJourney(){
        checkAct();

    }
    public static void gameloop(){
        while(isRunning){
            printMenu();
            int input = readInt("->",3);
            if(input == 1)
                continueJourney();
            else if(input == 2)
                characterInfo();
            else
                isRunning =false;
        }
    }
}


