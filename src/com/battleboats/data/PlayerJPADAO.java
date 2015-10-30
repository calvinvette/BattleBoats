package com.battleboats.data;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class PlayerJPADAO {
	// JPA Uses Dependency Injection
	// PersistenceContext uses EntityManagerFactory to push in an instance
	// But ONLY in a "managed" environment like
	// Full JEE: JBoss Wildfly, WebSphere, GlassFish
	// But not in non-managed environments like:
	// Web Profile JEE - Tomcat, Jetty
	// Swing, JavaFX, Java "main" apps, JUnit tests
	@PersistenceContext
	private EntityManager entityManager;

	// Use EntityManagerFactory in non-managed cases
	@PersistenceUnit(unitName = "BattleBoats")
	private static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			// Painful, 1-time bootstrapping
			// Keep this semi-permanently in memory during application lifetime
			entityManagerFactory = Persistence.createEntityManagerFactory("BattleBoats");
		}
		return entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = getEntityManagerFactory().createEntityManager();
		}
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Player insert(Player player) {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			getEntityManager().persist(player); // INSERT INTO PLAYER, Gen ID
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return player;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Player update(Player player) {
		// Transient Objects: new or recently DB-deleted
		// Managed: auto-update
		// Detached: EM that found object earlier no longer in memory
		// merge() pushes a detached object back in to "managed" mode
		// forces updates to happen
		
		Player updatedPlayer = null;
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			updatedPlayer = getEntityManager().merge(player);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return updatedPlayer;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Player delete(Player player) {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			getEntityManager().remove(player); // DELETE FROM PLAYER WHERE...
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return player; // no longer valid player in DB
	}

	public Player findById(Integer id) {
		return getEntityManager().find(Player.class, id);
	}

	public Player findByUserName(String userName) {
		return null;
	}

	public List<Player> findByEmail(String email) {
		return null;
	}

	public List<Player> findAll() {
		return getEntityManager()
				.createQuery("select p from Player p", Player.class)
				.getResultList();
	}

}
