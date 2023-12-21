package representation;

/**
 * Represents a terminal node in the game's story, indicating an endpoint of a particular path or story arc.
 */
public class TerminalNode extends Node {

    /**
     * Constructs a TerminalNode with a given description.
     *
     * @param description The narrative description of the terminal node.
     */
    public TerminalNode(String description) {
        super(description);
    }

    /**
     * Displays the description of the terminal node, indicating an end of a story branch.
     */
    @Override
    public void display() {
        System.out.println(description);
    }

    /**
     * Since this is a terminal node, it does not lead to any next node. This method will return null.
     *
     * @return null as there are no further nodes to navigate to from a terminal node.
     */
    @Override
    public Node chooseNext() {
        // Terminal nodes do not lead to another node.
        return this;
    }
}
