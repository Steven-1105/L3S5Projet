package Save;
import java.io.Serializable;


import representation.Node;
import univers.PlayerCharacter;
/**
 * The GameSaveState class represents the state of the game at a certain point, including the player's state and the current node in the game.
 */
public class GameSaveState implements Serializable {
    private PlayerCharacter player;
    private Node currentNode;

    /**
     * Constructs a new GameSaveState with the specified player and node.
     * 
     * @param player The player's current state.
     * @param currentNode The current node in the game.
     */
    public GameSaveState (PlayerCharacter player, Node currentNode) {
        this.player = player;
        this.currentNode = currentNode;
    }

    /**
     * Returns the player's state.
     * 
     * @return The player's state.
     */
    public PlayerCharacter getPlayer() {
        return player;
    }

    /**
     * Returns the current node in the game.
     * 
     * @return The current node.
     */
    public Node getCurrentNode() {
        return currentNode;
    }

    /**
     * Sets the player's state.
     * 
     * @param player The new player's state.
     */
    public void setPlayer(PlayerCharacter player) {
        this.player = player;
    }

    /**
     * Sets the current node in the game.
     * 
     * @param currentNode The new current node.
     */
    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }
}