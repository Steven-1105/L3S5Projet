package backGround;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 * A class responsible for playing background music in the game.
 */
public class Bgm {
	private static Player player = null; // Make it a member variable of the class
	 /**
     * Plays the specified music file.
     *
     * @param filepath The file path of the music to be played.
     */
	public static void playMusic(String filepath) {
		stopMusic();// Stop the music before
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            Player player = new Player(fileInputStream);

            // Create a new thread to play the music so as not to block the GUI or other processing.
            new Thread(() -> {
                try {
                    player.play(); // Play the music
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void stopMusic() {
        if (player != null) {
            player.close(); // Stop the current music
            player = null;
        }
    }
	
}
