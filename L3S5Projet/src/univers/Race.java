package univers;

public enum Race {
    ORC(200, 50, 20), 
    HUMAN(100, 100, 15),
    ELF(50, 200, 10);

    private final int hpBonus;
    private final int attackBonus;
    private final int mpBonus;

    Race(int hpBonus, int attackBonus, int mpBonus) {
        this.hpBonus = hpBonus;
        this.attackBonus = attackBonus;
        this.mpBonus = mpBonus;
    }

    public int getHpBonus() {
        return hpBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }
    
    public int getMpBonus() {
    	return mpBonus;
    }
}
