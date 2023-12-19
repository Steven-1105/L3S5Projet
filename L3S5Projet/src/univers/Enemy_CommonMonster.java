package univers;

public class Enemy_CommonMonster extends Enemy {
	public Enemy_CommonMonster(String name, int hp, int attack, int defense) {
		super(name, hp, attack, defense);
	}

	@Override
	public void performAttack() {
		System.out.println(name + " performs a common attack!");

	}

	@Override
	public Loot dropLoot() {
		// drop the loot and experience
		return new Loot(100, /*Items*/);
	}

	@Override
	public String toString() {
		return "Enemy_CommonMonster []";
	}
}