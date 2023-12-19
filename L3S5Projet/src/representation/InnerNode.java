package representation;

public class InnerNode extends Node {
	// Attributs
	protected Node[] nextNodes;

	// Constructeurs
	public InnerNode(String description) {
	  super(description);
	  this.nextNodes = new Node[2]; // Assuming up to 2 branches of nodes
	}

	// Méthodes

	@Override
	public void display() {
	  System.out.println(description);
	}

	@Override
	public Node chooseNext() {
	  // select next node
	  return nextNodes[0]; // returns the first node, which should actually be chosen based on logic
	}

	public void setNextNode(int option, Node node) {
	  if (option >= 0 && option < nextNodes.length) {
		nextNodes[option] = node;
	  }
	}
}