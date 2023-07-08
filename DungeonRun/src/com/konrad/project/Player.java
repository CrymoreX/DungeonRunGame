package com.konrad.project;

import java.util.Random;
import static com.konrad.project.Col.*;

public class Player implements ICombat {

    // MAKING VARIABLES FOR PLAYER //
    private String name;
    private int health;
    private int damage;
    private int exp;
    private int level;
    private int strength;
    private int intelligence;
    private int agility;
    Random random = new Random();

    // GENERATE CONSTRUCTOR //
    public Player(String name, int health, int damage, int exp, int level,
                  int strength, int intelligence, int agility) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.exp = exp;
        this.level = level;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;

    }


    // METHOD FOR PLAYER XP //
    public void win() {
        exp += 50;
        System.out.println("\n-----------------------------------------------");
        System.out.println("You won the battle!");
        System.out.println("You have gained " + getExp() + " experience points!");
        System.out.println("-----------------------------------------------");
    }

    // METHOD WHERE PLAYER GETS LEVEL WHEN 100 EXP //
    public int levelUp() {
        if (exp == 100) {
            System.out.println("-----------------------------------------------");
            System.out.println("\t\t\t--> LEVEL UP <---");
            System.out.println("-----------------------------------------------");
            setLevel(getLevel() + 1);
            System.out.println("Your new level is: " + level);
            setExp(0);
            System.out.println("-----------------------------------------------");
            System.out.println(RED + "Strength increased by +2" + RESET);
            setStrength(getStrength() + 2);
            System.out.println("-----------------------------------------------");
            System.out.println(BLUE + "Intelligence increased by +2" + RESET);
            setIntelligence(getIntelligence() + 2);
            System.out.println("-----------------------------------------------");
            System.out.println(GREEN + "Agility increased by +2" + RESET);
            setAgility(getAgility() + 2);
            System.out.println("-----------------------------------------------");
            System.out.println(YELLOW + "Your health is set back to 100 again" + RESET);
            setHealth(100);
            System.out.println("-----------------------------------------------");
        }
        return level;
    }


    // METHOD FOR PLAYER FLEE //
    public boolean playerFlee() {
        // 50 % chance of being able to run.
        int roll = random.nextInt(1, 4);
        if (roll == 2) {
            System.out.println("\t\t>>> You Successfully Run Away <<<");
            return true;
        } else {
            System.out.println("\t\t>>> You Could Not Escape <<<");
            System.out.println("\t\t  You Suffered -10 Health");
            health = getHealth() - 10;
            return false;
        }
    }

    public void playerGameOver() {
        System.out.println("\t\t\tK.O");
        System.out.println("-----------------------------------------------");
        System.out.println("\t\t\tGame Over!");
        System.out.println("-----------------------------------------------");
        System.exit(0);
    }

    @Override
    public int fight () {
        damage = (strength + agility + level + intelligence);
        return damage;
    }


    // GETTER AND SETTERS // GENERATE --> GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
    public boolean isAlive() {
        return health > 0;
    }
}

