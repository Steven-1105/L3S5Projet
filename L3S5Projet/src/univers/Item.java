package univers;

/**
 * Represents a basic item within the game. This is an abstract class that other specific types of items can extend.
 */
public abstract class Item {
	private String name;

	 /**
     * Constructs a new Item with the given name.
     *
     * @param name The name of the item.
     */
	public Item(String name) {
		this.name = name;
	}
	
	/**
     * Gets the name of the item.
     *
     * @return The item's name.
     */
	public String getName() {
		return name;
	}

	/**
     * Sets the name of the item.
     *
     * @param name The new name for the item.
     */
	public void setName(String name) {
		this.name = name;
	}
}