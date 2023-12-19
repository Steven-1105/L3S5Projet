package univers;

public class Prof_NecroMancer implements Profession, AttackFromDistance {
	  @Override
	  public void skillAction() {
	    System.out.println("Necromancer performs a skill action!");
	  };

	  @Override
	  public void attackFromDistance() {
	    System.out.println("Necromancer performs a distance attack!");
	  }

}