package univers;

/**
 * Represents the villager NPC (Non-Player Character) in the game, capable of greeting, interaction, and trading.
 */
public class Npc_Villager extends BaseDeNpc{
	public Npc_Villager (String name, String description) {
		super(name, description);
	}

	@Override
	public String toString() {
	    return "Name: " + getName() + "\nDescription: " + getDescription();
	}

	/**
     * Greets the player with a jovial message.
     */
	@Override
	public void greeting() {
	    System.out.println("Gutentag young travaler");
	}

	/**
     * Interacts with the player by providing a context-specific message.
     */
	@Override
	public void interact() {
	    // Context  
	    System.out.println(this.getName() + " says: 'Hello, traveler!'");
	}

	// Task

	/**
     * Initiates trade with the player.
     */
	@Override
	public void trade() {
	    // Context
	    System.out.println(this.getName() + " wants to trade...");
	}
}
