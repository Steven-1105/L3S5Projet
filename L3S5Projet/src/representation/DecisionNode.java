package representation;

import java.util.Scanner;

/**
 * Represents a node in the game's narrative structure where the player must make a decision.
 * This decision will affect the path taken through the narrative.
 */
public class DecisionNode extends InnerNode {
    // Attribute

    /** Scanner to read user input from the console. */
    private Scanner scanner;
    
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
        display(); // Show the decision text to the player
        int decision = 0;
        do {
            System.out.println("Make a decision (enter a number):");
            decision = scanner.nextInt();
        } while (decision < 1 || decision > getNextNodes().length); // Validate input

        // Return the Node corresponding to the player's choice
        return getNextNodes()[decision - 1];
    }
}
