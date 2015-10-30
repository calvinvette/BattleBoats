package com.battleboats.rest;

import java.util.List;

import javax.activation.MimeType;
import javax.mail.internet.ContentType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.battleboats.data.Player;
import com.battleboats.data.PlayerJPADAO;


// Full URL: http://localhost:8080/BattleBoats/rest/players
@Path("/players")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class PlayerRESTService {
	private PlayerJPADAO dao = new PlayerJPADAO();

	@POST
	public Player insert(Player player) {
		return dao.insert(player);
	}

	@PUT
	public Player update(Player player) {
		return dao.update(player);
	}

	@DELETE
	public Player delete(Player player) {
		return dao.delete(player);
	}

	@GET
	@Path("{id: \\d+}")
	// Full URL: http://localhost:8080/BattleBoats/rest/players/1234
	public Player findById(@PathParam("id") Integer id) {
		return dao.findById(id);
	}

	@GET
	@Path("/username/{userName}")
	// Full URL: http://localhost:8080/BattleBoats/rest/players/username/hpotter
	public Player findByUserName(@PathParam("userName") String userName) {
		return dao.findByUserName(userName);
	}

	@GET
	@Path("/email/{email}")
	// Full URL: http://localhost:8080/BattleBoats/rest/players/email/hpotter@hogwarts.ac.uk
	public List<Player> findByEmail(@PathParam("email") String email) {
		return dao.findByEmail(email);
	}

	@GET
	// Full URL: http://localhost:8080/BattleBoats/rest/players
	public List<Player> findAll() {
		return dao.findAll();
	}
	
	
	//@Path("/firstName/{first}/lastName/last")
	// Full URL: http://localhost:8080/BattleBoats/rest/firstName/Hermione/lastName/Granger
	//public List<Player> findByFirstLast(@PathParam("first") String firstName,
	//		@PathParam("last") lastName) { ... }
	
}
