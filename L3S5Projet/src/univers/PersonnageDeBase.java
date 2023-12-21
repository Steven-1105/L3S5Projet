package univers;

import java.util.Objects;

public class PersonnageDeBase {
	//Attributs
	protected String name;
	protected int hp;
	protected int mp;
	protected int attack;
	protected Race race;// Race is assumed to be an enum that you will define

	//Constructeurs
	public PersonnageDeBase(String name, int hp, int mp, int attack, Race race) {
	    this.name = name;
	    this.hp = hp;
	    this.mp = mp;
	    this.attack = attack;
	    this.race = race;
	}
	//Méthodes
	//The toString method is used to print the personnage's information.
	@Override
	public String toString() {
		return "Character {" +
	           "name = " + name + "," +
	           "hp = " + hp + "," +
	           "mp = " + mp + "," +
	           "attack = " + attack + "," +
	           "race = " + race +
	           '}';
	}
	
	//Réécrire la méthode equals and hashCode pour PersonnageDeBase
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    PersonnageDeBase that = (PersonnageDeBase) o;
	    return hp == that.hp &&
	           mp == that.mp &&
	           attack == that.attack &&
	           Objects.equals(name, that.name) &&
	           race == that.race;
	}
  
	@Override
	public int hashCode() {
	    return Objects.hash(name, hp, mp, attack, race);
	}
	  
	//Protected methods for changing attributes, which can be overridden by subclasses if necessary
	protected void changeHP(double amount) {
	    this.hp += amount;
	}
	
	protected void changeMP(double amount) {
	    this.mp += amount;
	}
	
	protected void changeAttack(double amount) {
	    this.attack += amount;
	}
  
	//**************Getters and setters**************
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
	    return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getMp() {
		return mp;
	}
	
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	public int getAttack() {
	    return attack;
	}
	
	public void setAttack(int attack) {
	    this.attack = attack;
	}
	
	public Race getRace() {
	    return race;
	}
	  
}