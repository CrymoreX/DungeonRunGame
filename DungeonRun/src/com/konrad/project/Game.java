package com.konrad.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static com.konrad.project.Col.*;

public class Game {
    Scanner userInput = new Scanner(System.in); // USER INPUT
    Random random = new Random();
    Player player = new Player("",100,0,0,1,
            10,0,10);


    //  THE MAIN MENU //
    public void mainMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("\t\t\tWELCOME TO BATTLE ARENA");
        System.out.println("-----------------------------------------------");
        System.out.println("Enter Your name: ");
        player.setName(userInput.next());
        System.out.println("\nWelcome, " + CYAN_BOLD + player.getName() + RESET + "!");
        System.out.println("-----------------------------------------------");
        System.out.println("\t\t\t\t\tMAIN MENU");
        System.out.println("-----------------------------------------------");
        System.out.println("1. New Game");
        System.out.println("2. Credits/Game Instructions");
        System.out.println("0. Exit");
        System.out.println("-----------------------------------------------");
        int choice;
        boolean correctInput = true;
        do {
            try {
                choice = userInput.nextInt();
                switch (choice) {
                    case 1 -> startMenuFight();
                    case 2 -> credits();
                    case 0 -> System.out.println("You have quit the game");
                    default -> {System.out.println("Error. Please select a valid number");
                        correctInput= false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Please input the correct number, and try again");
                correctInput = false;
            } if (!correctInput) {
                userInput.next();
            }
        } while (!correctInput);
    }
    public void credits() {
        System.out.println("\n-----------------------------------------------");
        System.out.println("Welcome to Battle Arena!");
        System.out.println("Game Creator: Konrad Lenik");
        System.out.println("-----------------------------------------------");
        System.out.println("1. Go To Battle Menu");
        System.out.println("-----------------------------------------------");
        if (userInput.next().equals("1")) {
            startMenuFight();
        }
    }

    // THE SECOND MENU //
    public void startMenuFight() {

        boolean status = false;
        do {

            startSecondMenu();


            switch (userInput.next()) {
                case "1" -> {
                    playerCombatAct();
                }
                case "2" -> {
                    playerStats();
                }

                case "0" -> System.exit(0);
            }

        } while (!status);

    }

    public void startSecondMenu() {
        // Make more design!
        System.out.println("\n-----------------------------------------------");
        System.out.println("\t\t\t\tBATTLE MENU");
        System.out.println("-----------------------------------------------");
        System.out.println("1. Fight In The Arena");
        System.out.println("2. Player Stats");
        System.out.println("0. Exit");
        System.out.println("-----------------------------------------------");
    }

    public boolean playerStats() {
        System.out.println("\n-----------------------------------------------");
        System.out.println("\t\t\t\tPLAYER STATS");
        System.out.println("-----------------------------------------------");
        System.out.println(YELLOW + "Health: " + RESET + player.getHealth());
        System.out.println(CYAN +"Damage: " + RESET + player.getDamage());
        System.out.println("Experience: " + player.getExp());
        System.out.println("Level: " + player.getLevel());
        System.out.println(RED + "Strength: " + RESET + player.getStrength());
        System.out.println(BLUE + "Intelligence: " + RESET + player.getIntelligence());
        System.out.println(GREEN + "Agility: " + RESET + player.getAgility());
        System.out.println("-----------------------------------------------");

        return false;
    }


    // THE FIGHT SEQUENCE //
    public void playerCombatAct() {

        // ADDING FIGHTERS //
        List<Fighter> fighterList = new ArrayList<>();
        fighterList.add(new Bob("Bob the Blaster",70,10));
        fighterList.add(new Kelly("Kelly the Crusher", 50,10));

        // GENERATE MONSTER //
        Fighter fighter = fighterList.get(random.nextInt(fighterList.size()));
        System.out.println("\n-----------------------------------------------");
        // FIRST TEXT SHOWING THE FIGHTER //
        System.out.println("You are going against " + fighter);
        System.out.println("-----------------------------------------------");


        boolean isFighting;
        do {

                while (player.isAlive() && fighter.isAlive()) {

                    System.out.println("\n-----------------------------------------------");
                    System.out.println("Fighter HP: " + fighter.getHitPoints()
                            + "    " + "Player HP: " + player.getHealth());
                    System.out.println("-----------------------------------------------");


                    System.out.print("\n1. Attack \n2. Flee \n3. Player Stats\n");
                    System.out.println("-----------------------------------------------");

                    switch (userInput.next()) {
                        case "1" -> {
                            System.out.println("\n-----------------------------------------------");
                            System.out.println(CYAN + player.getName() + RESET + " punches the " + fighter.getName() + " for (" + CYAN + player.fight() + RESET + ") damage");
                            System.out.println(PURPLE + fighter.getName() + RESET + " punches you for (" + PURPLE + fighter.getDamage() + RESET + ") damage");
                            System.out.println("-----------------------------------------------");

                            // PLAYER TAKES DAMAGE //
                            player.setHealth(player.getHealth() - fighter.getDamage());
                            // FIGHTER TAKES DAMAGE //
                            fighter.setHitPoints(fighter.getHitPoints() - player.getDamage());

                        }
                        case "2" -> {
                            if (player.playerFlee()){
                                return;
                            }
                        }
                        case "3" -> {
                            playerStats();
                            return;
                        }
                    }


                } isFighting = false;
        } while (isFighting);


        if (!player.isAlive()) {
            player.playerGameOver();
        } else if (!fighter.isAlive()) {
            player.win();
            player.levelUp();


        System.out.println("\n-----------------------------------------------");
        System.out.println("\t\tWhat Do You Want To Do Now?");
        System.out.println("-----------------------------------------------");
        System.out.println("1. New Battle");
        System.out.println("0. Exit");
        System.out.println("-----------------------------------------------");

        int choice;
        boolean correctInput = true;
        do {
            try {
                choice = userInput.nextInt();
                switch (choice) {
                    case 1 -> playerCombatAct();
                    case 0 -> System.exit(0);
                    default -> {System.out.println("Error. Please select a valid number");
                        correctInput= false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Please input the correct number, and try again");
                correctInput = false;
            } if (!correctInput) {
                userInput.next();
            }
        } while (!correctInput);

        }
    }
}
