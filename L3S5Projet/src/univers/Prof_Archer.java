package univers;

public class Prof_Archer implements Profession, AttackFromDistance{
	@Override
	public void skillAction() {
		System.out.println("Archer performs a skill action!");
	};
	
	@Override
	public void attackFromDistance() {
		System.out.println("Archer performs a distance attack!");
	};
}
