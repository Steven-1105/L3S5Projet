package representation;

/**
 * The Event interface represents a general action or occurrence within the game.
 */
public interface Event {

    /**
     * Displays the event, typically by printing out some information to the console.
     */
    void display();

    /**
     * Chooses the next node based on the current event's logic.
     * 
     * @return The next Node to proceed to after the current event.
     */
    Node chooseNext();
}
