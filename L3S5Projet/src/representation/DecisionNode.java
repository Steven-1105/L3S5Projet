package representation;

import java.util.Scanner;

/**
 * Represents a node in the game's narrative structure where the player must make a decision.
 * This decision will affect the path taken through the narrative.
 */
public class DecisionNode extends InnerNode {
    // Attribute

    /** Scanner to read user input from the console. */
    private transient Scanner scanner;
    
    // Constructors

    /**
     * Constructs a DecisionNode with a description.
     * Initializes a scanner to read user input for decision making.
     *
     * @param description The description or question presented to the player at this node.
     */
    public DecisionNode(String description) {
        super(description);
        this.scanner = new Scanner(System.in);
    }

    // Methods

    /**
     * Asks the player to make a decision and chooses the next node based on the player's input.
     * Repeatedly prompts the user until a valid choice is made.
     *
     * @return The next Node in the sequence based on the player's decision.
     */
    @Override
    public Node chooseNext() {
    	if (this.scanner == null) {
            this.scanner = new Scanner(System.in);
        }
        display(); // Show the decision text to the player
        
        if (nextNodes.isEmpty()) {
            System.out.println("No further paths are available from this point.");
            return null;
        }
        
        int decision = 0;
        while (decision < 1 || decision > nextNodes.size()) {
            System.out.println("Make a decision (enter a number 1-" + nextNodes.size() + "):");
            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
            } else {
                scanner.next(); // consume the invalid input
                System.out.println("Invalid input, please enter a number.");
            }
        }
//        System.out.println("Player chose option: " + decision);
//        System.out.println("Navigating to node: " + (decision - 1));
        // Return the Node corresponding to the player's choice
        return getNextNode(decision - 1); // Get the corresponding node based on user's choice
    }
}
