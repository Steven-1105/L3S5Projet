package univers;

import java.io.Serializable;

/**
 * A concrete subclass representing a powerful boss enemy in the game.
 */
public class Boss extends Enemy implements Serializable{

    /**
     * Creates a boss enemy with the specified attributes.
     *
     * @param name   The name of the boss.
     * @param hp     The current health points (HP) of the boss.
     * @param attack The attack power of the boss.
     */
    public Boss(String name, int hp, int attack) {
        super(name, hp, attack);
    }
}
