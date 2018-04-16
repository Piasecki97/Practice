package com.company;

import java.util.ArrayList;

public class Team <T extends Player> implements Comparable<Team <T>> {
    private String name;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    public Team(String name) {
        this.name = name;
    }

    ArrayList<T> players = new ArrayList<>();
    public void addPlayer(T player){
        players.add(player);
        System.out.println("Player added");

    }
    public void kickPlayer(String playerName){
        if(players.contains(findPlayer(playerName))){
            players.remove(findPlayer(playerName));
            System.out.println("Player removed.");
        } else {
            System.out.println("Player not removed, hence he was not found.");
        }
    }
    public Player findPlayer(String name){
        for(Player player : players){
            if(player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }

    public void match(Team<T> opponent, int ourScore, int theirScore){
        if(ourScore>theirScore){
            won++;
        } else if(ourScore<theirScore){
            lost++;
        }else {
            tied++;
        } if(opponent != null){
            match(null,theirScore,ourScore);
        }
    }

    public int ranking(){
        return (won*2)+tied;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking()>team.ranking()){
            return -1;
        } else if (this.ranking()<team.ranking()){
            return 1;
        } else {
            return 0;

        }

    }
}
