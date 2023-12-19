package representation;

import java.util.Scanner; //Utilisation d'une console

public class DecisionNode extends InnerNode {
	// Attribut
	private Scanner scanner;
	
	//Constructeurs
	public DecisionNode(String description) {
	  super(description);
	  this.scanner = new Scanner(System.in);
	}

	@Override
	public Node chooseNext() {
	  display();
	  int decision = 0;
	  do{
		  System.out.println("Make a decision (enter a number):");
		  decision = scanner.nextInt();
	  }while(decision < 1 && decision > nextNodes.length);

	  // Decide on next node based on user input
	  return nextNodes[decision-1];
	}
}