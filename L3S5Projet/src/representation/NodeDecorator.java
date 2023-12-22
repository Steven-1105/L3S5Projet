package representation;

/**
 * Represents a decorator for nodes in the game, providing additional functionality or information
 * while maintaining the same interface as a standard node.
 */
public abstract class NodeDecorator extends Node implements Event {
    /**
     * The node that this decorator wraps, adding additional behavior or state.
     */
    protected transient Node wrappedNode;

    /**
     * Constructs a NodeDecorator wrapping around an existing node.
     *
     * @param wrappedNode The node to be wrapped by this decorator.
     */
    public NodeDecorator(Node wrappedNode) {
        super(wrappedNode.getDescription()); // Use the description of the wrapped node
        this.wrappedNode = wrappedNode;
    }

    /**
     * Returns the wrapped node.
     *
     * @return The node that this decorator is enhancing or modifying.
     */
    public Node getWrappedNode() {
        return wrappedNode;
    }

    /**
     * Displays the description or content of the wrapped node.
     */
    @Override
    public void display() {
        wrappedNode.display();
    }

    /**
     * Delegates the choice of the next node to the wrapped node's logic.
     *
     * @return The next node as determined by the wrapped node.
     */
    @Override
    public Node chooseNext() {
        return wrappedNode.chooseNext();
    }
}
