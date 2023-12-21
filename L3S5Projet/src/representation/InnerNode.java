package representation;

/**
 * Represents an inner node within the game's narrative structure.
 * This type of node typically has multiple paths or choices leading to different subsequent nodes.
 */
public class InnerNode extends Node {
    // Attributes

    /** The array of next possible nodes that can be reached from this node. */
    protected Node[] nextNodes;

    // Constructors

    /**
     * Constructs an InnerNode with a description.
     * By default, it initializes up to 2 possible branches from this node.
     *
     * @param description The description of the inner node.
     */
    public InnerNode(String description) {
        super(description);
        this.setNextNodes(new Node[2]); // Assuming up to 2 branches of nodes
    }

    // Methods

    /**
     * Displays the description of the node to the console.
     */
    @Override
    public void display() {
        System.out.println(description);
    }

    /**
     * Chooses the next node to proceed to.
     * This implementation returns the first node by default, but should be overridden to provide
     * actual logic for choosing the next node.
     *
     * @return The next Node in the sequence.
     */
    @Override
    public Node chooseNext() {
        return getNextNode(0); // Returns the first node by default
    }

    /**
     * Sets one of the next possible nodes at a given option index.
     *
     * @param option The index at which to set the node.
     * @param node   The next node to set.
     */
    public void setNextNode(int option, Node node) {
  	  if (option >= 0 && option < getNextNodes().length) {
  		getNextNodes()[option] = node;
  	  }
  	}
    
    /**
     * Gets the array of next possible nodes.
     *
     * @return The array of next nodes.
     */
    public Node[] getNextNodes() {
        return nextNodes;
    }

    /**
     * Sets the array of next possible nodes.
     *
     * @param nextNodes The array of next nodes to set.
     */
    public void setNextNodes(Node[] nextNodes) {
        this.nextNodes = nextNodes;
    }

    /**
     * Gets a specific next node given an index.
     *
     * @param i The index of the node to retrieve.
     * @return The Node at the specified index.
     */
    public Node getNextNode(int i) {
        return nextNodes[i];
    }
}
