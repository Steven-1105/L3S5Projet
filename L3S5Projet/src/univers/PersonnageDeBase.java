package univers;

import java.util.Objects;

public class PersonnageDeBase {
	//Attributs
	protected String name;
	protected int hp;
	protected int mp;
	protected int attack;
	protected int defense;
	protected int speed; 
	protected boolean isAlive;
	protected Race race;// Race is assumed to be an enum that you will define

	//Constructeurs
	public PersonnageDeBase(String name, int hp, int mp, int attack, int defense, int speed, Race race) {
	    this.name = name;
	    this.hp = hp;
	    this.mp = mp;
	    this.attack = attack;
	    this.defense = defense;
	    this.speed = speed;
	    this.isAlive = true;
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
	           "defense = " + defense + "," +
	           "speed = " + speed + "," +
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
	           defense == that.defense &&
	           speed == that.speed &&
	           isAlive == that.isAlive &&
	           Objects.equals(name, that.name) &&
	           race == that.race;
	}
  
	@Override
	public int hashCode() {
	    return Objects.hash(name, hp, mp, attack, defense, speed, isAlive, race);
	}
	  
	//Protected methods for changing attributes, which can be overridden by subclasses if necessary
	protected void changeHP(int amount) {
	    this.hp += amount;
	}
	
	protected void changeMP(int amount) {
	    this.mp += amount;
	}
	
	protected void changeAttack(int amount) {
	    this.attack += amount;
	}
	
	protected void changeDefense(int amount) {
	    this.defense += amount;
	}
	
	protected void changeSpeed(int amount) {
	    this.speed += amount;
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
	  
	public int getDefense() {
	    return defense;
	}
	public void setDefense(int defense) {
	    this.defense = defense;
	}
	
	public int getSpeed() {
	    return speed;
	}
	
	public void setSpeed(int speed) {
	    this.speed = speed;
	}
	
	public boolean getAlive() {
	    return isAlive;
	}
	
	public void setAlive(boolean isAlive) {
	    this.isAlive = isAlive;
	}
	public Race getRace() {
	    return race;
	}
	  
}