package com.battleboats.data;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-10-29T16:36:43.545-0400")
@StaticMetamodel(Ship.class)
public class Ship_ {
	public static volatile SingularAttribute<Ship, Integer> id;
	public static volatile SingularAttribute<Ship, Double> fuel;
	public static volatile SingularAttribute<Ship, Integer> crew;
	public static volatile SingularAttribute<Ship, Integer> maxCrew;
	public static volatile SingularAttribute<Ship, Integer> crewMorale;
	public static volatile SingularAttribute<Ship, Double> foodStores;
	public static volatile SingularAttribute<Ship, Float> speedInKnots;
	public static volatile SingularAttribute<Ship, Float> armor;
	public static volatile SingularAttribute<Ship, String> appearance;
	public static volatile SingularAttribute<Ship, Float> health;
	public static volatile SingularAttribute<Ship, Float> detectability;
	public static volatile SingularAttribute<Ship, Boolean> radar;
	public static volatile SingularAttribute<Ship, Boolean> sonar;
	public static volatile SingularAttribute<Ship, Boolean> flagShip;
	public static volatile SingularAttribute<Ship, String> captain;
	public static volatile SingularAttribute<Ship, String> location;
	public static volatile SingularAttribute<Ship, Navy> navy;
}
