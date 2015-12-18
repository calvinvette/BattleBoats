package com.battleboats.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.battleboats.data.Player;
import com.battleboats.rest.IPlayerRESTService;

@ManagedBean(name = "playerManagedBean")
//@RequestScoped
@SessionScoped
public class PlayerManagedBean {
	private Player player = new Player();
	private List<Player> players = new ArrayList<>();
	
	@Inject
	IPlayerRESTService playerRESTService;
	
	//IPlayerRESTService svc = new MockPlayerRESTService();
	//IPlayerRESTService svc = new PlayerRESTService();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String find() {
		//setPlayer(new Player());
		Player found = playerRESTService.findById(getPlayer().getId());
		setPlayer(found);
		return "Player";
	}

	public String update() {
		playerRESTService.update(getPlayer());
		setPlayer(new Player()); // Reset form to blank player
		return null;
	}
	
	public String delete() {
		playerRESTService.delete(getPlayer());
		setPlayer(new Player()); // Reset form to blank player
		return null;
	}
	
	public String add() {
		getPlayer().setId(-1);
		playerRESTService.insert(getPlayer());
		setPlayer(new Player()); // Reset form to blank player
		return null;
	}

	public String list() {
		setPlayers(playerRESTService.findAll());
		return "PlayerList";
	}
}
