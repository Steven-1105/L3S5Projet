package representation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import gui.GameFrame;

/**
 * Test class for the Game class in the representation package.
 * It uses JUnit to perform unit testing on various aspects of the Game class to ensure it works as expected.
 */
public class GameTest {

    private Game game;
    private GameFrame gameFrame; // The real GameFrame is used here, or a simplified version of it.

    /**
     * Sets up the testing environment before each test.
     * This method is called before the execution of each test method.
     */
    @Before
    public void setUp() {
        gameFrame = new GameFrame(); // a manually simulated GameFrame
        game = new Game(gameFrame);
    }

    /**
     * Test to ensure that the Game object is not null after initialization.
     * Asserts that the game object should have been created successfully.
     */
    @Test
    public void testGameInitialization() {
        assertNotNull("Game object should be created", game);
    }

    /**
     * Test to check the starting of the game.
     * This method runs the start method of the Game class and checks if the game starts without any exceptions.
     */
    @Test
    public void testStartGame() {
        game.start();
    }

}

