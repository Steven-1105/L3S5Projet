package univers;

public class Npc_VillageHead extends BaseDeNpc {
	public Npc_VillageHead (String name, String description) {
		super(name, description);
	}

	@Override
	public String toString() {
		return "Name: " + getName() + "\nDescription: " + getDescription();
	}
  
	@Override
	public void greeting() {
		System.out.println("young guys are full of energy，haha");
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