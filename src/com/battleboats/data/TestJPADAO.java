package com.battleboats.data;

import static org.junit.Assert.*;

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
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		Player found = playerJPADAO.findById(1);
		assertEquals("Display Name is NOT 'Harry Potter' it's: " + found.getDisplayName(), 
				"Harry Potter",
				found.getDisplayName());
		assertEquals("UserName is NOT hpotter!", "hpotter", found.getUsername());
	}

	@Test
	public void testFindByUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		int numPlayers = playerJPADAO.findAll().size();
		assertTrue("Not enough players in DB! Found " + numPlayers, numPlayers >= 3);
	}

}
