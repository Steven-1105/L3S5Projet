package backGround;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 * The Bgm class is responsible for managing and playing background music for the game.
 * It allows playing a new music file and stopping the currently playing music.
 */
public class Bgm {
	private static Player player = null; // Make it a member variable of the class
	 /**
     * Plays the specified music file. If any music is currently playing, it stops that music first.
     * The music is played in a new thread to avoid blocking the main application process.
     *
     * @param filepath The file path of the music to be played.
     */
	public static void playMusic(String filepath) {
		stopMusic();// Stop the music before playing a new file
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
	
	 /**
     * Stops the music that is currently playing. If no music is playing, this method does nothing.
     */
	public static void stopMusic() {
        if (player != null) {
            player.close(); // Stop the current music
            player = null;
        }
    }
	
}
