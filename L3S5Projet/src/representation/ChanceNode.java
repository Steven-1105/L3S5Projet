package representation;

import java.util.Random;

/**
 * Represents a node in the game's narrative structure where the next path is determined randomly.
 * This type of node introduces an element of chance into the narrative flow.
 */
public class ChanceNode extends InnerNode {
    // Attribute

    /** Random number generator to determine the next node. */
    private transient Random random;
    
    // Constructors

    /**
     * Constructs a ChanceNode with a description.
     * Initializes a random number generator for determining the next node.
     *
     * @param description The description or situation presented to the player at this node.
     */
    public ChanceNode(String description) {
        super(description);
        this.random = new Random();
    }

    // Methods

    /**
     * Randomly chooses the next node from the available options.
     *
     * @return The next Node in the sequence determined randomly.
     */
    @Override
    public Node chooseNext() {
        display(); // Show the chance situation to the player
        if (!nextNodes.isEmpty()) {
            int choice = random.nextInt(nextNodes.size()); // Randomly select an index from available nodes
            return getNextNode(choice); // Return the Node corresponding to the random choice
        }
        return null; // or handle the situation where there are no next nodes
    }
}
