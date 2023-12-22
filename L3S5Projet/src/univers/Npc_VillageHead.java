package univers;

/**
 * Represents the village head NPC (Non-Player Character) in the game, capable of greeting, interaction, and trading.
 */
public class Npc_VillageHead extends BaseDeNpc {
	public Npc_VillageHead (String name, String description) {
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
		System.out.println("young guys are full of energy，haha");
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