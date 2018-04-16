package com.company;

public class Main {

    public static void main(String[] args) {
	Team<BasketballPlayer> basketteam = new Team<>("Chicago bulls");
	Team<BasketballPlayer> basketteam1 = new Team<>("Eagles");
	Team<BasketballPlayer> basketteam2 = new Team<>("Bools");
	Team<BasketballPlayer> basketteam3 = new Team<>("Lizard");
	Team<BasketballPlayer> basketteam4 = new Team<>("Star");
	Team<BasketballPlayer> basketteam5 = new Team<>("Pool");

	League<Team> BasketballLeague = new League<>("Liga podworkowa");
    }
}
