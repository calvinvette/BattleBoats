package com.battleboats.data;
// Generated Oct 26, 2015 4:16:29 PM by Hibernate Tools 4.3.1.Final

import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Player generated by hbm2java
 * (formerly Player.hbm.xml in old Hibernate
 * ... can be META-INF/orm.xml in modern JPA)
 * 
 */
@Entity
@Table(name = "PLAYER", schema = "BATTLEBOATS" )
public class Player implements java.io.Serializable {

	private int id;
	private String username;
	private String password;
	private String email;
	private Integer subscriptionLevel;
	private String displayName;
	private String location;
	private Integer ranking;
	private Integer age;
	private String gender;
	private Blob avatar;  // Byte[]

	public Player() {	
	}

	public Player(int id, String username) {
		this.id = id;
		this.username = username;
	}

	public Player(int id, String username, String password, String email, Integer subscriptionLevel, String displayName,
			String location, Integer ranking, Integer age, String gender, Blob avatar) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.subscriptionLevel = subscriptionLevel;
		this.displayName = displayName;
		this.location = location;
		this.ranking = ranking;
		this.age = age;
		this.gender = gender;
		this.avatar = avatar;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "USERNAME", nullable = false, length = 40)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "EMAIL", length = 128)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "SUBSCRIPTION_LEVEL")
	public Integer getSubscriptionLevel() {
		return this.subscriptionLevel;
	}

	public void setSubscriptionLevel(Integer subscriptionLevel) {
		this.subscriptionLevel = subscriptionLevel;
	}

	@Column(name = "DISPLAY_NAME", length = 25)
	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name = "LOCATION", length = 50)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "RANKING")
	public Integer getRanking() {
		return this.ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "GENDER", length = 12)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "AVATAR")
	public Blob getAvatar() {
		return this.avatar;
	}

	public void setAvatar(Blob avatar) {
		this.avatar = avatar;
	}

}