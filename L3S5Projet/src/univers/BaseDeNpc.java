package univers;

public abstract class BaseDeNpc {
	protected String name;
	protected String description;// Description of Npc, like it's a merchant...

	// private String dialogue;//Npc's talk, 如"young hero, do you have any question?"
	public BaseDeNpc(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	// Present the infomations of the Npc
	public String toString() {
	    return "Name: " + name + "\nDescription: " + description;
	}
	  
	  
	// greeting
	public void greeting() {
	    System.out.println();
	}

	// communicate
	public void interact() {
	    // context
	    System.out.println(this.name + " says: 'Hello, traveler!'");
	}

	// task

	// trade
	public void trade() {
	    //context
		
	    System.out.println(this.name + " wants to trade...");
	}
}
