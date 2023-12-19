package univers;

public class Npc_Merchant extends BaseDeNpc {
	public Npc_Merchant (String name, String description) {
		super(name, description);
	}

	@Override
	public String toString() {
		return "Name: " + getName() + "\nDescription: " + getDescription();
	}
	
	@Override
	public void greeting() {
	    System.out.println("Greeting traveler!");
	}

	// communicate
	@Override
	public void interact() {
		// context   
	    System.out.println(this.getName() + " says: 'Hello, traveler!'");
	}

	// task

	// trade
	@Override
	public void trade() {
	    // context
	    System.out.println(this.getName() + " wants to trade...");
	}
}