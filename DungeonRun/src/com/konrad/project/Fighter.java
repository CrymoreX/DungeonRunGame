package com.konrad.project;


public class Fighter implements ICombat {

    private String name;
    private int hitPoints;
    private int damage;


    // GENERATE CONSTRUCTOR --> EVERY VARIABLE ABOVE //
    public Fighter(String name, int hitPoints, int damage) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.damage = damage;
    }

    // CREATING FIGHTER FIGHT AND CALCULATE DAMAGE //
    @Override
    public int fight() {
        return damage;
    }


    // GETTERS AND SETTERS //
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public boolean isAlive() {
        return hitPoints > 0;
    }


    // SHOWING FIGHTER STATS IN GAME //
    @Override
    public String toString() {
        return
                name +
                "\nHitpoints: " + hitPoints +
                "\nDamage: " + damage;
    }
}


