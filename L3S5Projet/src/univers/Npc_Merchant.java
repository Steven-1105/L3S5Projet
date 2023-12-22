package univers;

/**
 * Represents a merchant NPC (Non-Player Character) in the game, capable of greeting, interaction, and trading.
 */
public class Npc_Merchant extends BaseDeNpc {
	public Npc_Merchant (String name, String description) {
		super(name, description);
	}

	@Override
	public String toString() {
		return "Name: " + getName() + "\nDescription: " + getDescription();
	}
	
	/**
     * Greets the player with a standard message.
     */
	@Override
	public void greeting() {
	    System.out.println("Greeting traveler!");
	}

	/**
     * Interacts with the player by providing a context-specific message.
     */
	@Override
	public void interact() {
		// context   
	    System.out.println(this.getName() + " says: 'Hello, traveler!'");
	}

	// task

	/**
     * Initiates trade with the player.
     */
	@Override
	public void trade() {
	    // context
	    System.out.println(this.getName() + " wants to trade...");
	}
}