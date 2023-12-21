package univers;

public enum Race {
    ORC(200, 50, 20), 
    HUMAN(100, 100, 15),
    ELF(50, 200, 10);

    private final int hpBonus;
    private final int mpBonus;
    private final int attackBonus;
    

    Race(int hpBonus, int mpBonus, int attackBonus) {
        this.hpBonus = hpBonus;
        this.mpBonus = mpBonus;
        this.attackBonus = attackBonus;
        
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
