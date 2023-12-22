package univers;

import java.util.Objects;

/**
 * A base class representing a character in the game.
 */
public class PersonnageDeBase {
	//Attributs
	protected String name;
	protected int hp;
	protected int mp;
	protected int attack;
	protected Race race;// Race is assumed to be an enum that you will define

	//Constructeurs
	/**
     * Creates a character with the specified attributes.
     *
     * @param name   The name of the character.
     * @param hp     The current health points (HP) of the character.
     * @param mp     The current mana points (MP) of the character.
     * @param attack The attack power of the character.
     * @param race   The race of the character (an enum).
     */
	public PersonnageDeBase(String name, int hp, int mp, int attack, Race race) {
	    this.name = name;
	    this.hp = hp;
	    this.mp = mp;
	    this.attack = attack;
	    this.race = race;
	}
	//Méthodes
	//The toString method is used to print the personnage's information.
	/**
     * Returns a string representation of the character's information.
     *
     * @return A string containing the character's name, HP, MP, attack, and race.
     */
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
	/**
     * Compares this character to another object for equality.
     *
     * @param o The object to compare with.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
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
	
	/**
     * Computes a hash code for this character.
     *
     * @return A hash code value based on the character's attributes.
     */
	@Override
	public int hashCode() {
	    return Objects.hash(name, hp, mp, attack, race);
	}
	  
	//Protected methods for changing attributes, which can be overridden by subclasses if necessary
	/**
     * Changes the character's HP by the specified amount.
     *
     * @param amount The amount by which to change the HP.
     */
	protected void changeHP(double amount) {
	    this.hp += amount;
	}
	
	/**
     * Changes the character's MP by the specified amount.
     *
     * @param amount The amount by which to change the MP.
     */
	protected void changeMP(double amount) {
	    this.mp += amount;
	}
	
	/**
     * Changes the character's attack power by the specified amount.
     *
     * @param amount The amount by which to change the attack power.
     */
	protected void changeAttack(double amount) {
	    this.attack += amount;
	}
  
	//**************Getters and setters**************
	/**
     * Gets the name of the character.
     *
     * @return The name of the character.
     */
	public String getName() {
		return name;
	}
	
	/**
     * Sets the name of the character.
     *
     * @param name The new name of the character.
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * Gets the current health points (HP) of the character.
     *
     * @return The current HP of the character.
     */
	public int getHp() {
	    return hp;
	}
	
	/**
     * Sets the current health points (HP) of the character.
     *
     * @param hp The new HP value.
     */
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	/**
     * Gets the current mana points (MP) of the character.
     *
     * @return The current MP of the character.
     */
	public int getMp() {
		return mp;
	}
	
	/**
     * Sets the current mana points (MP) of the character.
     *
     * @param mp The new MP value.
     */
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	/**
     * Gets the attack power of the character.
     *
     * @return The attack power of the character.
     */
	public int getAttack() {
	    return attack;
	}
	
	/**
     * Sets the attack power of the character.
     *
     * @param attack The new attack power value.
     */
	public void setAttack(int attack) {
	    this.attack = attack;
	}
	
	/**
     * Gets the race of the character.
     *
     * @return The race of the character.
     */
	public Race getRace() {
	    return race;
	}  
}