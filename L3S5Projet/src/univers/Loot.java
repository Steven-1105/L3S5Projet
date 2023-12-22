package univers;

import java.util.List;

/**
 * Represents the loot gained after an encounter or event, including experience and items.
 */
public class Loot {
	protected int experience;
	protected List<Item> items;// Items known as equipment, props, etc.

	/**
     * Constructs a Loot object with specified experience and list of items.
     *
     * @param experience The amount of experience gained.
     * @param items      The list of items included in the loot.
     */
	public Loot(int experience, List<Item> items) {
		this.experience = experience;
		this.items = items;
	}
}