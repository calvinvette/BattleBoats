package com.battleboats.data;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-10-29T19:03:26.826-0400")
@StaticMetamodel(Player.class)
public class Player_ {
	public static volatile SingularAttribute<Player, Integer> id;
	public static volatile SingularAttribute<Player, String> username;
	public static volatile SingularAttribute<Player, String> password;
	public static volatile SingularAttribute<Player, String> email;
	public static volatile SingularAttribute<Player, Integer> subscriptionLevel;
	public static volatile SingularAttribute<Player, String> displayName;
	public static volatile SingularAttribute<Player, String> location;
	public static volatile SingularAttribute<Player, Integer> ranking;
	public static volatile SingularAttribute<Player, Integer> age;
	public static volatile SingularAttribute<Player, String> gender;
}
