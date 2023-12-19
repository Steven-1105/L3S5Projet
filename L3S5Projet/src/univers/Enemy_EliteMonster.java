package univers;

public class Enemy_EliteMonster extends Enemy {
	public Enemy_EliteMonster(String name, int hp, int attack, int defense) {
		super(name, hp, attack, defense);
	}
	
	@Override
	public void performAttack() {
	    if (/*use skills*/) {
	    	System.out.println(name + " uses a skill!");
	    } else {
	    	System.out.println(name + " performs a common attack!");
	    }
	}
	
	@Override
	public Loot dropLoot() {
		// drop the loot and experience
		return new Loot(200, /* items */);
	}
	
	@Override
	public String toString() {
		return "Enemy_EliteMonster []";
	}
}