import java.util.Scanner;

import gui.GameFrame;
import representation.*;

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
        showStartMenu(game);    
    }
    
    private static void showStartMenu(Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Start New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
            	game.start(); 
                break;
            case 2:
                game.loadGame();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}