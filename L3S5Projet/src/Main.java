import java.util.Scanner;

import gui.GameFrame;
import representation.*;
import univers.PlayerCharacter;
import univers.Race;
import univers.Boss;
import univers.Enemy;

/**
 * The main class to launch the text-based game.
 */
public class Main {
	/**
     * The main method to launch the game.
     *
     * @param args The command-line arguments (unused).
     */
    public static void main(String[] args) {
    	// Creating a game window
        GameFrame gameFrame = new GameFrame();
        gameFrame.launch();
        
        // Create a game instance and start
        Game game = new Game(gameFrame);
        game.start();    
    }
}
