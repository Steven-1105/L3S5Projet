package univers;

public class Npc_Villager extends BaseDeNpc{
	public Npc_Villager (String name, String description) {
		super(name, description);
	}

	@Override
	public String toString() {
	    return "Name: " + getName() + "\nDescription: " + getDescription();
	}

	@Override
	public void greeting() {
	    System.out.println("Gutentag young travaler");
	}

	// Communication
	@Override
	public void interact() {
	    // Context  
	    System.out.println(this.getName() + " says: 'Hello, traveler!'");
	}

	// Mission

	// Trading
	@Override
	public void trade() {
	    // Context
	    System.out.println(this.getName() + " wants to trade...");
	}
}
