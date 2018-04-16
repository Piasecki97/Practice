package com.company;

public abstract class Player {
    String name;
    int sportStats;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSportStats() {
        return sportStats;
    }

    @Override
    public String toString() {
        return "Player " +
                " name is " + name + '\'' +
                " with sport stats " + sportStats;
    }
}
