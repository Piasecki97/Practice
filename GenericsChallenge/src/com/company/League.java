package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    String leagueName;

    ArrayList<T> teams = new ArrayList<>();

    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    public void addTeam(T team){
        if(teams.contains(team)){
            System.out.println("Can't add this team. It's already in table");
        } else {
            teams.add(team);
        }
    }
    public void removeTeam(String teamName){
        if(findTeam(teamName) != null){
            teams.remove(findTeam(teamName));
        } else {
            System.out.println("Team not deleted because it wasn't in league table.");
        }
    }

    public void sort(){
        Collections.sort(teams);
    }

    public Team findTeam(String teamName){
        for(Team team : teams){
            if(team.getName().equals(teamName)){
                return team;
            }
        }
        return null;
    }
}
