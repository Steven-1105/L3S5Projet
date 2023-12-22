package univers;

/**
 * The Race enum defines the different races available in the game, each with its own set of bonuses to health points (HP), magic points (MP), and attack value.
 */
public enum Race {
    ORC(200, 50, 20), 
    HUMAN(100, 100, 15),
    ELF(50, 200, 10);

    private final int hpBonus;
    private final int mpBonus;
    private final int attackBonus;
    

    /**
     * Constructs a Race with specified bonuses to HP, MP, and attack.
     * 
     * @param hpBonus The health point bonus for this race.
     * @param mpBonus The magic point bonus for this race.
     * @param attackBonus The attack value bonus for this race.
     */
    Race(int hpBonus, int mpBonus, int attackBonus) {
        this.hpBonus = hpBonus;
        this.mpBonus = mpBonus;
        this.attackBonus = attackBonus;
        
    }

    /**
     * Returns the health point bonus for this race.
     * 
     * @return The HP bonus.
     */
    public int getHpBonus() {
        return hpBonus;
    }

    /**
     * Returns the attack value bonus for this race.
     * 
     * @return The attack bonus.
     */
    public int getAttackBonus() {
        return attackBonus;
    }
    
    /**
     * Returns the magic point bonus for this race.
     * 
     * @return The MP bonus.
     */
    public int getMpBonus() {
    	return mpBonus;
    }
}
