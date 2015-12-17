package com.battleboats.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.battleboats.data.Player;
import com.battleboats.rest.IPlayerRESTService;

@ManagedBean(name = "playerManagedBean")
//@RequestScoped
@SessionScoped
public class PlayerManagedBean {
	private Player player = new Player();
	private List<Player> players = new ArrayList<>();
	IPlayerRESTService svc; // = new PlayerRESTService();

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
		Player found = svc.findById(getPlayer().getId());
		setPlayer(found);
		return "Player";
	}

	public String update() {
		setPlayer(svc.update(getPlayer()));
		return null;
	}
	
	public String delete() {
		svc.delete(getPlayer());
		setPlayer(new Player()); // Reset form to blank player
		return null;
	}
	
	public String add() {
		getPlayer().setId(-1);
		svc.insert(getPlayer());
		setPlayer(new Player()); // Reset form to blank player
		return null;
	}

	public String list() {
		setPlayers(svc.findAll());
		return "PlayerList";
	}
}
