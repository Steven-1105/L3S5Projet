package univers;

public abstract class Enemy {
	protected String name;
	protected int hp;
	protected int attack;
	
	public Enemy(String name, int hp, int attack) {
	    this.name = name;
	    this.hp = hp;
	    this.attack = attack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
}