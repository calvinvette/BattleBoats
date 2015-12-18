package com.battleboats.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ship", schema = "BATTLEBOATS")
public class Ship implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id = -1;
	
	// TODO - add in name and designation of ship
	
	
	private Double fuel;
	private Integer crew;
	private Integer maxCrew;
	private Integer crewMorale;
	
	private Double foodStores;
	private Float speedInKnots;
	private Float armor;
	private String appearance; // TODO - convert this to more complex object
	private Float health;
	private Float detectability;
	private Boolean radar;
	private Boolean sonar;
	
	private Boolean flagShip;
	private String captain; // TODO - add in Captain class w/ properties
	
	private String location; // TODO - flesh this out later... 2d/3d/4d
	// Artillery?
	// Ammo???
	
	@OneToOne
	private Navy navy;
	
	
	public Ship() {
	}
	
	

	public Ship(Double fuel, Integer crew, Integer maxCrew, Integer crewMorale, Double foodStores, Float speedInKnots,
			Float armor, String appearance, Float health, Float detectability, Boolean radar, Boolean sonar,
			Boolean flagShip, String captain, String location) {
		super();
		this.fuel = fuel;
		this.crew = crew;
		this.maxCrew = maxCrew;
		this.crewMorale = crewMorale;
		this.foodStores = foodStores;
		this.speedInKnots = speedInKnots;
		this.armor = armor;
		this.appearance = appearance;
		this.health = health;
		this.detectability = detectability;
		this.radar = radar;
		this.sonar = sonar;
		this.flagShip = flagShip;
		this.captain = captain;
		this.location = location;
	}



	public Ship(int id, Double fuel, Integer crew, Integer maxCrew, Integer crewMorale, Double foodStores,
			Float speedInKnots, Float armor, String appearance, Float health, Float detectability, Boolean radar,
			Boolean sonar, Boolean flagShip, String captain, String location) {
		super();
		this.id = id;
		this.fuel = fuel;
		this.crew = crew;
		this.maxCrew = maxCrew;
		this.crewMorale = crewMorale;
		this.foodStores = foodStores;
		this.speedInKnots = speedInKnots;
		this.armor = armor;
		this.appearance = appearance;
		this.health = health;
		this.detectability = detectability;
		this.radar = radar;
		this.sonar = sonar;
		this.flagShip = flagShip;
		this.captain = captain;
		this.location = location;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Double getFuel() {
		return fuel;
	}



	public void setFuel(Double fuel) {
		this.fuel = fuel;
	}



	public Integer getCrew() {
		return crew;
	}



	public void setCrew(Integer crew) {
		this.crew = crew;
	}



	public Integer getMaxCrew() {
		return maxCrew;
	}



	public void setMaxCrew(Integer maxCrew) {
		this.maxCrew = maxCrew;
	}



	public Integer getCrewMorale() {
		return crewMorale;
	}



	public void setCrewMorale(Integer crewMorale) {
		this.crewMorale = crewMorale;
	}



	public Double getFoodStores() {
		return foodStores;
	}



	public void setFoodStores(Double foodStores) {
		this.foodStores = foodStores;
	}



	public Float getSpeedInKnots() {
		return speedInKnots;
	}



	public void setSpeedInKnots(Float speedInKnots) {
		this.speedInKnots = speedInKnots;
	}



	public Float getArmor() {
		return armor;
	}



	public void setArmor(Float armor) {
		this.armor = armor;
	}



	public String getAppearance() {
		return appearance;
	}



	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}



	public Float getHealth() {
		return health;
	}



	public void setHealth(Float health) {
		this.health = health;
	}



	public Float getDetectability() {
		return detectability;
	}



	public void setDetectability(Float detectability) {
		this.detectability = detectability;
	}



	public Boolean getRadar() {
		return radar;
	}



	public void setRadar(Boolean radar) {
		this.radar = radar;
	}



	public Boolean getSonar() {
		return sonar;
	}



	public void setSonar(Boolean sonar) {
		this.sonar = sonar;
	}



	public Boolean getFlagShip() {
		return flagShip;
	}



	public void setFlagShip(Boolean flagShip) {
		this.flagShip = flagShip;
	}



	public String getCaptain() {
		return captain;
	}



	public void setCaptain(String captain) {
		this.captain = captain;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Navy getNavy() {
		return navy;
	}



	public void setNavy(Navy navy) {
		this.navy = navy;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((armor == null) ? 0 : armor.hashCode());
		result = prime * result + ((captain == null) ? 0 : captain.hashCode());
		result = prime * result + ((detectability == null) ? 0 : detectability.hashCode());
		result = prime * result + ((flagShip == null) ? 0 : flagShip.hashCode());
		result = prime * result + ((maxCrew == null) ? 0 : maxCrew.hashCode());
		result = prime * result + ((radar == null) ? 0 : radar.hashCode());
		result = prime * result + ((sonar == null) ? 0 : sonar.hashCode());
		result = prime * result + ((speedInKnots == null) ? 0 : speedInKnots.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (armor == null) {
			if (other.armor != null)
				return false;
		} else if (!armor.equals(other.armor))
			return false;
		if (captain == null) {
			if (other.captain != null)
				return false;
		} else if (!captain.equals(other.captain))
			return false;
		if (detectability == null) {
			if (other.detectability != null)
				return false;
		} else if (!detectability.equals(other.detectability))
			return false;
		if (flagShip == null) {
			if (other.flagShip != null)
				return false;
		} else if (!flagShip.equals(other.flagShip))
			return false;
		if (maxCrew == null) {
			if (other.maxCrew != null)
				return false;
		} else if (!maxCrew.equals(other.maxCrew))
			return false;
		if (radar == null) {
			if (other.radar != null)
				return false;
		} else if (!radar.equals(other.radar))
			return false;
		if (sonar == null) {
			if (other.sonar != null)
				return false;
		} else if (!sonar.equals(other.sonar))
			return false;
		if (speedInKnots == null) {
			if (other.speedInKnots != null)
				return false;
		} else if (!speedInKnots.equals(other.speedInKnots))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Ship [id=" + id + ", fuel=" + fuel + ", crew=" + crew + ", maxCrew=" + maxCrew + ", crewMorale="
				+ crewMorale + ", foodStores=" + foodStores + ", speedInKnots=" + speedInKnots + ", armor=" + armor
				+ ", appearance=" + appearance + ", health=" + health + ", detectability=" + detectability + ", radar="
				+ radar + ", sonar=" + sonar + ", flagShip=" + flagShip + ", captain=" + captain + ", location="
				+ location + ", navy=" + navy + "]";
	}



	
	
}
