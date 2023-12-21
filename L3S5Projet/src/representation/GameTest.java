package representation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import gui.GameFrame;

public class GameTest {

    private Game game;
    private GameFrame gameFrame; // The real GameFrame is used here, or a simplified version of it.

    @Before
    public void setUp() {
        gameFrame = new GameFrame(); // a manually simulated GameFrame
        game = new Game(gameFrame);
    }

    @Test
    public void testGameInitialization() {
        assertNotNull("Game object should be created", game);
    }

    @Test
    public void testStartGame() {
        game.start();
    }

}

