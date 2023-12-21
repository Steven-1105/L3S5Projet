package representation;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an inner node within the game's narrative structure.
 * An inner node typically has multiple paths leading to various subsequent nodes, 
 * representing the choices or branches in the story. It's designed to dynamically
 * manage the collection of next possible nodes using an ArrayList, allowing for
 * runtime modifications to the narrative flow.
 */
public class InnerNode extends Node {
    // Attributes

	/**
     * A list of next possible nodes that can be reached from this node.
     * Stored in an ArrayList to facilitate dynamic additions and removals.
     */
	// 使用ArrayList来存储nextNodes，以便动态添加和移除节点
    protected List<Node> nextNodes;
    // Constructors

    /**
     * Constructs an InnerNode with a specified description.
     * Initializes the node with an empty list of next nodes, ready to be populated.
     *
     * @param description The narrative description of this node.
     */
    public InnerNode(String description) {
        super(description);
        this.nextNodes = new ArrayList<>(); // 初始化为空的ArrayList
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
     * Chooses and returns the next node to proceed to based on the current node's logic.
     * This base implementation simply returns the first node from the list of next nodes.
     * Override this method to implement custom navigation logic.
     *
     * @return The next Node in the sequence, or null if there are no next nodes.
     */
    @Override
    public Node chooseNext() {
    	return nextNodes.isEmpty() ? null : nextNodes.get(0);
    }
    
    /**
     * Dynamically adds a node to the list of next possible nodes.
     *
     * @param node The Node to add.
     */
    // 动态添加下一个可能的节点
    public void addNextNode(Node node) {
        nextNodes.add(node);
    }
    
    /**
     * Removes a node at a specific index from the list of next possible nodes.
     *
     * @param index The index of the node to remove.
     */
    // 根据索引移除一个节点
    public void removeNextNode(int index) {
        if (index >= 0 && index < nextNodes.size()) {
            nextNodes.remove(index);
        }
    }
    
    
    /**
     * Retrieves all the next possible nodes as an unmodifiable list.
     *
     * @return An unmodifiable view of the list of next nodes.
     */
    // 获取所有下一个可能的节点
    public List<Node> getNextNodes() {
        return nextNodes;
    }
    
    /**
     * Replaces the current list of next nodes with a new list provided.
     * This allows for bulk updates to the narrative structure.
     *
     * @param newNextNodes The new list of next nodes to set.
     */
    public void setNextNodes(List<Node> newNextNodes) {
        // 完全替换现有的nextNodes列表
        this.nextNodes = new ArrayList<>(newNextNodes);
    }


    /**
     * Retrieves a specific next node given an index. Returns null if the index is out of bounds.
     *
     * @param i The index of the node to retrieve.
     * @return The Node at the specified index or null if index is out of bounds.
     */
    public Node getNextNode(int i) {
    	return (i >= 0 && i < nextNodes.size()) ? nextNodes.get(i) : null;
    }
}
