package univers;

public abstract class Enemy {
	protected String name;
	protected int hp;
	protected int attack;
	protected int defense;
	protected boolean isAlive;

	public Enemy(String name, int hp, int attack, int defense) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.isAlive = true;
	}

	//Enemy Movements
	public abstract void performAttack();
	//Loot
	public abstract Loot dropLoot();


  
	//Setters & Getters
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
  
	public int getDefense() {
		return defense;
	}
  
	public void setDefense(int defense) {
		this.defense = defense;
	}
  
	public boolean isAlive() {
		return isAlive;
	}
  
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}