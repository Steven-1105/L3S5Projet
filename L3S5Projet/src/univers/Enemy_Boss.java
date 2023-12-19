package univers;

public class Enemy_Boss extends Enemy {
	public Enemy_Boss(String name, int hp, int attack, int defense) {
		super(name, hp, attack, defense);
	}

	@Override
	public void performAttack() {
		if (hp < (maxHp / 3)) {
			//increasing damqge
			int increasedDamage = (int)(attack * 0.3);//Only created but not be used in the code
	        System.out.println(name + " is enraged and performs a powerful attack with extra " + increasedDamage + " damage!");
	    } else if (/* use skills */) {
	        System.out.println(name + " uses a skill!");
	    } else {
	        System.out.println(name + " performs a common attack!");
	    }
	}

	@Override
	public Loot dropLoot() {
		// drop the loot and experience
	    return new Loot(500, /* items */);
	}

	@Override
	public String toString() {
		return "Enemy_Boss []";
	}
}