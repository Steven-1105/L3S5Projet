package representation;

public class InnerNode extends Node {
	// Attributs
	protected Node[] nextNodes;

	// Constructeurs
	public InnerNode(String description) {
	  super(description);
	  this.setNextNodes(new Node[2]); // Assuming up to 2 branches of nodes
	}

	// Méthodes

	@Override
	public void display() {
	  System.out.println(description);
	}

	@Override
	public Node chooseNext() {
	  return getNextNode(0); // returns the first node, which should actually be chosen based on logic
	}

	public void setNextNode(int option, Node node) {
	  if (option >= 0 && option < getNextNodes().length) {
		getNextNodes()[option] = node;
	  }
	}

	public Node[] getNextNodes() {
		return nextNodes;
	}

	public void setNextNodes(Node[] nextNodes) {
		this.nextNodes = nextNodes;
	}

	public Node getNextNode(int i) {
		return nextNodes[i];
	}
}