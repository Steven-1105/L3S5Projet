package representation;

import java.util.Random;

public class ChanceNode extends InnerNode {
	//Attribut
	private Random random;
	
	//Constructeurs
	public ChanceNode(String description) {
		super(description);
		this.random = new Random();
	}

	@Override
	public Node chooseNext() {
		display();
		int choice = random.nextInt(nextNodes.length);

		// Returns a random node
		return nextNodes[choice];
	}
}