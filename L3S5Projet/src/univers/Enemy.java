package univers;

/**
 * Abstract base class for enemy characters representing hostile entities in the game.
 */
public abstract class Enemy {
    /**
     * The name of the enemy.
     */
    protected String name;

    /**
     * The current health points (HP) of the enemy.
     */
    protected int hp;

    /**
     * The attack power of the enemy.
     */
    protected int attack;

    /**
     * Creates an enemy with the specified attributes.
     *
     * @param name   The name of the enemy.
     * @param hp     The current health points (HP) of the enemy.
     * @param attack The attack power of the enemy.
     */
    public Enemy(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    /**
     * Retrieves the name of the enemy.
     *
     * @return The name of the enemy.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the enemy.
     *
     * @param name The name to set for the enemy.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the current health points (HP) of the enemy.
     *
     * @return The current health points (HP) of the enemy.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sets the current health points (HP) of the enemy.
     *
     * @param hp The current health points (HP) to set for the enemy.
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Retrieves the attack power of the enemy.
     *
     * @return The attack power of the enemy.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Sets the attack power of the enemy.
     *
     * @param attack The attack power to set for the enemy.
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }
}