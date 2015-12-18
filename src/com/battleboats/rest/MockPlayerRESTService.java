package com.battleboats.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.battleboats.Mock;
import com.battleboats.data.Player;

@Mock
@Named("playerRESTService")
public class MockPlayerRESTService
 implements IPlayerRESTService 
{
	
	private static Map<String, Player> players = new Hashtable<>();
	private static int nextCustomerId = 0;
	
	static {
		Player hpotter = new Player(1, "hpotter");
		hpotter.setId(1);
		hpotter.setDisplayName("The Boy Who Lived");
		hpotter.setEmail("hpotter@hogwarts.ac.uk");
		
		Player rweasley = new Player(2, "rweasley");
		rweasley.setId(2);
		rweasley.setDisplayName("Roni Weasley");
		rweasley.setEmail("ron@hogwarts.ac.uk");
		
		Player hgranger = new Player(3, "hgranger");
		hgranger.setId(3);
		hgranger.setDisplayName("Hermione Granger");
		hgranger.setEmail("hermione@hogwarts.ac.uk");
		
		players.put("hpotter", hpotter);
		players.put("rweasley", rweasley);
		players.put("hgranger", hgranger);
		nextCustomerId = 4;
	}

	
	
	public Player insert(Player player) {
		player.setId(nextCustomerId++);
		players.put(player.getUsername(), player);
		return player;
	}

	public Player update(Player player) {
		players.put(player.getUsername(), player);
		return null;
	}

	public Player delete(Player player) {
		players.remove(player.getUsername());
		return null;
	}

	public Player findById(Integer id) {
		Collection<Player> allPlayers = players.values();
		for(Player p : allPlayers) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public Player findByUserName(String userName) {
		players.get(userName);
		return null;
	}

	public List<Player> findByEmail(String email) {
		Collection<Player> allPlayers = players.values();
		List<Player> results = new ArrayList<>();
		for(Player p : allPlayers) {
			if (p.getEmail().equalsIgnoreCase(email)) {
				results.add(p);
			}
		}
		return results;
	}

	public List<Player> findAll() {
		return new ArrayList<Player>(players.values());
	}

}
