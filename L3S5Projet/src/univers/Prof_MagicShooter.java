package univers;

public class Prof_MagicShooter implements Profession, AttackFromDistance{
	@Override
	public void skillAction() {
		System.out.println("Magic Shooter performs a skill action!");
	};
	
	@Override
	public void attackFromDistance() {
		System.out.println("Magic Shooter performs a distance attack!");
	};
}
