package univers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A test class for the PlayerCharacter class.
 */
public class PlayerCharacterTest {
    private PlayerCharacter player;

    @Before
    public void setUp() {
    	// Create a new player character object for testing purposes
        player = new PlayerCharacter("TestPlayer", Race.HUMAN);
    }

    /**
     * Test the initialization of the player character.
     */
    @Test
    public void playerInitializationTest() {
        assertEquals("Initial level should be 1", 1, player.getCurrentLevel());
        assertEquals("Initial experience should be 0", 0, player.getExperience());
    }
    
    /**
     * Test gaining experience points.
     */
    @Test
    public void experienceGainTest() {
        player.gainExperience(50);
        assertEquals("Experience should increase by 50", 50, player.getExperience());
    }

    /**
     * Test leveling up the player character.
     */
    @Test
    public void levelUpTest() {
        player.gainExperience(1000); // Assuming this is enough to upgrade the player
        assertTrue("Player should level up after gaining enough experience", player.getCurrentLevel() > 1);
    }

    /**
     * Test selecting a profession for the player character.
     */
    @Test
    public void professionSelectionTest() {
        player.gainExperience(10000); // Assuming this is enough to get the player to the level of the chosen profession
        assertNotNull("Player should have a profession after reaching level 10", player.getProfession());
    }
}