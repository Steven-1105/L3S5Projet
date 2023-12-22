package Save;
import java.io.*;

/**
 * The GameSave class provides static methods to save and load the game's state to and from a file.
 */
public class GameSave {
	/**
     * Saves the game state to a specified file.
     * 
     * @param filepath The path of the file where the game state will be saved.
     * @param gameState The game state to be saved.
     */
    public static void saveGame(String filepath, GameSaveState gameState) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(gameState);
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the game state from a specified file.
     * 
     * @param filepath The path of the file from where the game state will be loaded.
     * @return The loaded game state or null if an error occurred during loading.
     */
    public static GameSaveState loadGame(String filepath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            GameSaveState gameState = (GameSaveState) ois.readObject();
            System.out.println("Game loaded successfully.");
            return gameState;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
