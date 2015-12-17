package com.battleboats.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.battleboats.data.Player;

public interface IPlayerRESTService {

	Player insert(Player player);

	Player update(Player player);

	Player delete(Player player);

	// Full URL: http://localhost:8080/BattleBoats/rest/players/1234
	Player findById(Integer id);

	// Full URL: http://localhost:8080/BattleBoats/rest/players/username/hpotter
	Player findByUserName(String userName);

	// Full URL: http://localhost:8080/BattleBoats/rest/players/email/hpotter@hogwarts.ac.uk
	List<Player> findByEmail(String email);

	// Full URL: http://localhost:8080/BattleBoats/rest/players
	List<Player> findAll();

}