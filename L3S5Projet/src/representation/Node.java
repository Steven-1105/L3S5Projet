package representation;
/**
 * Represents an abstract Node in the game. It serves as a base for all specific types of nodes
 * within the game's narrative structure.
 */

public abstract class Node implements Event{
	// Attributs
	/** The description of the node. */
	protected String description;
	/** Static variable for generating unique ID for each instance. */
	private static int NEXTID = 1;// Variable statique permettant de générer l'identifiant unique suivant
	/** The unique ID of the node. */
	protected final int id;
	
	// Constructeurs
	/**
     * Constructs a new Node with the given description.
     *
     * @param description The description of the node.
     */
	public Node(String description) {
		this.description = description;
		this.id = NEXTID ++;
	}

	// Méthodes
	/**
     * Displays the node's content or description. This needs to be implemented by the subclass.
     */
	public abstract void display();
	
	/**
     * Determines and returns the next node based on the current node's logic.
     * This method must be implemented by the subclass.
     *
     * @return The next Node in the sequence.
     */
	public abstract Node chooseNext();// Default method, will be overridden in subclasses
	
	
	/**
     * Gets the unique ID of the node.
     *
     * @return The unique ID.
     */
	public int getId() {
		return id;
	}
	
	
	/**
     * Gets the description of the node.
     *
     * @return The description.
     */
	public String getDescription() {
		return description;
	}
}