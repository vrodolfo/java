package com.teamroster.models;
import java.util.*;

public class Team {
	
	private String name;
	private ArrayList<Player> players;
	private int playersCount;
	
	public Team() {
		name ="";
		players = new ArrayList<>();
		playersCount = 0;
	}
	
	public Team(String name) {
		this.name = name;
		players = new ArrayList<>();
		playersCount = 0;
	}
	
	public int getPlayersCount() {
		return playersCount;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
		playersCount ++;
	}
	
	public void deletePlayer(String player) {
		//validar player es objeto player. Validar lista que no este vacia
		Iterator<Player> it = players.iterator();
		Player temp;
        while (it.hasNext()) {
            temp = it.next();
            if (temp.getFirstName().equals(player)) {
                it.remove();
                System.out.println("remove it");
                playersCount --;
            }
        }
	}

}
