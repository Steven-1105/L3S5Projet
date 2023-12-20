package representation;

public class TerminalNode extends Node {
	// Constructeurs
	public TerminalNode(String description) {
		super(description);
	}
	  
	// Méthodes
	@Override
	public void display() {
		System.out.println(description);
	}

	@Override
	public Node chooseNext() {
		// The end node returns to itself, because the game is over!
		return this;
	}
}