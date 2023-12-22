package univers;

import java.io.Serializable;

/**
 * An abstract base class representing a non-player character (NPC) in the game.
 */
public abstract class BaseDeNpc implements Serializable{
	protected String name;
	protected String description;// Description of Npc, like it's a merchant...

	 /**
     * Creates an NPC with the specified name and description.
     *
     * @param name        The name of the NPC.
     * @param description The description of the NPC.
     */
	public BaseDeNpc(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
     * Gets the name of the NPC.
     *
     * @return The name of the NPC.
     */
	public String getName() {
		return name;
	}

	/**
     * Sets the name of the NPC.
     *
     * @param name The new name of the NPC.
     */
	public void setName(String name) {
	    this.name = name;
	}

	/**
     * Gets the description of the NPC.
     *
     * @return The description of the NPC.
     */
	public String getDescription() {
		return description;
	}

	/**
     * Sets the description of the NPC.
     *
     * @param description The new description of the NPC.
     */
	public void setDescription(String description) {
	    this.description = description;
	}

	/**
     * Returns a string representation of the NPC's information.
     *
     * @return A string containing the NPC's name and description.
     */
    @Override
	public String toString() {
	    return "Name: " + name + "\nDescription: " + description;
	}
	  
	  
    /**
     * Performs a greeting action for the NPC.
     */
	public void greeting() {
	    System.out.println(this.name + " says: 'Hello, traveler!'");
	}

	/**
     * Performs an interaction action for the NPC.
     */
	public void interact() {
	    // context
	    System.out.println(this.name + " says: 'Hello, traveler!'");
	}

	// task

	/**
     * Performs a trade action for the NPC.
     */
	public void trade() {
	    //context
		
	    System.out.println(this.name + " wants to trade...");
	}
}
