package com.battleboats.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJPADAO {

	private PlayerJPADAO playerJPADAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PlayerJPADAO.getEntityManagerFactory();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PlayerJPADAO.getEntityManagerFactory().close();
	}

	@Before // Each Test, reset the dao
	public void setUp() throws Exception {
		playerJPADAO = new PlayerJPADAO();
	}

	@After // Each test, set dao to null (pseudo-cleanup)
	public void tearDown() throws Exception {
		playerJPADAO = null;
		//playerJPADAO.getEntityManager().createQuery("DELETE FROM Player where userName = 'ssnape'");
	}

	public Player makeSnape() {
		Player snape = new Player(-1, "ssnape");
		snape.setDisplayName("Severus Snape");
		snape.setAge(44);
		snape.setEmail("severus.snape@hogwarts.ac.uk");
		return snape;
	}

	@Test
	public void testInsert() {
		Player snape = makeSnape();
		playerJPADAO.insert(snape);
		assertTrue("Snape's ID is still -1!", snape.getId() > 0);
		Player foundSnape = playerJPADAO.findById(snape.getId());
		assertEquals("Wrong userName!", "ssnape", foundSnape.getUsername());
		assertEquals("Wrong DisplayName!", "Severus Snape", foundSnape.getDisplayName());
	}

	@Test
	public void testUpdate() {
		Player snape = playerJPADAO.findByEmail("severus.snape@hogwarts.ac.uk").get(0);
		if (snape == null) {
			snape = makeSnape();
			playerJPADAO.insert(snape);
		}
		snape.setRanking(993);
		Player foundSnape = playerJPADAO.findById(snape.getId());
		assertEquals("Ranking should have been 993", new Integer(993), foundSnape.getRanking());
	}

	@Test
	public void testDelete() {
		Player snape = playerJPADAO.findByEmail("severus.snape@hogwarts.ac.uk").get(0);
		if (snape == null) {
			snape = makeSnape();
			playerJPADAO.insert(snape);
		}
		Player deletedSnape = playerJPADAO.delete(snape);
		Player foundSnape = playerJPADAO.findById(snape.getId());
		assertNull("Should not find Snape after deleting him!", foundSnape);
	}

	@Test
	public void testFindById() {
		Player found = playerJPADAO.findById(1);
		assertEquals("Display Name is NOT 'Harry Potter' it's: " + found.getDisplayName(), "Harry Potter",
				found.getDisplayName());
		assertEquals("UserName is NOT hpotter!", "hpotter", found.getUsername());
	}

	@Test
	public void testFindByUserName() {
		Player harry = playerJPADAO.findByUserName("hpotter");
		assertNotNull("Harry should have been found by userId hpotter!", harry);
	}

	@Test
	public void testFindByEmail() {
		playerJPADAO.insert(makeSnape());
		List<Player> foundSnapes = playerJPADAO.findByEmail("severus.snape@hogwarts.ac.uk");
		assertNotNull("Didn't find ANY snapes by email 'severus.snape@hogwarts.ac.uk'!", foundSnapes);
		Player snape = foundSnapes.get(0);
		assertNotNull("Severus should have been found by email 'severus.snape@hogwarts.ac.uk'", snape);
	}

	@Test
	public void testFindAll() {
		int numPlayers = playerJPADAO.findAll().size();
		assertTrue("Not enough players in DB! Found " + numPlayers, numPlayers >= 3);
	}

}
