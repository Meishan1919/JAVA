package com.isep.hpah.core;
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
       /* do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Veuillez choisir entre 1 et 4");
            }
        }while(input < 1 || input > userChoices);
        System.out.println("Veuillez choisir entre 1 et 4");
        return input;
    }*/

    /*public static void clearConsole(){
        for(int i = 0; i <100; i++)
            System.out.println();
    }*/

    public static void printSeperator(int n){
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printHeading(String title){
        System.out.println(title);
    }

    public static void appuyerenter(){
        /*System.out.println("Appuyer ENTER pour continuer");
        scanner.next();*/
        Scanner s = new Scanner(System.in);
        System.out.println("Appuyer ENTER pour continuer");
        s.nextLine();
    }

    public static void startGame(){
        /*boolean nameSet =false;
        String name;*/
        System.out.println("Bienvenue dans Harry Potter at Home, le RPG des sorciers. Avez-vous l’étoffe des plus grands\n" +
                "sorciers ? Saurez-vous relever tous les défis ? C’est parti !\n" +
                "Votre objectif est de valider votre scolarité à Poudlard. Chaque année sera parsemée d’embuches.\n ");
        appuyerenter();
        /*do{
            printHeading("Veillez entrer votre nom de joueur ：");
            name = scanner.next();
            printHeading("Bonjour" +" "+ name +" "+ "c'est correct?");
            System.out.println("1.Oui");
            System.out.println("2.Je veux changer");
            int input = readInt("->",2);
            if(input == 1)
               nameSet = true;
               System.out.println("Bonjour" + " "+ name);
        }while(!nameSet);*/
       printHeading("Veillez entrer votre nom de joueur ：");
         String name = scanner.next();
        System.out.println("Bonjour," + name);
        System.out.print("\n");
        printHeading("Il y a quatre maisons,Chaque maison a sa spécificité :\n" +
                "•Les potions sont plus efficaces pour les membres de Hufflepuff.\n" +
                "•Les sorts font plus de dégâts pour les membres de Slytherin.\n" +
                "• Les sorciers de Gryffindor sont plus résistants aux dégâts.\n" +
                "• Les sorciers de Ravenclaw sont plus précis.");
        choice();
        Player = new player(name);
        isRunning = true;
        gameloop();


    }

    public static void printMenu(){
        printHeading(places[place]);
        System.out.println("choose an action:");
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");

    }

    public static void characterInfo(){
        printHeading("CHARACTER INFO");
        System.out.println(Player.name+ "\tHP:" + Player.hp+"/"+ Player.maxHp);
        System.out.println("XP:" +Player.xp);
        System.out.println("药水数量:" +Player.numpotion);
        System.out.println("Niveau:" +Player.xp);
        appuyerenter();
    }
    public static void continueJourney(){
        story.PhilosopherStone();

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
    public static void choice() {
        // 定义ANSI颜色码
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        int choicehouse =Gamelogic.readInt(ANSI_YELLOW + "1.Hufflepuff\n" + ANSI_RESET +
                ANSI_GREEN + "2.Slytherin\n" + ANSI_RESET +
                ANSI_RED + "3.Gryffindor\n" + ANSI_RESET +
                ANSI_BLUE + "4.Ravenclaw" + ANSI_RESET,4);
        /*int choice = 0;
        while (true) {
            System.out.println(ANSI_YELLOW + "1.Hufflepuff\n" + ANSI_RESET +
                    ANSI_GREEN + "2.Slytherin\n" + ANSI_RESET +
                    ANSI_RED + "3.Gryffindor\n" + ANSI_RESET +
                    ANSI_BLUE + "4.Ravenclaw" + ANSI_RESET);
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 4) {
                    System.out.println("Veuillez choisir entre 1 et 4。");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Veuillez choisir entre 1 et 4");
                scanner.nextLine();
            }
        }*/
        if (choicehouse == 1) {
            System.out.println("Vous faites maintenant partie de" + ANSI_YELLOW + "Hufflepuff " + ANSI_RESET);
        } else if (choicehouse == 2) {
            System.out.println("Vous faites maintenant partie de" + ANSI_GREEN + "Slytherin " + ANSI_RESET);
        } else if (choicehouse == 3) {
            System.out.println("Vous faites maintenant partie de" + ANSI_RED + "Gryffindor " + ANSI_RESET);
        } else if (choicehouse == 4) {
            System.out.println("Vous faites maintenant partie de" + ANSI_BLUE + "Ravenclaw " + ANSI_RESET);
        }

    }
}
