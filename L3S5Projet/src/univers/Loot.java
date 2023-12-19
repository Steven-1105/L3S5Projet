package univers;

import java.util.List;

//Trophy category  
public class Loot {
	protected int experience;
	protected List<Item> items;//Item is known equipment, props

	// Not yet linked to character experience
	public Loot(int experience, List<Item> items) {
		this.experience = experience;
		this.items = items;
	}
}